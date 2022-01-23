package org.karbo.karbotipun.dto

data class TelegramUserDto(
    val id: Long,
    val firstName: String? = null,
    val lastName: String? = null,
    val userName: String? = null
)
