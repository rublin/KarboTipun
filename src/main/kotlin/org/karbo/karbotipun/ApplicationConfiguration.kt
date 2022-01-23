package org.karbo.karbotipun

import org.karbo.karbotipun.service.TelegramService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Configuration
class ApplicationConfiguration(
    val telegramService: TelegramService
) {

    @Bean
    fun telegramApi(): TelegramBotsApi {
        val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
        telegramBotsApi.registerBot(telegramService)

        return telegramBotsApi
    }
}