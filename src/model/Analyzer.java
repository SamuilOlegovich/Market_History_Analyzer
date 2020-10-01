package model;

import java.util.ArrayList;

public class Analyzer extends Thread {
    private ArrayList<String> historyList;
    double maxSell;
    double maxBuy;

    public Analyzer(int start) {
        this.historyList = new ArrayList<>(Gasket.getHistoryClass()
                .getHistoryList(start, start + Gasket.getNumberFutureCandles() + 1));
        this.maxSell = 0.0;
        this.maxBuy = 0.0;
        this.start();
    }

    @Override
    public void run() {
//        maxSell = getMaxSell();
//        maxBuy = getMasBuy();
    }


}
