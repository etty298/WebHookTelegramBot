package ru.home.telegramwebhookbot.botapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@PropertySource("classpath:messages.properties")
public class Handler {
    @Value("${reply.chooseType}")
    private String chooseType;
    @Value("${reply.speciality}")
    private String speciality;

}
