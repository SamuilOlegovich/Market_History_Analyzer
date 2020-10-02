package model;

import view.ConsoleHelper;




public class Statistics {
    private int numberOfRepetitionsOfPattern;   // количество повторений паттерна
    private double maxSell;
    private double maxBuy;
    private int sell;
    private int buy;



    public Statistics() {
        this.numberOfRepetitionsOfPattern = 0;
        Gasket.setStatisticsClass(this);
        this.maxSell = 0.0;
        this.maxBuy = 0.0;
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
        maxBuy = Math.max(buy, maxBuy);
    }

    public synchronized void sellPlus() {
        this.sell++;
    }

    public synchronized void buyPlus() {
        this.buy++;
    }

    private String getStatistics() {
        return  "\n\n\n --- *** STATISTICS *** --- " +
                "\nMax Sell  -->  " + maxSell + "\nMax Buy  -->  " + maxBuy +
                "\nSell  -->  " + sell + "\nBuy  --> " + buy +
                "\nNumber of repetitions  -->  " + numberOfRepetitionsOfPattern +
                "\n\n";
    }
}
