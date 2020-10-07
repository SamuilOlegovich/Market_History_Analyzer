package model;

import view.ConsoleHelper;

import java.util.ArrayList;




public class HistoryIterator extends Thread {
    private ArrayList<String> historyList;
    private int patternSize;



    public HistoryIterator() {
        this.historyList = new ArrayList<>(Gasket.getHistoryClass().getHistoryList());
        this.patternSize = Gasket.getPatternClass().getPatternSize();
        this.start();
    }



    @Override
    public void run() {
        iterateOverHistory();
        historyList.clear();
        Gasket.getViewThreadClass().setPreviousColor();
    }



    private void iterateOverHistory() {
        int stopSteepIndex = 0;
        for (int a = 0; a < (historyList.size() - 1) - Gasket.getNumberFutureCandles() ; a++) {
            ArrayList<String> intermediatePatternList = new ArrayList<>();
            String stringA = historyList.get(a);
            int nextStepIndex = 0;

            if (stringA.contains(Str.levels.toString())) {
                ArrayList<String> add = new ArrayList<>(getLevels(stringA));
                if (add.size() > 0) intermediatePatternList.addAll(add);
            }

            for (int b = a + 1; b < historyList.size() - Gasket.getNumberFutureCandles(); b++) {
                String stringB = historyList.get(b);
                nextStepIndex = b;

                if (stringB.contains(Str.levels.toString())) {
                    ArrayList<String> add = new ArrayList<>(getLevels(stringB));
                    if (add.size() > 0) {
                        intermediatePatternList.addAll(add);
                    }
                }
                if (intermediatePatternList.size() == patternSize) break;
            }

            if (a == (historyList.size() / 100) * 10) ConsoleHelper.writeMessage("10%");
            if (a == (historyList.size() / 100) * 20) ConsoleHelper.writeMessage("20%");
            if (a == (historyList.size() / 100) * 30) ConsoleHelper.writeMessage("30%");
            if (a == (historyList.size() / 100) * 40) ConsoleHelper.writeMessage("40%");
            if (a == (historyList.size() / 100) * 50) ConsoleHelper.writeMessage("50%");
            if (a == (historyList.size() / 100) * 60) ConsoleHelper.writeMessage("60%");
            if (a == (historyList.size() / 100) * 70) ConsoleHelper.writeMessage("70%");
            if (a == (historyList.size() / 100) * 80) ConsoleHelper.writeMessage("80%");
            if (a == (historyList.size() / 100) * 90) ConsoleHelper.writeMessage("90%");
            if (a == (historyList.size() - 2)
                    - Gasket.getNumberFutureCandles()) ConsoleHelper.writeMessage("100%\n");

            if (nextStepIndex != stopSteepIndex) {
                new SheetComparator(intermediatePatternList, nextStepIndex);
                stopSteepIndex = nextStepIndex;
            }
        }
        Gasket.getStatisticsClass().showStatistics();
    }


    // распарсиваем и получаем массив уровней
    private ArrayList<String> getLevels(String in) {
        ArrayList<String> levels = new ArrayList<>();
        String[] str = in.replaceAll("\\{", "")
                .replaceAll("}", "")
                .split(",\"levels\": ");
        String[] strings = str[1].split("],\\[");
        for (String ss : strings) {
            String string = ss.replaceAll("\\[\\[", "")
                    .replaceAll("]]", "");
            if (isTheLevelSuitable(string)) {
                levels.add(string);
            }
        }
        return levels;
    }


    // подходит ли даннный уровень по типу
    private boolean isTheLevelSuitable(String in) {
        ArrayList<String> fillAccountingLevelsList = Gasket.getLevelAccountingClass().getAccountingLevelsList();
        for (String s : fillAccountingLevelsList) {
            if (s.equalsIgnoreCase(StringHelper.getStringData(Str.type, in))) {
                return isTheLevelSuitableTimeFrame(in);
            }
        }
        return false;
    }


    // подходит ли даннный уровень по таймфрейму
    private boolean isTheLevelSuitableTimeFrame(String in) {
        ArrayList<String> timeFrame = Gasket.getLevelAccountingClass().getTimeFrame();
        if (timeFrame.size() == 0) return true;
        for (String s : timeFrame) {
            if (s.equalsIgnoreCase(StringHelper.getStringData(Str.period, in))) {
                return true;
            }
        }
        return false;
    }
}
