package model;


import view.StringHelper;

import java.util.ArrayList;
import java.util.Comparator;

// сравнивает лист патерна и лист паттерна найденого в истории
public class SheetComparator extends Thread {
    private ArrayList<String> historyPatternList;
    private ArrayList<String> patternList;
    private int nextStepIndex;


    public SheetComparator(ArrayList<String> historyPatternList, int nextStepIndex) {
        this.patternList = new ArrayList<>(Gasket.getWritePatternsClass().getPatternList());
        this.historyPatternList = new ArrayList<>(historyPatternList);
        this.nextStepIndex = nextStepIndex;
        start();
    }

    @Override
    public void run() {
        // проверить наличие всех уровней на месте ли
        if (checkAvailabilityOfAllLevels()) {

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
        return true;
    }
}
