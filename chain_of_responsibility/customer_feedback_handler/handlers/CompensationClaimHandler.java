package customer_feedback_handler.handlers;

import customer_feedback_handler.Handler;
import customer_feedback_handler.Message;
import customer_feedback_handler.MessageType;

public class CompensationClaimHandler extends Handler {

    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.COMPENSATION) {
            if (Math.random() >= 0.5) {
                System.out.println("Your compensation claim has been reviewed and accepted.");
            } else {
                System.out.println("Your compensation claim has been deemed invalid. We apologize for the inconvenience.");
            }
        }
        else {
            super.handle(message);
        }
    }
}
