package model;

import view.ConsoleHelper;

import java.util.ArrayList;



public class History {
    private ArrayList<String> historyList;

    public History(ArrayList<String> historyList) {
        this.historyList = new ArrayList<>(historyList);
        Gasket.setHistoryClass(this);
        recordHistory();
    }



    public ArrayList<String> getHistoryList() {
        return historyList;
    }

    public ArrayList<String> getHistoryList(int start, int stop) {
        return new ArrayList<>(historyList.subList(start, stop));
    }


    public ArrayList<String> getPartHistory(int start, int stop) {
        ArrayList<String> out = new ArrayList<>();
        for (int i = start; i <= (stop > historyList.size() ? historyList.size() - 1 : stop); i++) {
            out.add(historyList.get(i));
        }
        return out;
    }

    public int getHistorySize() {
        return historyList.size();
    }


    private void recordHistory() {
        new WriteHistory();
    }
}
