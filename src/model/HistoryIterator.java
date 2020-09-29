package model;

import java.util.ArrayList;

public class HistoryIterator extends Thread {
    private ArrayList<String> historyList;
    private ArrayList<String> patternList;

    public HistoryIterator() {
        this.start();
    }

    @Override
    public void run() {

    }
}
