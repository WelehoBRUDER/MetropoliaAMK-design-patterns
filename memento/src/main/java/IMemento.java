import java.util.Date;

public interface IMemento extends Comparable<IMemento> {
    // memento metadata methods
    public int[] getOptions();
    public boolean isSelected();
    public Date getTimeCreated();
    public String getInfo();
}
