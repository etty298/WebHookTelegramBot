package ru.home.telegramwebhookbot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiConstants;
import org.telegram.telegrambots.meta.ApiContext;
import ru.home.telegramwebhookbot.TelegramWebHookBot;
import ru.home.telegramwebhookbot.botapi.TelegramFacade;


@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;

    private DefaultBotOptions.ProxyType proxyType;
    private String proxyHost;
    private int proxyPort;

    @Bean
    public TelegramWebHookBot telegramWebHookBot(TelegramFacade telegramFacade) {
        DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);

        //options.setProxyHost(proxyHost);
        //options.setProxyPort(proxyPort);
        //options.setProxyType(proxyType);

        TelegramWebHookBot telegramWebHookBot = new TelegramWebHookBot(options, telegramFacade);
        telegramWebHookBot.setBotUserName(botUserName);
        telegramWebHookBot.setBotToken(botToken);
        telegramWebHookBot.setWebHookPath(webHookPath);

        return telegramWebHookBot;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
