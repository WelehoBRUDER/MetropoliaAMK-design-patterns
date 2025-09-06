package customer_feedback_handler.handlers;

import customer_feedback_handler.Handler;
import customer_feedback_handler.Message;
import customer_feedback_handler.MessageType;

public class ContactRequestHandler  extends Handler {

    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.CONTACT) {
            if (Math.random() >= 0.85) {
                System.out.println("Your contact request has been forwarded.");
            } else {
                System.out.println("An error has occurred when attempting to forward your contact request.");
            }
        }
        else {
            super.handle(message);
        }
    }
}
