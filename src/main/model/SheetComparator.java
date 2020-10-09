package main.model;


import java.util.ArrayList;

// сравнивает лист патерна и лист паттерна найденого в истории
public class SheetComparator extends Thread {
    private ArrayList<String> historyPatternList;
    private ArrayList<String> patternList;
    private int nextStepIndex;



    public SheetComparator(ArrayList<String> historyPatternList, int nextStepIndex) {
        this.patternList = new ArrayList<>(Gasket.getPatternClass().getPatternList());
        this.historyPatternList = new ArrayList<>(historyPatternList);
        this.nextStepIndex = nextStepIndex;
        start();
    }



    @Override
    public void run() {
        // проверить наличие всех уровней на месте ли
        if (checkAvailabilityOfAllLevels()) {
            // проверяем правильно ли по высоте находятся главные уровни
            if (isTheHeightOfTheMainLevelsCorrect()) {
                Gasket.getStatisticsClass().setNumberOfRepetitionsOfPattern();
                new Analyzer(nextStepIndex);
            }
        }
        historyPatternList.clear();
        patternList.clear();
    }



    // проверить наличие всех уровней на месте ли
    private boolean checkAvailabilityOfAllLevels() {
        ArrayList<String> historyPatternShort = new ArrayList<>();
        ArrayList<String> patternShort = new ArrayList<>();

        for (String s : historyPatternList) {
            historyPatternShort.add(StringHelper.getStringData(Str.type, s));
        }
        for (String s : patternList) {
            patternShort.add(StringHelper.getStringData(Str.type, s));
        }

        historyPatternShort.sort(ComparatorHelper.getSortTheAlphabet());
        patternShort.sort(ComparatorHelper.getSortTheAlphabet());

        for (int a = 0; a < historyPatternShort.size(); a++) {
            if (!historyPatternShort.get(a).equals(patternShort.get(a))) return false;
        }

        if (Gasket.isDirCandle()) {
            historyPatternShort.clear();
            patternShort.clear();
            historyPatternShort.addAll(historyPatternList);
            patternShort.addAll(patternList);

            historyPatternShort.sort(ComparatorHelper.getSortTheAlphabetAll());
            patternShort.sort(ComparatorHelper.getSortTheAlphabetAll());

            for (int a = 0; a < historyPatternShort.size(); a++) {
                if (!historyPatternShort.get(a).equalsIgnoreCase(patternShort.get(a)))
                    return false;
            }
        }
        return true;
    }



    // проверяем правильно ли по очередности и по высоте находятся главные уровни,
    // а так же совпадает ли у них направление свечей
    private boolean isTheHeightOfTheMainLevelsCorrect() {
        ArrayList<String> mainLevels = new ArrayList<>(Gasket.getLevelAccountingClass().getMainLevelsList());
        ArrayList<String> historyPatternLong = new ArrayList<>(historyPatternList);
        ArrayList<String> historyPatternCandleDirection = new ArrayList<>();
        ArrayList<String> patternShortCandleDirection = new ArrayList<>();
        ArrayList<String> patternLong = new ArrayList<>(patternList);
        ArrayList<String> historyPatternShort = new ArrayList<>();
        ArrayList<String> patternShort = new ArrayList<>();


        // по очередности
        for (String s : historyPatternLong) {
            String string = StringHelper.getStringData(Str.type, s);
            for (String ss : mainLevels) {
                if (ss.equalsIgnoreCase(string)) {
                    historyPatternShort.add(string);
                    break;
                }
            }
        }

        for (String s : patternLong) {
            String string = StringHelper.getStringData(Str.type, s);
            for (String ss : mainLevels) {
                if (ss.equalsIgnoreCase(string)) {
                    patternShort.add(string);
                    break;
                }
            }
        }

        for (int a = 0; a < historyPatternShort.size(); a++) {
            if (!historyPatternShort.get(a).equals(patternShort.get(a))) return false;
        }


        // по высоте
        historyPatternLong.sort(ComparatorHelper.getSortPrice());
        patternLong.sort(ComparatorHelper.getSortPrice());

        for (String s : historyPatternLong) {
            String string = StringHelper.getStringData(Str.type, s);
            for (String ss : mainLevels) {
                if (ss.equalsIgnoreCase(string)) {
                    historyPatternCandleDirection.add(StringHelper.getStringData(Str.dir, s));
                    historyPatternShort.add(string);
                    break;
                }
            }
        }

        for (String s : patternLong) {
            String string = StringHelper.getStringData(Str.type, s);
            for (String ss : mainLevels) {
                if (ss.equalsIgnoreCase(string)) {
                    patternShortCandleDirection.add(StringHelper.getStringData(Str.dir, s));
                    patternShort.add(string);
                    break;
                }
            }
        }

        for (int a = 0; a < historyPatternShort.size(); a++) {
            if (!historyPatternShort.get(a).equals(patternShort.get(a))) return false;
            if (Gasket.isDirMainCandle()) {
                if (!historyPatternCandleDirection.get(a).equalsIgnoreCase(patternShortCandleDirection.get(a))) return false;
            }
        }
        return true;
    }
}
