package ascii_button_factory;

public abstract class Button {
    protected String text = "";

    public abstract void display();
    
    public  Button(String txt) {
        text = txt;
    }

    public void setText(String txt) {
        text = txt;
    }
}
