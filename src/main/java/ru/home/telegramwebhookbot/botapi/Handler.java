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
    @Value("${reply.research.math}")
    private String mathRes;
    @Value("${reply.research.it}")
    private String itRes;
    @Value("${reply.research.history}")
    private String historyRes;
    @Value("${reply.research.geography}")
    private String geographyRes;
    @Value("${reply.research.biology}")
    private String biologyRes;
    @Value("${reply.research.russian}")
    private String russianRes;
    @Value("${reply.research.literature}")
    private String literatureRes;
    @Value("${reply.research.english}")
    private String englishRes;
    @Value("${reply.research.physics}")
    private String physicsRes;
    @Value("${reply.research.social}")
    private String socialRes;
    @Value("${reply.research.pe}")
    private String peRes;

    @Value("${reply.practical.math}")
    private String mathPrac;
    @Value("${reply.practical.it}")
    private String itPrac;
    @Value("${reply.practical.history}")
    private String historyPrac;
    @Value("${reply.practical.geography}")
    private String geographyPrac;
    @Value("${reply.practical.biology}")
    private String biologyPrac;
    @Value("${reply.practical.russian}")
    private String russianPrac;
    @Value("${reply.practical.literature}")
    private String literaturePrac;
    @Value("${reply.practical.english}")
    private String englishPrac;
    @Value("${reply.practical.physics}")
    private String physicsPrac;
    @Value("${reply.practical.social}")
    private String socialPrac;
    @Value("${reply.practical.pe}")
    private String pePrac;

}
