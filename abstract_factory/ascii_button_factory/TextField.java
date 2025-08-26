package ascii_button_factory;

public abstract class TextField {
    protected String text = "";

    public abstract void display();
    
    public  TextField(String txt) {
        text = txt;
    }

    public void setText(String txt) {
        text = txt;
    }
}
