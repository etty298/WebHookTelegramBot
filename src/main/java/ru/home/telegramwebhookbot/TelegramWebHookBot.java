package ru.home.telegramwebhookbot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.home.telegramwebhookbot.botapi.TelegramFacade;

public class TelegramWebHookBot extends TelegramWebhookBot {
    private TelegramFacade telegramFacade;
    private String webHookPath;
    private String botUsername;
    private String botToken;

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    public TelegramWebHookBot(DefaultBotOptions defaultBotOptions, TelegramFacade telegramFacade) {
        super(defaultBotOptions);
        this.telegramFacade = telegramFacade;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }

    public void setBotUserName(String botUsername) {
        this.botUsername = botUsername;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        SendMessage replyMessage = telegramFacade.handleUpdate(update);
        return replyMessage;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }
}
