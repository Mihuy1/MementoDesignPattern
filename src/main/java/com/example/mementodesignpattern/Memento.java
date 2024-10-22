package com.example.mementodesignpattern;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Memento implements IMemento {

    private int options[];

    private boolean isSelected;

    private String timeStamp;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options.clone(); // Return a copy of options array
    }

    @Override
    public int[] options() {
        return new int[0];
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String getTimeStamp() {
        return timeStamp;
    }
}
