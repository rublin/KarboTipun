package org.karbo.karbotipun.repository

import org.karbo.karbotipun.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByTelegramId(telegramId: Long): User?
    fun findByPaymentId(paimentId: String): User?
}