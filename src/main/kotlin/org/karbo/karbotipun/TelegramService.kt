package org.karbo.karbotipun

import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

@Service
class TelegramService(
    @Value("\${telegram.token}") val token: String,
    @Value("\${telegram.name}") val botName: String

): TelegramLongPollingBot() {
    val logger = LogFactory.getLog(this.javaClass)

    override fun getBotToken(): String {
        return token
    }

    override fun getBotUsername(): String {
        return botName
    }

    override fun onUpdateReceived(update: Update) {
       if (update.message == null) return

        val user = update.message.from
//        we are interested only in updates with text
        val text = update.message.text ?: return

        logger.info("Message $text received from $user")

        execute(SendMessage(user.id.toString(), text))
    }
}