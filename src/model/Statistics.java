package model;

import view.ConsoleHelper;

import java.util.ArrayList;


public class Statistics {
    private int numberOfRepetitionsOfPattern;   // количество повторений паттерна
    private ArrayList<Double> averageSell;
    private ArrayList<Double> averageBuy;
    private double maxSell;
    private double minSell;
    private double maxBuy;
    private double minBuy;
    private int sell;
    private int buy;



    public Statistics() {
        this.numberOfRepetitionsOfPattern = 0;
        this.averageSell = new ArrayList<>();
        this.averageBuy = new ArrayList<>();
        this.minSell = 1000.0;
        this.minBuy = 1000.0;
        this.maxSell = 0.0;
        this.maxBuy = 0.0;
        this.sell = 0;
        this.buy = 0;
        Gasket.setStatisticsClass(this);
    }



    public synchronized void showStatistics() {
        if (numberOfRepetitionsOfPattern == 0) {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.NO_MATCHES_FOUND));
        } else {
            ConsoleHelper.writeMessage(getStatistics());
        }
        Gasket.getViewThreadClass().setPreviousColor();
    }


    public synchronized void setMaxBuySell(double buy, double sell) {
        maxSell = Math.max(sell, maxSell);
        minSell = Math.min(sell, minSell);
        maxBuy = Math.max(buy, maxBuy);
        minBuy = Math.min(buy, minBuy);
        averageSell.add(sell);
        averageBuy.add(buy);
    }


    private String getStatistics() {
        double s = 0.0;
        double b = 0.0;

        for (Double d : averageSell) s = s + d;
        s = s / averageSell.size();

        for (Double d : averageBuy) b = b + d;
        b = b / averageBuy.size();

        int ss = (int) s;
        int bb = (int) b;

        Gasket.getPatternClass().addStatistics(getStrings(bb, ss));
        new Statistics();

        return  "\n\n\n --- *** STATISTICS *** --- " +
                "\nNumber of repetitions  -->  " + numberOfRepetitionsOfPattern +
                "\nMax Sell  -->  " + maxSell + "\nMax Buy  -->  " + maxBuy +
                "\nAverage Sell --> " + ss + "\nAverage Buy --> " + bb +
                "\nMin Sell  -->  " + minSell + "\nMin Buy  -->  " + minBuy +
                "\nSell  -->  " + sell + "\nBuy  --> " + buy +
                "\n\n";
    }


    private ArrayList<String> getStrings(int b, int s) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(" --- *** STATISTICS *** --- ");
        arrayList.add("Number of repetitions  -->  " + numberOfRepetitionsOfPattern);
        arrayList.add("Max Sell  -->  " + maxSell );
        arrayList.add("Max Buy  -->  " + maxBuy);
        arrayList.add("Average Sell --> " + s);
        arrayList.add("Average Buy --> " + b);
        arrayList.add("Min Sell  -->  " + minSell);
        arrayList.add("Min Buy  -->  " + minBuy);
        arrayList.add("Sell  -->  " + sell);
        arrayList.add("Buy  --> " + buy);
        return arrayList;
    }


    public synchronized void setNumberOfRepetitionsOfPattern() {
        this.numberOfRepetitionsOfPattern++;
    }

    public synchronized void sellPlus() {
        this.sell++;
    }

    public synchronized void buyPlus() {
        this.buy++;
    }
}
