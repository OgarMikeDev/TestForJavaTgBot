import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class Bot extends TelegramLongPollingBot {
    private int countCorrectAnswers;

    //Кнопка для запуска теста
    private InlineKeyboardButton startTest = InlineKeyboardButton.builder()
            .text("Нажмите для запуска теста!")
            .callbackData("start test")
            .build();
    //Клавиатура с кнопкой для запуска теста
    private InlineKeyboardMarkup keyboardForStartTest = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(startTest))
            .build();

    //Кнопки для ответов на 1-й вопрос
    private InlineKeyboardButton dateCreateJava1 = InlineKeyboardButton.builder()
            .text("1990")
            .callbackData("1990")
            .build();
    private InlineKeyboardButton dateCreateJava2 = InlineKeyboardButton.builder()
            .text("1995")
            .callbackData("1995")
            .build();
    private InlineKeyboardButton dateCreateJava3 = InlineKeyboardButton.builder()
            .text("2000")
            .callbackData("2000")
            .build();
    private InlineKeyboardButton dateCreateJava4 = InlineKeyboardButton.builder()
            .text("2005")
            .callbackData("2005")
            .build();
    //Клавиатура для ответов на 1-й вопрос
    private InlineKeyboardMarkup keyboardForAnswersForFirstQuestion = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(dateCreateJava1))
            .keyboardRow(List.of(dateCreateJava2))
            .keyboardRow(List.of(dateCreateJava3))
            .keyboardRow(List.of(dateCreateJava4))
            .build();

    //Кнопки для ответов на 2-й вопрос
    private InlineKeyboardButton differenceObjectFromClasses1 = InlineKeyboardButton.builder()
            .text("Классы - экземпляры объектов, а объекты - шаблоны")
            .callbackData("классы - э, объекты - ш")
            .build();
    private InlineKeyboardButton differenceObjectFromClasses2 = InlineKeyboardButton.builder()
            .text("Объекты - экземпляры классов, а классы - шаблоны")
            .callbackData("объекты - э, классы - ш")
            .build();
    private InlineKeyboardButton differenceObjectFromClasses3 = InlineKeyboardButton.builder()
            .text("Ничем")
            .callbackData("ничем")
            .build();
    private InlineKeyboardButton differenceObjectFromClasses4 = InlineKeyboardButton.builder()
            .text("Классы для ФП, а объекты для ООП")
            .callbackData("классы - с, а объекты - ООП")
            .build();
    //Клавиатура для ответов на 2-й вопрос
    private InlineKeyboardMarkup keyboardForAnswersForSecondQuestion = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(differenceObjectFromClasses1))
            .keyboardRow(List.of(differenceObjectFromClasses2))
            .keyboardRow(List.of(differenceObjectFromClasses3))
            .keyboardRow(List.of(differenceObjectFromClasses4))
            .build();

    //Кнопки для ответов на 3-й вопрос
    private InlineKeyboardButton nameCompanyCreateJava1 = InlineKeyboardButton.builder()
            .text("Oracle")
            .callbackData("oracle")
            .build();
    private InlineKeyboardButton nameCompanyCreateJava2 = InlineKeyboardButton.builder()
            .text("Microsystems")
            .callbackData("microsystems")
            .build();
    private InlineKeyboardButton nameCompanyCreateJava3 = InlineKeyboardButton.builder()
            .text("Google")
            .callbackData("google")
            .build();
    private InlineKeyboardButton nameCompanyCreateJava4 = InlineKeyboardButton.builder()
            .text("Yandex")
            .callbackData("yandex")
            .build();
    //Клавиатура для ответов на 3-й вопрос
    private InlineKeyboardMarkup keyboardForAnswersForThirdQuestion = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(nameCompanyCreateJava1))
            .keyboardRow(List.of(nameCompanyCreateJava2))
            .keyboardRow(List.of(nameCompanyCreateJava3))
            .keyboardRow(List.of(nameCompanyCreateJava4))
            .build();

    //Кнопки для ответов на 4-й вопрос
    private InlineKeyboardButton languageProgrammingOOP1 = InlineKeyboardButton.builder()
            .text("C++, Java")
            .callbackData("c++, java")
            .build();
    private InlineKeyboardButton languageProgrammingOOP2 = InlineKeyboardButton.builder()
            .text("Fortran, Python")
            .callbackData("fortran, python")
            .build();
    private InlineKeyboardButton languageProgrammingOOP3 = InlineKeyboardButton.builder()
            .text("Pascal, Basic")
            .callbackData("pascal, basic")
            .build();
    private InlineKeyboardButton languageProgrammingOOP4 = InlineKeyboardButton.builder()
            .text("C, Ruby")
            .callbackData("c, ruby")
            .build();
    //Клавиатура для ответов на 4-й вопрос
    private InlineKeyboardMarkup keyboardForAnswersForFourthQuestion = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(languageProgrammingOOP1))
            .keyboardRow(List.of(languageProgrammingOOP2))
            .keyboardRow(List.of(languageProgrammingOOP3))
            .keyboardRow(List.of(languageProgrammingOOP4))
            .build();

    @Override
    public String getBotUsername() {
        return "@update_ogar_tg_bot";
    }

    @Override
    public String getBotToken() {
        return "7835404338:AAF5Dzrt5am0U_SZwKOBS0Dw9hBSpr3fumM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        sendInfoForStartTest(update);
        workWithButtons(update);
    }

    public void workWithButtons(Update update) {
        if (update.hasCallbackQuery()) {
            EditMessageText editMessageText = EditMessageText.builder()
                    .chatId(update.getCallbackQuery().getMessage().getChatId().toString())
                    .messageId(update.getCallbackQuery().getMessage().getMessageId())
                    .text("")
                    .build();

            EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                    .chatId(update.getCallbackQuery().getMessage().getChatId().toString())
                    .messageId(update.getCallbackQuery().getMessage().getMessageId())
                    .build();

            //Формирование первого вопроса
            if (update.getCallbackQuery().getData().equals("start test")) {
                editMessageText.setText("Выберите дату основания java");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForFirstQuestion);
            }

            //Формирование второго вопроса
            else if (update.getCallbackQuery().getData().equals("1990")) {
                editMessageText.setText("Чем отличаются объекты от классов");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForSecondQuestion);
            }
            else if (update.getCallbackQuery().getData().equals("1995")) {
                countCorrectAnswers++;
                editMessageText.setText("Чем отличаются объекты от классов");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForSecondQuestion);
            }
            else if (update.getCallbackQuery().getData().equals("2000")) {
                editMessageText.setText("Чем отличаются объекты от классов");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForSecondQuestion);
            }
            else if (update.getCallbackQuery().getData().equals("2005")) {
                editMessageText.setText("Чем отличаются объекты от классов");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForSecondQuestion);
            }

            //Формирование третьего вопроса
            else if (update.getCallbackQuery().getData().equals("классы - э, объекты - ш")) {
                editMessageText.setText("Как называлась компания, основавшая Java");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForThirdQuestion);
            }
            else if (update.getCallbackQuery().getData().equals("объекты - э, классы - ш")) {
                countCorrectAnswers++;
                editMessageText.setText("Как называлась компания, основавшая Java");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForThirdQuestion);
            }
            else if (update.getCallbackQuery().getData().equals("ничем")) {
                editMessageText.setText("Как называлась компания, основавшая Java");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForThirdQuestion);
            }
            else if (update.getCallbackQuery().getData().equals("классы - с, а объекты - ООП")) {
                editMessageText.setText("Как называлась компания, основавшая Java");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForThirdQuestion);
            }

            //Формирование четвёртого вопроса
            else if (update.getCallbackQuery().getData().equals("oracle")) {
                editMessageText.setText("Какие ЯП относятся к ООП");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForFourthQuestion);
            }
            else if (update.getCallbackQuery().getData().equals("microsystems")) {
                countCorrectAnswers++;
                editMessageText.setText("Какие ЯП относятся к ООП");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForFourthQuestion);
            }
            else if (update.getCallbackQuery().getData().equals("google")) {
                editMessageText.setText("Какие ЯП относятся к ООП");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForFourthQuestion);
            }
            else if (update.getCallbackQuery().getData().equals("yandex")) {
                editMessageText.setText("Какие ЯП относятся к ООП");
                editMessageReplyMarkup.setReplyMarkup(keyboardForAnswersForFourthQuestion);
            }

            //Формирование результата теста
            else if (update.getCallbackQuery().getData().equals("c++, java")) {
                countCorrectAnswers++;
                editMessageText.setText("Вы завершили тест и набрали " + getResultTest() + " баллов!");
            }
            else if (update.getCallbackQuery().getData().equals("fortran, python")) {
                editMessageText.setText("Вы завершили тест и набрали " + getResultTest() + " баллов!");
            }
            else if (update.getCallbackQuery().getData().equals("pascal, basic")) {
                editMessageText.setText("Вы завершили тест и набрали " + getResultTest() + " баллов!");
            }
            else if (update.getCallbackQuery().getData().equals("c, ruby")) {
                editMessageText.setText("Вы завершили тест и набрали " + getResultTest() + " баллов!");
            }

            try {
                execute(editMessageText);
                execute(editMessageReplyMarkup);
            } catch (Exception exception) {
                exception.getMessage();
            }
        }
    }

    public String getResultTest() {
        int percentCorrectAnswers = (countCorrectAnswers * 100) / 4;
        return String.valueOf(percentCorrectAnswers);
    }

    public void sendInfoForStartTest(Update update) {
        if (update.hasMessage()) {
            if (update.getMessage().getText().equals("/start_test")) {
                countCorrectAnswers = 0;
                SendMessage sendMessage = SendMessage.builder()
                        .chatId(update.getMessage().getFrom().getId().toString())
                        .text("Вас приветствует бот Михаила")
                        .replyMarkup(keyboardForStartTest)
                        .build();

                try {
                    execute(sendMessage);
                } catch (Exception exception) {
                    exception.getMessage();
                }
            }
        }
    }
}
