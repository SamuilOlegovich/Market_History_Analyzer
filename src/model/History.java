package model;

import view.ConsoleHelper;

import java.util.ArrayList;



public class History {
    private ArrayList<String> historyList;

    public History(ArrayList<String> historyList) {
        this.historyList = new ArrayList<>(historyList);
        Gasket.setHistoryClass(this);
    }



    public ArrayList<String> getHistoryList() {
        /////////////
        ConsoleHelper.writeMessage("historyList => " + historyList.size());
        /////////////
        return historyList;
    }


    public ArrayList<String> getPartHistory(int start, int stop) {
        ArrayList<String> out = new ArrayList<>();
        for (int i = start; i <= (stop > historyList.size() ? historyList.size() - 1 : stop); i++) {
            out.add(historyList.get(i));
        }
        return out;
    }
}
