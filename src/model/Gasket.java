package model;

import controller.ExecutorCommandos;
import controller.RunAndStopProgram;
import view.View;




public class Gasket {
    // Class
    private static FilesAndPathCreator filesAndPathCreatorClass;
    private static ReadAndWriteSetting readAndWriteSettingClass;
    private static PatternStatistics patternStatisticsClass;
    private static ExecutorCommandos executorCommandosClass;
    private static RunAndStopProgram runAndStopProgramClass;
    private static LevelAccounting levelAccountingClass;
    private static WritePatterns writePatternsClass;
    private static WriteHistory writeHistoryClass;
    private static ReadHistory readHistoryClass;
    private static Statistics statisticsClass;
    private static View viewThreadClass;
    private static History historyClass;
    private static Pattern patternClass;


    // Levels
    private static int ask = 0;
    private static int askHL = 0;
    private static int askHLSmall = 0;
    private static int askSmall = 0;
    private static int bid = 0;
    private static int bidHL = 0;
    private static int bidHLSmall = 0;
    private static int bidSmall = 0;
    private static int deltaAsk = 0;
    private static int deltaAskHL = 0;
    private static int deltaAskHLSmall = 0;
    private static int deltaAskSmall = 0;
    private static int deltaBid = 0;
    private static int deltaBidHL = 0;
    private static int deltaBidHLSmall = 0;
    private static int deltaBidSmall = 0;
    private static int deltaZSMinMinus = 0;
    private static int deltaZSMinPlus = 0;
    private static int deltaZSMinus = 0;
    private static int deltaZSPlus = 0;
    private static int OIZSMinMinus = 0;
    private static int OIZSMinPlus = 0;
    private static int OIZSMinus = 0;
    private static int OIZSPlus = 0;
    private static int openPosAskMinus = 0;
    private static int openPosAskMinusSmall = 0;
    private static int openPosAskPlus = 0;
    private static int openPosAskPlusSmall = 0;
    private static int openPosBidMinus = 0;
    private static int openPosBidMinusSmall = 0;
    private static int openPosBidPlus = 0;
    private static int openPosBidPlusSmall = 0;
    private static int openPosMinus = 0;
    private static int openPosMinusHL = 0;
    private static int openPosMinusHLSmall = 0;
    private static int openPosMinusSmall = 0;
    private static int openPosPlus = 0;
    private static int openPosPlusHL = 0;
    private static int openPosPlusHLSmall = 0;
    private static int openPosPlusSmall = 0;
    private static int volume = 0;
    private static int volumeHL = 0;
    private static int volumeHLSmall = 0;
    private static int volumeSmall = 0;


    // TimeFrame
    private static int m1 = 0;
    private static int m5 = 0;
    private static int m15 = 0;
    private static int m30 = 0;
    private static int h1 = 0;
    private static int h4 = 0;


    // Settings
    private static boolean readHistoryOrConvertFilesToHistory = false;   // считать историю или конвертировать файлы в историю
    private static int indentFromLastLevelInPattern = 5;                // отступ от последнего уровня в паттерне (минуты)
    private static boolean dirMainCandle = false;                      // учитывать или нет направление Главных свечей на которых расположены уровни
    private static int numberFutureCandles = 30;                      // количество будущих свечей в которое надо посмотреть
    private static boolean showPattern = true;                       // показывать или нет паттерн
    private static boolean dirCandle = false;                       // учитывать или нет направление свечи на которых расположены уровни
    private static String symbol = "BTCUSD";
    private static double takeProfit = 15.0;
    private static double stopLoss = 15.0;
    private static int dateDifference = 0;


    // Strings
    private static final String SETTING_NOW = " --- SETTING_NOW --- ";
    private static String startDate;
    private static String endDate;




    public static String getSettingNow() {
        return SETTING_NOW;
    }


    public static int getIndentFromLastLevelInPattern() {
        return indentFromLastLevelInPattern;
    }

    public static void setIndentFromLastLevelInPattern(int indentFromLastLevelInPattern) {
        Gasket.indentFromLastLevelInPattern = indentFromLastLevelInPattern;
    }

    public static ReadAndWriteSetting getReadAndWriteSettingClass() {
        return readAndWriteSettingClass;
    }

    public static void setReadAndWriteSettingClass(ReadAndWriteSetting readAndWriteSettingClass) {
        Gasket.readAndWriteSettingClass = readAndWriteSettingClass;
    }

    public static boolean isReadHistoryOrConvertFilesToHistory() {
        return readHistoryOrConvertFilesToHistory;
    }

    public static void setReadHistoryOrConvertFilesToHistory(boolean readHistoryOrConvertFilesToHistory) {
        Gasket.readHistoryOrConvertFilesToHistory = readHistoryOrConvertFilesToHistory;
    }

    public static WriteHistory getWriteHistoryClass() {
        return writeHistoryClass;
    }

    public static void setWriteHistoryClass(WriteHistory writeHistoryClass) {
        Gasket.writeHistoryClass = writeHistoryClass;
    }

    public static boolean isDirMainCandle() {
        return dirMainCandle;
    }

    public static void setDirMainCandle(boolean dirMainCandle) {
        Gasket.dirMainCandle = dirMainCandle;
    }

    public static boolean isDirCandle() {
        return dirCandle;
    }

    public static void setDirCandle(boolean dirCandle) {
        Gasket.dirCandle = dirCandle;
    }

    public static int getM1() {
        return m1;
    }

    public static void setM1(int m1) {
        Gasket.m1 = m1;
    }

    public static int getM5() {
        return m5;
    }

    public static void setM5(int m5) {
        Gasket.m5 = m5;
    }

    public static int getM15() {
        return m15;
    }

    public static void setM15(int m15) {
        Gasket.m15 = m15;
    }

    public static int getM30() {
        return m30;
    }

    public static void setM30(int m30) {
        Gasket.m30 = m30;
    }

    public static int getH1() {
        return h1;
    }

    public static void setH1(int h1) {
        Gasket.h1 = h1;
    }

    public static int getH4() {
        return h4;
    }

    public static void setH4(int h4) {
        Gasket.h4 = h4;
    }

    public static double getTakeProfit() {
        return takeProfit;
    }

    public static void setTakeProfit(double takeProfit) {
        Gasket.takeProfit = takeProfit;
    }

    public static double getStopLoss() {
        return stopLoss;
    }

    public static void setStopLoss(double stopLoss) {
        Gasket.stopLoss = stopLoss;
    }

    public static boolean isShowPattern() {
        return showPattern;
    }

    public static void setShowPattern(boolean showPattern) {
        Gasket.showPattern = showPattern;
    }

    public static Statistics getStatisticsClass() {
        return statisticsClass;
    }

    public static void setStatisticsClass(Statistics statisticsClass) {
        Gasket.statisticsClass = statisticsClass;
    }

    public static Pattern getPatternClass() {
        return patternClass;
    }

    public static void setPatternClass(Pattern patternClass) {
        Gasket.patternClass = patternClass;
    }

    public static History getHistoryClass() {
        return historyClass;
    }

    public static void setHistoryClass(History historyClass) {
        Gasket.historyClass = historyClass;
    }

    public static String getStartDate() {
        return startDate;
    }

    public static void setStartDate(String startDate) {
        Gasket.startDate = startDate;
    }

    public static String getEndDate() {
        return endDate;
    }

    public static void setEndDate(String endDate) {
        Gasket.endDate = endDate;
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

    public static int getAsk() {
        return ask;
    }

    public static void setAsk(int ask) {
        Gasket.ask = ask;
    }

    public static int getAskHL() {
        return askHL;
    }

    public static void setAskHL(int askHL) {
        Gasket.askHL = askHL;
    }

    public static int getAskHLSmall() {
        return askHLSmall;
    }

    public static void setAskHLSmall(int askHLSmall) {
        Gasket.askHLSmall = askHLSmall;
    }

    public static int getAskSmall() {
        return askSmall;
    }

    public static void setAskSmall(int askSmall) {
        Gasket.askSmall = askSmall;
    }

    public static int getBid() {
        return bid;
    }

    public static void setBid(int bid) {
        Gasket.bid = bid;
    }

    public static int getBidHL() {
        return bidHL;
    }

    public static void setBidHL(int bidHL) {
        Gasket.bidHL = bidHL;
    }

    public static int getBidHLSmall() {
        return bidHLSmall;
    }

    public static void setBidHLSmall(int bidHLSmall) {
        Gasket.bidHLSmall = bidHLSmall;
    }

    public static int getBidSmall() {
        return bidSmall;
    }

    public static void setBidSmall(int bidSmall) {
        Gasket.bidSmall = bidSmall;
    }

    public static int getDeltaAsk() {
        return deltaAsk;
    }

    public static void setDeltaAsk(int deltaAsk) {
        Gasket.deltaAsk = deltaAsk;
    }

    public static int getDeltaAskHL() {
        return deltaAskHL;
    }

    public static void setDeltaAskHL(int deltaAskHL) {
        Gasket.deltaAskHL = deltaAskHL;
    }

    public static int getDeltaAskHLSmall() {
        return deltaAskHLSmall;
    }

    public static void setDeltaAskHLSmall(int deltaAskHLSmall) {
        Gasket.deltaAskHLSmall = deltaAskHLSmall;
    }

    public static int getDeltaAskSmall() {
        return deltaAskSmall;
    }

    public static void setDeltaAskSmall(int deltaAskSmall) {
        Gasket.deltaAskSmall = deltaAskSmall;
    }

    public static int getDeltaBid() {
        return deltaBid;
    }

    public static void setDeltaBid(int deltaBid) {
        Gasket.deltaBid = deltaBid;
    }

    public static int getDeltaBidHL() {
        return deltaBidHL;
    }

    public static void setDeltaBidHL(int deltaBidHL) {
        Gasket.deltaBidHL = deltaBidHL;
    }

    public static int getDeltaBidHLSmall() {
        return deltaBidHLSmall;
    }

    public static void setDeltaBidHLSmall(int deltaBidHLSmall) {
        Gasket.deltaBidHLSmall = deltaBidHLSmall;
    }

    public static int getDeltaBidSmall() {
        return deltaBidSmall;
    }

    public static void setDeltaBidSmall(int deltaBidSmall) {
        Gasket.deltaBidSmall = deltaBidSmall;
    }

    public static int getDeltaZSMinMinus() {
        return deltaZSMinMinus;
    }

    public static void setDeltaZSMinMinus(int deltaZSMinMinus) {
        Gasket.deltaZSMinMinus = deltaZSMinMinus;
    }

    public static int getDeltaZSMinPlus() {
        return deltaZSMinPlus;
    }

    public static void setDeltaZSMinPlus(int deltaZSMinPlus) {
        Gasket.deltaZSMinPlus = deltaZSMinPlus;
    }

    public static int getDeltaZSMinus() {
        return deltaZSMinus;
    }

    public static void setDeltaZSMinus(int deltaZSMinus) {
        Gasket.deltaZSMinus = deltaZSMinus;
    }

    public static int getDeltaZSPlus() {
        return deltaZSPlus;
    }

    public static void setDeltaZSPlus(int deltaZSPlus) {
        Gasket.deltaZSPlus = deltaZSPlus;
    }

    public static int getOIZSMinMinus() {
        return OIZSMinMinus;
    }

    public static void setOIZSMinMinus(int oIZSMinMinus) {
        Gasket.OIZSMinMinus = oIZSMinMinus;
    }

    public static int getOIZSMinPlus() {
        return OIZSMinPlus;
    }

    public static void setOIZSMinPlus(int oIZSMinPlus) {
        Gasket.OIZSMinPlus = oIZSMinPlus;
    }

    public static int getOIZSMinus() {
        return OIZSMinus;
    }

    public static void setOIZSMinus(int oIZSMinus) {
        Gasket.OIZSMinus = oIZSMinus;
    }

    public static int getOIZSPlus() {
        return OIZSPlus;
    }

    public static void setOIZSPlus(int oIZSPlus) {
        Gasket.OIZSPlus = oIZSPlus;
    }

    public static int getOpenPosAskMinus() {
        return openPosAskMinus;
    }

    public static void setOpenPosAskMinus(int openPosAskMinus) {
        Gasket.openPosAskMinus = openPosAskMinus;
    }

    public static int getOpenPosAskMinusSmall() {
        return openPosAskMinusSmall;
    }

    public static void setOpenPosAskMinusSmall(int openPosAskMinusSmall) {
        Gasket.openPosAskMinusSmall = openPosAskMinusSmall;
    }

    public static int getOpenPosAskPlus() {
        return openPosAskPlus;
    }

    public static void setOpenPosAskPlus(int openPosAskPlus) {
        Gasket.openPosAskPlus = openPosAskPlus;
    }

    public static int getOpenPosAskPlusSmall() {
        return openPosAskPlusSmall;
    }

    public static void setOpenPosAskPlusSmall(int openPosAskPlusSmall) {
        Gasket.openPosAskPlusSmall = openPosAskPlusSmall;
    }

    public static int getOpenPosBidMinus() {
        return openPosBidMinus;
    }

    public static void setOpenPosBidMinus(int openPosBidMinus) {
        Gasket.openPosBidMinus = openPosBidMinus;
    }

    public static int getOpenPosBidMinusSmall() {
        return openPosBidMinusSmall;
    }

    public static void setOpenPosBidMinusSmall(int openPosBidMinusSmall) {
        Gasket.openPosBidMinusSmall = openPosBidMinusSmall;
    }

    public static int getOpenPosBidPlus() {
        return openPosBidPlus;
    }

    public static void setOpenPosBidPlus(int openPosBidPlus) {
        Gasket.openPosBidPlus = openPosBidPlus;
    }

    public static int getOpenPosBidPlusSmall() {
        return openPosBidPlusSmall;
    }

    public static void setOpenPosBidPlusSmall(int openPosBidPlusSmall) {
        Gasket.openPosBidPlusSmall = openPosBidPlusSmall;
    }

    public static int getOpenPosMinus() {
        return openPosMinus;
    }

    public static void setOpenPosMinus(int openPosMinus) {
        Gasket.openPosMinus = openPosMinus;
    }

    public static int getOpenPosMinusHL() {
        return openPosMinusHL;
    }

    public static void setOpenPosMinusHL(int openPosMinusHL) {
        Gasket.openPosMinusHL = openPosMinusHL;
    }

    public static int getOpenPosMinusHLSmall() {
        return openPosMinusHLSmall;
    }

    public static void setOpenPosMinusHLSmall(int openPosMinusHLSmall) {
        Gasket.openPosMinusHLSmall = openPosMinusHLSmall;
    }

    public static int getOpenPosMinusSmall() {
        return openPosMinusSmall;
    }

    public static void setOpenPosMinusSmall(int openPosMinusSmall) {
        Gasket.openPosMinusSmall = openPosMinusSmall;
    }

    public static int getOpenPosPlus() {
        return openPosPlus;
    }

    public static void setOpenPosPlus(int openPosPlus) {
        Gasket.openPosPlus = openPosPlus;
    }

    public static int getOpenPosPlusHL() {
        return openPosPlusHL;
    }

    public static void setOpenPosPlusHL(int openPosPlusHL) {
        Gasket.openPosPlusHL = openPosPlusHL;
    }

    public static int getOpenPosPlusHLSmall() {
        return openPosPlusHLSmall;
    }

    public static void setOpenPosPlusHLSmall(int openPosPlusHLSmall) {
        Gasket.openPosPlusHLSmall = openPosPlusHLSmall;
    }

    public static int getOpenPosPlusSmall() {
        return openPosPlusSmall;
    }

    public static void setOpenPosPlusSmall(int openPosPlusSmall) {
        Gasket.openPosPlusSmall = openPosPlusSmall;
    }

    public static int getVolume() {
        return volume;
    }

    public static void setVolume(int volume) {
        Gasket.volume = volume;
    }

    public static int getVolumeHL() {
        return volumeHL;
    }

    public static void setVolumeHL(int volumeHL) {
        Gasket.volumeHL = volumeHL;
    }

    public static int getVolumeHLSmall() {
        return volumeHLSmall;
    }

    public static void setVolumeHLSmall(int volumeHLSmall) {
        Gasket.volumeHLSmall = volumeHLSmall;
    }

    public static int getVolumeSmall() {
        return volumeSmall;
    }

    public static void setVolumeSmall(int volumeSmall) {
        Gasket.volumeSmall = volumeSmall;
    }
}

