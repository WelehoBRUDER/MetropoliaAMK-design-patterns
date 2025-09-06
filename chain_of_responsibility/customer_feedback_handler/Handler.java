package customer_feedback_handler;

public abstract class Handler {

    private Handler nextHandler;

    public void handle(Message message) {
        if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
