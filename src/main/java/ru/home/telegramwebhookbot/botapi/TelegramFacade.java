package ru.home.telegramwebhookbot.botapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
@Slf4j
public class TelegramFacade {
    @Autowired
    private Handler handler;
    private String state = "";

    public SendMessage handleUpdate(Update update) {
        SendMessage replyMessage = null;

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            log.info("New message from User:{}, chatId: {},  with text: {}",
                    message.getFrom().getUserName(), message.getChatId(), message.getText());
            replyMessage = handleInputMessage(message);
        }

        return replyMessage;
    }

    private SendMessage handleInputMessage(Message message) {
        long chatId = message.getChatId();
        SendMessage sendMessage = null;
        if (state.equals("Исследовательский")) {
            switch (message.getText()) {
                case "Математика":
                    sendMessage = new SendMessage(chatId, handler.getMathRes());
                    break;
                case "Информатика":
                    sendMessage = new SendMessage(chatId, handler.getItRes());
                    break;
                case "История":
                    sendMessage = new SendMessage(chatId, handler.getHistoryRes());
                    break;
                case "География":
                    sendMessage = new SendMessage(chatId, handler.getGeographyRes());
                    break;
                case "Биология":
                    sendMessage = new SendMessage(chatId, handler.getBiologyRes());
                    break;
                case "Русский":
                    sendMessage = new SendMessage(chatId, handler.getRussianRes());
                    break;
                case "Литература":
                    sendMessage = new SendMessage(chatId, handler.getLiteratureRes());
                    break;
                case "Английский":
                    sendMessage = new SendMessage(chatId, handler.getEnglishRes());
                    break;
                case "Физика":
                    sendMessage = new SendMessage(chatId, handler.getPhysicsRes());
                    break;
                case "Обществознание":
                    sendMessage = new SendMessage(chatId, handler.getSocialRes());
                    break;
                case "Физкультура":
                    sendMessage = new SendMessage(chatId, handler.getPeRes());
                    break;
                case "Исследовательский":
                    state = "Исследовательский";
                    break;
                case "Практический":
                    state = "Практический";
                    break;
                default:
                    sendMessage = new SendMessage(chatId, "Неизвестный предмет");

            }
        } else if (state.equals("Практический")) {
            switch (message.getText()) {
                case "Математика":
                    sendMessage = new SendMessage(chatId, handler.getMathPrac());
                    break;
                case "Информатика":
                    sendMessage = new SendMessage(chatId, handler.getItPrac());
                    break;
                case "История":
                    sendMessage = new SendMessage(chatId, handler.getHistoryPrac());
                    break;
                case "География":
                    sendMessage = new SendMessage(chatId, handler.getGeographyPrac());
                    break;
                case "Биология":
                    sendMessage = new SendMessage(chatId, handler.getBiologyPrac());
                    break;
                case "Русский":
                    sendMessage = new SendMessage(chatId, handler.getRussianPrac());
                    break;
                case "Литература":
                    sendMessage = new SendMessage(chatId, handler.getLiteraturePrac());
                    break;
                case "Английский":
                    sendMessage = new SendMessage(chatId, handler.getEnglishPrac());
                    break;
                case "Физика":
                    sendMessage = new SendMessage(chatId, handler.getPhysicsPrac());
                    break;
                case "Обществознание":
                    sendMessage = new SendMessage(chatId, handler.getSocialPrac());
                    break;
                case "Физкультура":
                    sendMessage = new SendMessage(chatId, handler.getPePrac());
                    break;
                case "Исследовательский":
                    state = "Исследовательский";
                    sendMessage = new SendMessage(chatId, "Выберите предмет");
                    break;
                case "Практический":
                    state = "Практический";
                    sendMessage = new SendMessage(chatId, "Выберите предмет");
                    break;
                default:
                    sendMessage = new SendMessage(chatId, "Неизвестный предмет");

            }
        } else {
            switch (message.getText()) {
                case "/start":
                    sendMessage = new SendMessage(chatId, "Введите тип проекта");
                    break;
                case "Исследовательский":
                    state = "Исследовательский";
                    sendMessage = new SendMessage(chatId, "Выберите предмет");
                    break;
                case "Практический":
                    state = "Практический";
                    sendMessage = new SendMessage(chatId, "Выберите предмет");
                    break;
                default:
                    sendMessage = new SendMessage(chatId, "Ошибка");
            }
        }

        return sendMessage;
    }

}