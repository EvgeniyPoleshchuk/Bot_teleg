import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class apd {
    private final TelegramBot bot = new TelegramBot("6227646767:AAHs5IiQjmaoYgEwLUjL4jUGeE6JO8n-orE");

    public void serve() throws Exception {
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::process);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private void process(@NotNull Update update) {
        BaseRequest<SendMessage, SendResponse> request = null;
        if (update.message() != null) {
            String text = update.message().text();
            if (text != null) {
                boolean b = text.contains("аренда")
                        || text.contains("недвижимость")
                        || text.contains("турция")
                        || text.contains("посуточно")
                        || text.contains("покупка")
                        || text.contains("мерсин")
                        || text.contains("продажа");
                if (b) {
                    request = new SendMessage(155247829, update.message().from().username() + " "
                            + text);

                }
            }
        }
        if (request != null) {
            bot.execute(request);
        }

    }

}


