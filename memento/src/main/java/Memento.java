import java.util.Date;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private Date timeCreated;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timeCreated = new Date();
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    @Override
    public int compareTo(IMemento o) {
        long a = this.getTimeCreated().getTime();
        long b = o.getTimeCreated().getTime();
        return Long.compare(a, b);
    }
}
