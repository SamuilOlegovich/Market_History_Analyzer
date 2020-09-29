package model;

import controller.ExecutorCommandos;
import controller.RunAndStopProgram;
import view.View;




public class Gasket {
    // Class
    private static FilesAndPathCreator filesAndPathCreatorClass;
    private static PatternStatistics patternStatisticsClass;
    private static ExecutorCommandos executorCommandosClass;
    private static RunAndStopProgram runAndStopProgramClass;
    private static LevelAccounting levelAccountingClass;
    private static WritePatterns writePatternsClass;
    private static ReadHistory readHistoryClass;
    private static View viewThreadClass;


    // Settings
    private static int numberFutureCandles = 30;    // количество будущих свечей в которое надо посмотреть
    private static String symbol = "BTCUSD";
    private static int dateDifference = 0;


    // Strings
    private static final String SETTING_NOW = " --- SETTING_NOW --- ";




    public static String getSettingNow() {
        return SETTING_NOW;
    }


    public static String getSymbol() {
        return symbol;
    }

    public static void setSymbol(String symbol) {
        Gasket.symbol = symbol;
    }

    public static LevelAccounting getLevelAccountingClass() {
        return levelAccountingClass;
    }

    public static void setLevelAccountingClass(LevelAccounting levelAccountingClass) {
        Gasket.levelAccountingClass = levelAccountingClass;
    }

    public static int getNumberFutureCandles() {
        return numberFutureCandles;
    }

    public static void setNumberFutureCandles(int numberFutureCandles) {
        Gasket.numberFutureCandles = numberFutureCandles;
    }

    public static PatternStatistics getPatternStatisticsClass() {
        return patternStatisticsClass;
    }

    public static void setPatternStatisticsClass(PatternStatistics patternStatisticsClass) {
        Gasket.patternStatisticsClass = patternStatisticsClass;
    }

    public static WritePatterns getWritePatternsClass() {
        return writePatternsClass;
    }

    public static void setWritePatternsClass(WritePatterns writePatternsClass) {
        Gasket.writePatternsClass = writePatternsClass;
    }

    public static ReadHistory getReadHistoryClass() {
        return readHistoryClass;
    }

    public static void setReadHistoryClass(ReadHistory readHistoryClass) {
        Gasket.readHistoryClass = readHistoryClass;
    }

    public static ExecutorCommandos getExecutorCommandosClass() {
        return executorCommandosClass;
    }

    public static void setExecutorCommandosClass(ExecutorCommandos executorCommandosClass) {
        Gasket.executorCommandosClass = executorCommandosClass;
    }

    public static FilesAndPathCreator getFilesAndPathCreatorClass() {
        return filesAndPathCreatorClass;
    }

    public static void setFilesAndPathCreatorClass(FilesAndPathCreator filesAndPathCreatorClass) {
        Gasket.filesAndPathCreatorClass = filesAndPathCreatorClass;
    }

    public static RunAndStopProgram getRunProgramClass() {
        return runAndStopProgramClass;
    }

    public static void setRunProgramClass(RunAndStopProgram runAndStopProgramClass) {
        Gasket.runAndStopProgramClass = runAndStopProgramClass;
    }

    public static int getDateDifference() {
        return dateDifference;
    }

    public static void setDateDifference(int dateDifference) {
        Gasket.dateDifference = dateDifference;
    }

    public static View getViewThreadClass() {
        return viewThreadClass;
    }

    public static void setViewThreadClass(View viewThreadClass) {
        Gasket.viewThreadClass = viewThreadClass;
    }
}

