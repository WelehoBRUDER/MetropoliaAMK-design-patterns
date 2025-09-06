package customer_feedback_handler.handlers;

import customer_feedback_handler.Handler;
import customer_feedback_handler.Message;
import customer_feedback_handler.MessageType;

import java.util.ArrayList;

public class DevelopmentSuggestionHandler extends Handler {

    ArrayList<Message> legacyBacklog = new ArrayList<>();

    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            int priority = (int) (Math.random() * 10000);
            System.out.println("Thank you for your development suggestion! Your ticket is dev#" + priority);
            legacyBacklog.add(message);
        }
        else {
            super.handle(message);
        }
    }
}
