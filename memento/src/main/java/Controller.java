import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoHistory; // Redo memento history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            IMemento previousState = history.remove(history.size() - 1);
            redoHistory.add(previousState);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Memento found in redo history");
            IMemento previousState = redoHistory.remove(redoHistory.size() - 1);
            history.add(previousState);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    private void displayAllMementosForDebug() {
        System.out.println("<<< DISPLAYING ALL AVAILABLE MEMENTOS >>>");
        System.out.println(("--- UNDO HISTORY ---"));
        for (IMemento memento : history) {
            int[] options = memento.getOptions();
            boolean isSelected = memento.isSelected();
            System.out.println("options: " + options[0] + " " + options[1] + " " + options[2]);
            System.out.println("isSelected: " + isSelected);
        }
        System.out.println("----------------------");
        System.out.println("=== REDO HISTORY ===");
        for (IMemento memento : redoHistory) {
            int[] options = memento.getOptions();
            boolean isSelected = memento.isSelected();
            System.out.println("options: " + options[0] + " " + options[1] + " " + options[2]);
            System.out.println("isSelected: " + isSelected);
        }
        System.out.println("======================");
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }
}
