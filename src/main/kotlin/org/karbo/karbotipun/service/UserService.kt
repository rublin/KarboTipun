package org.karbo.karbotipun.service

import org.karbo.karbotipun.dto.TelegramUserDto
import org.karbo.karbotipun.model.Role
import org.karbo.karbotipun.model.User
import org.karbo.karbotipun.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.lang.StringBuilder
import java.util.*
import javax.transaction.Transactional

@Service
class UserService(
    val userRepository: UserRepository
) {

    val logger = LoggerFactory.getLogger(this.javaClass)

    fun findOrCreate(dto: TelegramUserDto): User {
        var user = userRepository.findByTelegramId(dto.id)

        if (user == null) {
            user = create(dto)
        }

        return user
    }
    @Transactional
    fun create(dto: TelegramUserDto): User {
        var randomPaymentId: String

        do {
            randomPaymentId = randomPaymentId()
            val optionUser = userRepository.findByPaymentId(randomPaymentId)
        } while (optionUser != null)

        val user = User(
            telegramId = dto.id,
            nickname = dto.userName,
            firstName = dto.firstName,
            lastName = dto.lastName,
            paymentId = randomPaymentId,
            role = Role.USER
        )

        val saved = userRepository.save(user)

        logger.info("new $saved user created")

        return saved
    }

    private fun randomPaymentId(): String {
        val random = Random()
        val stringBuilder = StringBuilder()

        while (stringBuilder.length < 64) {
            stringBuilder.append(random.nextInt().toUInt().toString(16))
        }

        return stringBuilder.toString().substring(0, 64).uppercase()
    }
}