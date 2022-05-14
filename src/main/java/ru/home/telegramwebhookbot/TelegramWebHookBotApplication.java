package ru.home.telegramwebhookbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TelegramWebHookBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramWebHookBotApplication.class, args);
    }

}
