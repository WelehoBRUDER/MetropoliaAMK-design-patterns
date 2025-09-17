import java.util.ArrayList;
import java.util.Date;
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
            IMemento currentState = model.createMemento();
            IMemento previousState = history.remove(history.size() - 1);
            redoHistory.add(currentState);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Memento found in redo history");
            IMemento currentState = model.createMemento();
            IMemento previousState = redoHistory.remove(redoHistory.size() - 1);
            history.add(currentState);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        redoHistory = new ArrayList<>();
        gui.updateButton();
    }

    public void jumpBackToUndoState(int state) {
        IMemento fallback = history.get(state);
        history.subList(state, history.size()).clear();
        redoHistory = new ArrayList<>();
        model.restoreState(fallback);
        gui.updateGui();
    }

    public void jumpBackToRedoState(int state) {
        IMemento fallback = redoHistory.get(state);
        redoHistory.subList(state, redoHistory.size()).clear();
        model.restoreState(fallback);
        gui.updateGui();
    }

    public void jumpBackByDate(Date date) {
        boolean fin = false;
        // Look in undo states
        for (int i =  0; i < history.size(); i++) {
            IMemento mem = history.get(i);
            if (mem.getTimeCreated().getTime() == date.getTime()) {
                jumpBackToUndoState(i);
                fin = true;
                break;
            }
        }
        if (!fin) {
            for (int i =  redoHistory.size() - 1; i >= 0; i--) {
                IMemento mem = redoHistory.get(i);
                if (mem.getTimeCreated().getTime() == date.getTime()) {
                    jumpBackToRedoState(i);
                    break;
                }
            }
        }
    }

    public List<IMemento> getFullHistory() {
        List <IMemento> fullHistory = new ArrayList<>();
        fullHistory.addAll(history);
        fullHistory.addAll(redoHistory);
        fullHistory.sort(IMemento::compareTo);
        return fullHistory;
    }

    public boolean isHistoryEmpty() {
        return history.isEmpty() && redoHistory.isEmpty();
    }
}
