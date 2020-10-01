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
        maxSell = getMaxSell();
        maxBuy = getMaxBuy();
        Gasket.getStatisticsClass().setMaxBuySell(maxBuy, maxSell);
        buyOrSellThisPattern();
    }




    private double getMaxSell() {
        double start = Double.parseDouble(StringHelper.getStringData(Str.open, historyList.get(0)));
        double result = 0.0;
        for (String s : historyList) {
            double low = Double.parseDouble(StringHelper.getStringData(Str.low, s));
            if (start > low) {
                result = Math.max(start - low, result);
            }
        }
        return result;
    }


    private double getMaxBuy() {
        double start = Double.parseDouble(StringHelper.getStringData(Str.open, historyList.get(0)));
        double result = 0.0;
        for (String s : historyList) {
            double high = Double.parseDouble(StringHelper.getStringData(Str.high, s));
            if (start < high) {
                result = Math.max(high - start, result);
            }
        }
        return result;
    }


    private void buyOrSellThisPattern() {
        double start = Double.parseDouble(StringHelper.getStringData(Str.open, historyList.get(0)));
        double takeProfit = start + Gasket.getTakeProfit();
        double stopLoss = start - Gasket.getTakeProfit();
        for (String s : historyList) {
            double high = Double.parseDouble(StringHelper.getStringData(Str.high, s));
            double low = Double.parseDouble(StringHelper.getStringData(Str.low, s));

            if (takeProfit <= high) {
                Gasket.getStatisticsClass().buyPlus();
                return;
            }
            if (stopLoss >= low) {
                Gasket.getStatisticsClass().sellPlus();
                return;
            }
        }
    }
}
