import java.util.Date;

public interface IMemento {
    // memento metadata methods
    public int[] getOptions();
    public boolean isSelected();
    public Date getTimeCreated();
}
