package org.karbo.karbotipun.model

import java.math.BigInteger
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var telegramId: Long,
    var nickname: String? = null,
    var balance: BigInteger = BigInteger.ZERO,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var firstName: String? = null,
    var lastName: String? = null,
    var paymentId: String,

    @Enumerated(EnumType.STRING)
    var role: Role
)
