package customer_feedback_handler.handlers;

import customer_feedback_handler.Handler;
import customer_feedback_handler.Message;
import customer_feedback_handler.MessageType;

public class GeneralFeedbackHandler extends Handler {

    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("Thank you for your feedback! We will send our response in 3-4 business years.");
        }
    }
}
