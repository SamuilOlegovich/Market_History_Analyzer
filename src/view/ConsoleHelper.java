package view;

import model.Gasket;



public class ConsoleHelper {
    public static synchronized void writeMessage(String string) {
        Gasket.getViewThreadClass().updateInfoView(string);
        WriterAndReadFile.writerFile(string + "\n"
                , Gasket.getFilesAndPathCreatorClass().getPathLogs()
                , true);
        System.out.println(string);
    }


    public static synchronized String getStringInfoSettings() {
        return  Gasket.getSettingNow()
                + "\n"
                + "\n"
                + "ask === " + Gasket.getAsk()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "askHL === " + Gasket.getAskHL()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "askHLSmall === " + Gasket.getAskHLSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "askSmall === " + Gasket.getAskSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "bid === " + Gasket.getBid()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "bidHL === " + Gasket.getBidHL()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "bidHLSmall === " + Gasket.getBidHLSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "bidSmall === " + Gasket.getBidSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "deltaAsk === " + Gasket.getDeltaAsk()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "deltaAskHL === " + Gasket.getDeltaAskHL()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "deltaAskHLSmall === " + Gasket.getDeltaAskHLSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "deltaAskSmall === " + Gasket.getDeltaAskSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "deltaBid === " + Gasket.getDeltaBid()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "deltaBidHL === " + Gasket.getDeltaBidHL()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "deltaBidHLSmall === " + Gasket.getDeltaBidHLSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "deltaBidSmall === " + Gasket.getDeltaBidSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "deltaZSMinMinus === " + Gasket.getDeltaZSMinMinus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "deltaZSMinPlus === " + Gasket.getDeltaZSMinPlus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "deltaZSMinus === " + Gasket.getDeltaZSMinus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "deltaZSPlus === " + Gasket.getDeltaZSPlus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "OIZSMinMinus === " + Gasket.getOIZSMinMinus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "OIZSMinPlus === " + Gasket.getOIZSMinPlus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "OIZSMinus === " + Gasket.getOIZSMinus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "OIZSPlus === " + Gasket.getOIZSPlus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosAskMinus === " + Gasket.getOpenPosAskMinus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosAskMinusSmall === " + Gasket.getOpenPosAskMinusSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosAskPlus === " + Gasket.getOpenPosAskPlus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosAskPlusSmall === " + Gasket.getOpenPosAskPlusSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosBidMinus === " + Gasket.getOpenPosBidMinus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosBidMinusSmall === " + Gasket.getOpenPosBidMinusSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosBidPlus === " + Gasket.getOpenPosBidPlus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosBidPlusSmall === " + Gasket.getOpenPosBidPlusSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosMinus === " + Gasket.getOpenPosMinus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosMinusHL === " + Gasket.getOpenPosMinusHL()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosMinusHLSmall === " + Gasket.getOpenPosMinusHLSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosMinusSmall === " + Gasket.getOpenPosMinusSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosPlus === " + Gasket.getOpenPosPlus()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosPlusHL === " + Gasket.getOpenPosPlusHL()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosPlusHLSmall === " + Gasket.getOpenPosPlusHLSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "openPosPlusSmall === " + Gasket.getOpenPosPlusSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "volume === " + Gasket.getVolume()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "volumeHL === " + Gasket.getVolumeHL()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "volumeHLSmall === " + Gasket.getVolumeHLSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "volumeSmall === " + Gasket.getVolumeSmall()
                + " ----- 0 -> отключён, 1 -> включен, 2 -> включен и главный\n"
                + "\n"
                + "\n"
                + "M1 === " + Gasket.getM1() + " ----- 0 -> отключён, 1 -> включен\n"
                + "M5 === " + Gasket.getM5() + " ----- 0 -> отключён, 1 -> включен\n"
                + "M15 === " + Gasket.getM15() + " ----- 0 -> отключён, 1 -> включен\n"
                + "M30 === " + Gasket.getM30() + " ----- 0 -> отключён, 1 -> включен\n"
                + "H1 === " + Gasket.getH1() + " ----- 0 -> отключён, 1 -> включен\n"
                + "H4 === " + Gasket.getH4() + " ----- 0 -> отключён, 1 -> включен\n"
                + "\n"
                + "\n"
                + "numberFutureCandles === " + Gasket.getNumberFutureCandles()
                + " ----- количество будущих свечей в которое надо посмотреть\n"
                + "indentFromLastLevelInPattern === " + Gasket.getIndentFromLastLevelInPattern()
                + " ----- отступ от последнего уровня в паттерне (минуты)\n"
                + "dirCandle === " + Gasket.isDirCandle()
                + " ----- учитывать или нет направление свечей на которых расположены уровни\n"
                + "dirMainCandle === " + Gasket.isDirMainCandle()
                + " ----- учитывать или нет направление ГЛАВНЫХ свечей на которых расположены уровни\n"
                + "showPattern === " + Gasket.isShowPattern()
                + " ----- показывать или нет паттерн\n"
                + "symbol === " + Gasket.getSymbol()
                + " ----- указываем валютную пару, к примеру --> BTCUSD\n"
                + "takeProfit === " + Gasket.getTakeProfit()
                + " ----- указываем тейк профит --> 15.0\n"
                + "stopLoss === " + Gasket.getStopLoss()
                + " ----- указываем стоп лосс --> 15.0\n"
                + "dateDifference === " + Gasket.getDateDifference()
                + " ----- на сколько время в терминале отстает или опережает местное\n"
                + "readHistoryOrConvertFilesToHistory === " + Gasket.isReadHistoryOrConvertFilesToHistory()
                + " ----- считать историю или конвертировать файлы в историю (при первом старте должно быть false)\n"
                + "\n";
    }



    public static synchronized void printInfoSettings() {
        ConsoleHelper.writeMessage("\n\n"
                + getStringInfoSettings()
                + "\n"
                + "\nЕСЛИ ВЫ ЖЕЛАЕТЕ - ЭТИ НАСТРОЙКИ МОЖНО ИЗМЕНИТЬ\n"
                + "ВВЕДИТЕ ЖЕЛАЕМЫЙ ПАРАМЕТР И ЗНАЧЕНИЕ В ФОРМАТЕ\n"
                + "команда=значение ----> PORT=777\n"
                + "\n"
        );
    }
}
