package model;

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
            int nextStepIndex = 0;
            String stringA = historyList.get(a);
            ArrayList<String> intermediatePatternList = new ArrayList<>();

            if (stringA.contains(Str.levels.toString())) {
                ArrayList<String> add = new ArrayList<>(getLevels(stringA));
                if (add.size() > 0) intermediatePatternList.addAll(add);
            }

            for (int b = a + 1; b < historyList.size() - Gasket.getNumberFutureCandles(); b++) {
                nextStepIndex = b;
                String stringB = historyList.get(b);
                if (stringB.contains(Str.levels.toString())) {
                    ArrayList<String> add = new ArrayList<>(getLevels(stringB));
                    if (add.size() > 0) {
                        intermediatePatternList.addAll(add);
                    }
                }
                if (intermediatePatternList.size() == patternSize) break;
            }

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


    // подходит ли даннный уровень
    private boolean isTheLevelSuitable(String in) {
        ArrayList<String> fillAccountingLevelsList = Gasket.getLevelAccountingClass().getAccountingLevelsList();
        for (String s : fillAccountingLevelsList) {
            if (s.equalsIgnoreCase(StringHelper.getStringData(Str.type, in))) {
                return true;
            }
        }
        return false;
    }
}
