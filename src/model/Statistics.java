package model;

import view.ConsoleHelper;

public class Statistics {
    int numberOfRepetitionsOfPattern;   // количество повторений паттерна


    public Statistics() {
        this.numberOfRepetitionsOfPattern = 0;
        Gasket.setStatisticsClass(this);
    }




    public int getNumberOfRepetitionsOfPattern() {
        return numberOfRepetitionsOfPattern;
    }

    public void setNumberOfRepetitionsOfPattern(int numberOfRepetitionsOfPattern) {
        this.numberOfRepetitionsOfPattern = numberOfRepetitionsOfPattern;
    }

    public void setNumberOfRepetitionsOfPattern() {
        this.numberOfRepetitionsOfPattern++;
    }

    public void showStatistics() {
        if (numberOfRepetitionsOfPattern == 0) {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.NO_MATCHES_FOUND));
        } else {
            ConsoleHelper.writeMessage(StringHelper
                    .getString(Outs.NO_MATCHES_FOUND.toString() + "  -->  " + numberOfRepetitionsOfPattern));
        }
    }
}
