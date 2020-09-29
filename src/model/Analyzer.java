package model;

import java.util.ArrayList;

public class Analyzer extends Thread {
    private ArrayList<String> historyList;
    private ArrayList<String> patternList;

    public Analyzer() {
        this.patternList = new ArrayList<>(Gasket.getWritePatternsClass().getPatternList());
        this.historyList = new ArrayList<>(Gasket.getReadHistoryClass().getHistoryList());
        this.start();
    }

    @Override
    public void run() {




        Gasket.getViewThreadClass().setPreviousColor();
    }


}
