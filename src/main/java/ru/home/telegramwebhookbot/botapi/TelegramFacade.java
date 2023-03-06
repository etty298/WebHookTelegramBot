package ru.home.telegramwebhookbot.botapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;


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
            switch (message.getText()) {
                case "/start":
                    sendMessage = new SendMessage(chatId, "Вы можете найти подходящий для вас ВУЗ");
                    setFirstButtons(sendMessage);
                    break;

                case "Выбрать направление ВУЗа":
                    sendMessage = new SendMessage(chatId, handler.getChooseType());
                    setTypesButtons(sendMessage);
                    break;

                case "Управление и экономика":
                    sendMessage = new SendMessage(chatId, handler.getSpeciality());
                    setRulingButtons(sendMessage);
                    break;

                case "Управление":
                    sendMessage = new SendMessage(chatId, "anvca k");
                    setTypesButtons(sendMessage);
                    break;

                case "Экономика и финансы":
                    sendMessage = new SendMessage(chatId, "skcaacacak");
                    setTypesButtons(sendMessage);
                    break;

                case "Туризм и гостеприимство":
                    sendMessage = new SendMessage(chatId, "skscaacacak");
                    setTypesButtons(sendMessage);
                    break;

                case "Маркетинг":
                    sendMessage = new SendMessage(chatId, "skscafaacacak");
                    setTypesButtons(sendMessage);
                    break;

                case "Гуманитарные и социальные науки":
                    sendMessage = new SendMessage(chatId, handler.getSpeciality());
                    setHumanityButtons(sendMessage);
                    break;

                case "Право":
                    sendMessage = new SendMessage(chatId, "sksфафаафафcafaacacak");
                    setTypesButtons(sendMessage);
                    break;

                case "Филология и лингвистика":
                    sendMessage = new SendMessage(chatId, "sksфафааcafaacacak");
                    setTypesButtons(sendMessage);
                    break;


                case "Физическая культура и спорт":
                    sendMessage = new SendMessage(chatId, "sksфафаафафcak");
                    setTypesButtons(sendMessage);
                    break;


                case "Международные отношения":
                    sendMessage = new SendMessage(chatId, "sksфафаафаaacacak");
                    setTypesButtons(sendMessage);
                    break;

                case "Информационные технологии":
                    sendMessage = new SendMessage(chatId, handler.getSpeciality());
                    setItButtons(sendMessage);
                    break;

                case "Программирование":
                    sendMessage = new SendMessage(chatId, "sksфаафаaacacak");
                    setTypesButtons(sendMessage);
                    break;

                case "IT-менеджмент":
                    sendMessage = new SendMessage(chatId, "sksфафаафаaacak");
                    setTypesButtons(sendMessage);
                    break;

                case "Информационная безопасность":
                    sendMessage = new SendMessage(chatId, "sфафаафаaacacak");
                    setTypesButtons(sendMessage);
                    break;

                case "Телекоммуникации и связь":
                    sendMessage = new SendMessage(chatId, "sksфафаафаaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Техника и технологии":
                    sendMessage = new SendMessage(chatId, handler.getSpeciality());
                    setTechButtons(sendMessage);
                    break;

                case "Машиностроение и робототехника":
                    sendMessage = new SendMessage(chatId, "sksфаgsgfaфаафаaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Энергетика":
                    sendMessage = new SendMessage(chatId, "sksфафhgаафаaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Нанотехнологии":
                    sendMessage = new SendMessage(chatId, "sksфафа;dафаaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Авиация и ракетостроение":
                    sendMessage = new SendMessage(chatId, "sksфафаафаdvewvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Медиа, дизайн и архитектура":
                    sendMessage = new SendMessage(chatId, handler.getSpeciality());
                    setMediaButtons(sendMessage);
                    break;

                case "Медиа и коммуникации":
                    sendMessage = new SendMessage(chatId, "sksфafafафаафаdvewvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Дизайн":
                    sendMessage = new SendMessage(chatId, "sksфафаdvewvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Архитектура и урбанистика":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Точные и естесвенные науки":
                    sendMessage = new SendMessage(chatId, handler.getSpeciality());
                    setScienceButtons(sendMessage);
                    break;

                case "Биология и биотехника":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Химия и химические технологии":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Математика и физика":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "География и гидрометеорология":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Безопасность и военное дело":
                    sendMessage = new SendMessage(chatId, handler.getSpeciality());
                    setSafetyButtons(sendMessage);
                    break;

                case "Безопасность":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Военное дело, госбезопасность":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Искусство и творчество":
                    sendMessage = new SendMessage(chatId, handler.getSpeciality());
                    setArtButtons(sendMessage);
                    break;

                case "Живопись и скульптура":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Музыка и хореография":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Актёрское мастерство":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Искусствоведение":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Медицина и здравоохранение":
                    sendMessage = new SendMessage(chatId, handler.getSpeciality());
                    setMedicineButtons(sendMessage);
                    break;

                case "Лечебное дело":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Ветеринария":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Фармация и фармакология":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;

                case "Медицинские технологии":
                    sendMessage = new SendMessage(chatId, "sksфафааvaaak");
                    setTypesButtons(sendMessage);
                    break;


                default:
                    sendMessage = new SendMessage(chatId, "Такой команды нет. Ошибка!");

        }

        return sendMessage;
    }

    public void setFirstButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Выбрать направление ВУЗа"));
        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void setTypesButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Управление и экономика"));
        keyboardFirstRow.add(new KeyboardButton("Гуманитарные и социальные науки"));
        keyboardFirstRow.add(new KeyboardButton("Информационные технологии"));
        keyboardSecondRow.add(new KeyboardButton("Техника и технологии"));
        keyboardSecondRow.add(new KeyboardButton("Медиа, дизайн и архитектура"));
        keyboardSecondRow.add(new KeyboardButton("Точные и естесвенные науки"));
        keyboardThirdRow.add(new KeyboardButton("Безопасность и военное дело"));
        keyboardThirdRow.add(new KeyboardButton("Искусство и творчество"));
        keyboardThirdRow.add(new KeyboardButton("Медицина и здравоохранение"));
        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        keyboardRowList.add(keyboardThirdRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void setRulingButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Управление"));
        keyboardFirstRow.add(new KeyboardButton("Экономика и финансы"));
        keyboardSecondRow.add(new KeyboardButton("Туризм и гостеприимство"));
        keyboardSecondRow.add(new KeyboardButton("Маркетинг"));
        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void setHumanityButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Право"));
        keyboardFirstRow.add(new KeyboardButton("Филология и лингвистика"));
        keyboardSecondRow.add(new KeyboardButton("Физическая культура и спорт"));
        keyboardSecondRow.add(new KeyboardButton("Международные отношения"));
        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void setItButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Программирование"));
        keyboardFirstRow.add(new KeyboardButton("IT-менеджмент"));
        keyboardSecondRow.add(new KeyboardButton("Информационная безопасность"));
        keyboardSecondRow.add(new KeyboardButton("Телекоммуникации и связь"));
        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void setTechButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Машиностроение и робототехника"));
        keyboardFirstRow.add(new KeyboardButton("Энергетика"));
        keyboardSecondRow.add(new KeyboardButton("Нанотехнологии"));
        keyboardSecondRow.add(new KeyboardButton("Авиация и ракетостроение"));
        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void setMediaButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Медиа и коммуникации"));
        keyboardFirstRow.add(new KeyboardButton("Дизайн"));
        keyboardSecondRow.add(new KeyboardButton("Архитектура и урбанистика"));
        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }
    public void setScienceButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Биология и биотехника"));
        keyboardFirstRow.add(new KeyboardButton("Химия и химические технологии"));
        keyboardSecondRow.add(new KeyboardButton("Математика и физика"));
        keyboardSecondRow.add(new KeyboardButton("География и гидрометеорология"));
        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void setSafetyButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Безопасность"));
        keyboardFirstRow.add(new KeyboardButton("Военное дело, госбезопасность"));
        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void setArtButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Живопись и скульптура"));
        keyboardFirstRow.add(new KeyboardButton("Музыка и хореография"));
        keyboardSecondRow.add(new KeyboardButton("Актёрское мастерство"));
        keyboardSecondRow.add(new KeyboardButton("Искусствоведение"));
        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void setMedicineButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Лечебное дело"));
        keyboardFirstRow.add(new KeyboardButton("Ветеринария"));
        keyboardSecondRow.add(new KeyboardButton("Фармация и фармакология"));
        keyboardSecondRow.add(new KeyboardButton("Медицинские технологии"));
        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }
}