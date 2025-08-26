package ascii_button_factory;

public abstract class Checkbox {
    protected String text = "";
    protected Boolean checked = false;

    public abstract void display();
    
    public Checkbox(String txt, Boolean chk) {
        text = txt;
        checked = chk;
    }

    public void setText(String txt) {
        text = txt;
    }
    public void setChecked(Boolean chk) {
        checked = chk;
    }
}
