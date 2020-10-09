package model;

import java.util.ArrayList;



public class Analyzer extends Thread {
    private ArrayList<String> historyList;
    private double maxSell;
    private double maxBuy;
    private int start;




    public Analyzer(int start) {
        this.start = start;
        this.maxSell = 0.0;
        this.maxBuy = 0.0;
        this.start();
    }



    @Override
    public void run() {
        getList();
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


    // устанавливаем реальное время отсчета и находим его индекс в листе истории
    private void getList() {
        String time = StringHelper.getStringData(Str.time, historyList.get(start).split(Str.levels.toString())[0]);
        String timeMinute = time.split(":")[1];  // 2020-05-21 15:30:00
        if (timeMinute.endsWith("0") || timeMinute.endsWith("5")) start += Gasket.getIndentFromLastLevelInPattern() + 5;
        else if (timeMinute.endsWith("1") || timeMinute.endsWith("6")) start += Gasket.getIndentFromLastLevelInPattern() + 4;
        else if (timeMinute.endsWith("2") || timeMinute.endsWith("7")) start += Gasket.getIndentFromLastLevelInPattern() + 3;
        else if (timeMinute.endsWith("3") || timeMinute.endsWith("8")) start += Gasket.getIndentFromLastLevelInPattern() + 2;
        else if (timeMinute.endsWith("4") || timeMinute.endsWith("9")) start += Gasket.getIndentFromLastLevelInPattern() + 1;
        this.historyList = new ArrayList<>(Gasket.getHistoryClass()
                .getHistoryList(start, start + Gasket.getNumberFutureCandles() + 1));
    }
}
