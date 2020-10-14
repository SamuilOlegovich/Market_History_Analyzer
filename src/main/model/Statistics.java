package main.model;

import main.view.ConsoleHelper;

import java.util.ArrayList;


public class Statistics {
    private int numberOfRepetitionsOfPattern;   // количество повторений паттерна
    private ArrayList<Double> averageSell;
    private ArrayList<Double> averageBuy;
    private double maxSell;
    private double minSell;
    private double maxBuy;
    private double minBuy;
    private int sellEnd;
    private int buyEnd;
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
        this.sellEnd = 0;
        this.buyEnd = 0;
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
//        if (sell > maxSell) {
//            maxSell = sell;
//        }
        maxSell = Math.max(maxSell, sell);
        minSell = Math.min(minSell, sell);
        maxBuy = Math.max(maxBuy, buy);
        minBuy = Math.min(minBuy, buy);
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
                "\nNumber of repetitions  -->  " + numberOfRepetitionsOfPattern + "   --->   количество повторений паттерна в истории" +
                "\nMax Sell  -->  " + maxSell + "   --->   максимальное отклонение в селл после паттерна" +
                "\nMax Buy  -->  " + maxBuy + "   --->   максимальное отклонение в бай после паттерна" +
                "\nAverage Sell --> " + ss + "   --->   среднее отклонение в селл после паттерна" +
                "\nAverage Buy --> " + bb + "   --->   среднее отклонение в бай после паттерна" +
                "\nMin Sell  -->  " + minSell + "   --->   минимальное отклонение в селл после паттерна" +
                "\nMin Buy  -->  " + minBuy + "   --->   минимальное отклонение в бай после паттерна" +
                "\nSellEnd  -->  " + sellEnd + "   --->   количество раз в сел по последней свече" +
                "\nBuyEnd  --> " + buyEnd + "   --->   количество раз в бай по последней свече" +
                "\nSell  -->  " + sell + "   --->   количество раз в сел по тейку" +
                "\nBuy  --> " + buy + "   --->   количество раз в бай по тейку" +
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
        arrayList.add("SellEnd  -->  " + sell);
        arrayList.add("BuyEnd  --> " + buy);
        arrayList.add("Sell  -->  " + sell);
        arrayList.add("Buy  --> " + buy);
        return arrayList;
    }


    public synchronized void setNumberOfRepetitionsOfPattern() {
        this.numberOfRepetitionsOfPattern++;
    }

    public synchronized void sellEndPlus() {
        this.sellEnd++;
    }

    public synchronized void buyEndPlus() {
        this.buyEnd++;
    }

    public synchronized void sellPlus() {
        this.sell++;
    }

    public synchronized void buyPlus() {
        this.buy++;
    }
}
