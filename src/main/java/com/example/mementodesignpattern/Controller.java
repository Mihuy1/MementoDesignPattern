package com.example.mementodesignpattern;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List <IMemento> redoHistory;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public List<IMemento> getHistory() {
        return history;
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
            redoHistory.add(model.createMemento());
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Memento found in redo history");
            history.add(model.createMemento());
            IMemento previousState = redoHistory.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    public void restoreState(int index) {
        if (index >= 0 && index < history.size()) {
            IMemento selectedState = history.get(index);
            model.restoreState(selectedState);
            // Delete all the mementos after the selected memento
            for (int i = history.size() - 1; i > index; i--) {
                history.remove(i);
            }
            gui.updateGui();
        }

    }
}
