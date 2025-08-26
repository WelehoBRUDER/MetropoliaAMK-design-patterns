package ascii_button_factory;

public abstract class Checkbox {
    protected String text = "";
    protected Boolean checked = false;

    public abstract void display();

    public void setText(String txt) {
        text = txt;
    }
    public void setChecked(Boolean chk) {
        checked = chk;
    }
}
