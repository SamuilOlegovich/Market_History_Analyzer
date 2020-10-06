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
        Gasket.setStatisticsClass(this);
        this.averageSell = new ArrayList<>();
        this.averageBuy = new ArrayList<>();
        this.maxSell = 0.0;
        this.minSell = 0.0;
        this.maxBuy = 0.0;
        this.minBuy = 0.0;
        this.sell = 0;
        this.buy = 0;
    }



    public int getNumberOfRepetitionsOfPattern() {
        return numberOfRepetitionsOfPattern;
    }

    public synchronized void setNumberOfRepetitionsOfPattern(int numberOfRepetitionsOfPattern) {
        this.numberOfRepetitionsOfPattern = numberOfRepetitionsOfPattern;
    }

    public synchronized void setNumberOfRepetitionsOfPattern() {
        this.numberOfRepetitionsOfPattern++;
    }

    public synchronized void showStatistics() {
        if (numberOfRepetitionsOfPattern == 0) {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.NO_MATCHES_FOUND));
        } else {
            ConsoleHelper.writeMessage(getStatistics());
        }
    }

    public synchronized void setMaxBuySell(double buy, double sell) {
        maxSell = Math.max(sell, maxSell);
        minSell = Math.min(sell, minSell);
        maxBuy = Math.max(buy, maxBuy);
        minBuy = Math.min(buy, minBuy);
        averageSell.add(sell);
        averageBuy.add(buy);
    }

    public synchronized void sellPlus() {
        this.sell++;
    }

    public synchronized void buyPlus() {
        this.buy++;
    }

    private String getStatistics() {
        double s = 0.0;
        double b = 0.0;

        for (Double d : averageSell) {
            s = s + d;
        }
        s = s / averageSell.size();

        for (Double d : averageBuy) {
            b = b + d;
        }
        b = b / averageBuy.size();

        return  "\n\n\n --- *** STATISTICS *** --- " +
                "\nMax Sell  -->  " + maxSell + "\nMax Buy  -->  " + maxBuy +
                "\nMin Sell  -->  " + minSell + "\nMin Buy  -->  " + minBuy +
                "\nAverage Sell --> " + s + "\nAverage Buy --> " + b +
                "\nSell  -->  " + sell + "\nBuy  --> " + buy +
                "\nNumber of repetitions  -->  " + numberOfRepetitionsOfPattern +
                "\n\n";
    }
}
