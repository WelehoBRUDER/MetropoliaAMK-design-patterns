package ascii_button_factory;

public abstract class Button {
    protected String text = "";

    public abstract void display();

    public void setText(String txt) {
        text = txt;
    }
}
