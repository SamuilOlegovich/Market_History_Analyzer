package main.controller;

import main.model.*;
import main.view.ConsoleHelper;


public class ExecutorCommandos {
    private ReadAndWriteSetting readAndWriteSetting;


    public ExecutorCommandos() {
        Gasket.setExecutorCommandosClass(this);
    }


    public void setReadAndWriteSetting(ReadAndWriteSetting readAndWriteSetting) {
        this.readAndWriteSetting = readAndWriteSetting;
    }




    public void parseAndExecute(String string) {

        String[] strings = string.trim().split(" === ");

        if (strings.length < 1  || strings.length == 1) {
            if (string.equalsIgnoreCase(Gasket.getSettingNow())) {
                return;
            }
            ConsoleHelper.writeMessage(TimesHelper.getDateTerminal()
                    + " --- Вы допустили ошибку, повторите ввод === " + string
                    + "\n"
            );
            return;
        } else {
            strings[1] = strings[1].replaceAll(",", ".");
        }


        try {
            switch (strings[0]) {
                case "ask":
                    Gasket.setAsk(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("ask === " + Gasket.getAsk()));
                    break;
                case "askHL":
                    Gasket.setAskHL(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("askHL === " + Gasket.getAskHL()));
                    break;
                case "askHLSmall":
                    Gasket.setAskHLSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("askHLSmall === " + Gasket.getAskHLSmall()));
                    break;
                case "askSmall":
                    Gasket.setAskSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("askSmall === " + Gasket.getAskSmall()));
                    break;
                case "bid":
                    Gasket.setBid(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("bid === " + Gasket.getBid()));
                    break;
                case "bidHL":
                    Gasket.setBidHL(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("bidHL === " + Gasket.getBidHL()));
                    break;
                case "bidHLSmall":
                    Gasket.setBidHLSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("bidHLSmall === " + Gasket.getBidHLSmall()));
                    break;
                case "bidSmall":
                    Gasket.setBidSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("bidSmall === " + Gasket.getBidSmall()));
                    break;
                case "deltaAsk":
                    Gasket.setDeltaAsk(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("deltaAsk === " + Gasket.getDeltaAsk()));
                    break;
                case "deltaAskHL":
                    Gasket.setDeltaAskHL(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("deltaAskHL === " + Gasket.getDeltaAskHL()));
                    break;
                case "deltaAskHLSmall":
                    Gasket.setDeltaAskHLSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("deltaAskHLSmall === " + Gasket.getDeltaAskHLSmall()));
                    break;
                case "deltaAskSmall":
                    Gasket.setDeltaAskSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("deltaAskSmall === " + Gasket.getDeltaAskSmall()));
                    break;
                case "deltaBid":
                    Gasket.setDeltaBid(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("deltaBid === " + Gasket.getDeltaBid()));
                    break;
                case "deltaBidHL":
                    Gasket.setDeltaBidHL(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("deltaBidHL === " + Gasket.getDeltaBidHL()));
                    break;
                case "deltaBidHLSmall":
                    Gasket.setDeltaBidHLSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("deltaBidHLSmall === " + Gasket.getDeltaBidHLSmall()));
                    break;
                case "deltaBidSmall":
                    Gasket.setDeltaBidSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("deltaBidSmall === " + Gasket.getDeltaBidSmall()));
                    break;
                case "deltaZSMinMinus":
                    Gasket.setDeltaZSMinMinus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("deltaZSMinMinus === " + Gasket.getDeltaZSMinMinus()));
                    break;
                case "deltaZSMinPlus":
                    Gasket.setDeltaZSMinPlus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("deltaZSMinPlus === " + Gasket.getDeltaZSMinPlus()));
                    break;
                case "deltaZSMinus":
                    Gasket.setDeltaZSMinus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("deltaZSMinus === " + Gasket.getDeltaZSMinus()));
                    break;
                case "deltaZSPlus":
                    Gasket.setDeltaZSPlus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("deltaZSPlus === " + Gasket.getDeltaZSPlus()));
                    break;
                case "OIZSMinMinus":
                    Gasket.setOIZSMinMinus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("OIZSMinMinus === " + Gasket.getOIZSMinMinus()));
                    break;
                case "OIZSMinPlus":
                    Gasket.setOIZSMinPlus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("OIZSMinPlus === " + Gasket.getOIZSMinPlus()));
                    break;
                case "OIZSMinus":
                    Gasket.setOIZSMinus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("OIZSMinus === " + Gasket.getOIZSMinus()));
                    break;
                case "OIZSPlus":
                    Gasket.setOIZSPlus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("OIZSPlus === " + Gasket.getOIZSPlus()));
                    break;
                case "openPosAskMinus":
                    Gasket.setOpenPosAskMinus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosAskMinus === " + Gasket.getOpenPosAskMinus()));
                    break;
                case "openPosAskMinusSmall":
                    Gasket.setOpenPosAskMinusSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosAskMinusSmall === " + Gasket.getOpenPosAskMinusSmall()));
                    break;
                case "openPosAskPlus":
                    Gasket.setOpenPosAskPlus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosAskPlus === " + Gasket.getOpenPosAskPlus()));
                    break;
                case "openPosAskPlusSmall":
                    Gasket.setOpenPosAskPlusSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosAskPlusSmall === " + Gasket.getOpenPosAskPlusSmall()));
                    break;
                case "openPosBidMinus":
                    Gasket.setOpenPosBidMinus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosBidMinus === " + Gasket.getOpenPosBidMinus()));
                    break;
                case "openPosBidMinusSmall":
                    Gasket.setOpenPosBidMinusSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosBidMinusSmall === " + Gasket.getOpenPosBidMinusSmall()));
                    break;
                case "openPosBidPlus":
                    Gasket.setOpenPosBidPlus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosBidPlus === " + Gasket.getOpenPosBidPlus()));
                    break;
                case "openPosBidPlusSmall":
                    Gasket.setOpenPosBidPlusSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosBidPlusSmall === " + Gasket.getOpenPosBidPlusSmall()));
                    break;
                case "openPosMinus":
                    Gasket.setOpenPosMinus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosMinus === " + Gasket.getOpenPosMinus()));
                    break;
                case "openPosMinusHL":
                    Gasket.setOpenPosMinusHL(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosMinusHL === " + Gasket.getOpenPosMinusHL()));
                    break;
                case "openPosMinusHLSmall":
                    Gasket.setOpenPosMinusHLSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosMinusHLSmall === " + Gasket.getOpenPosMinusHLSmall()));
                    break;
                case "openPosMinusSmall":
                    Gasket.setOpenPosMinusSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosMinusSmall === " + Gasket.getOpenPosMinusSmall()));
                    break;
                case "openPosPlus":
                    Gasket.setOpenPosPlus(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosPlus === " + Gasket.getOpenPosPlus()));
                    break;
                case "openPosPlusHL":
                    Gasket.setOpenPosPlusHL(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosPlusHL === " + Gasket.getOpenPosPlusHL()));
                    break;
                case "openPosPlusHLSmall":
                    Gasket.setOpenPosPlusHLSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosPlusHLSmall === " + Gasket.getOpenPosPlusHLSmall()));
                    break;
                case "openPosPlusSmall":
                    Gasket.setOpenPosPlusSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("openPosPlusSmall === " + Gasket.getOpenPosPlusSmall()));
                    break;
                case "volume":
                    Gasket.setVolume(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("volume === " + Gasket.getVolume()));
                    break;
                case "volumeHL":
                    Gasket.setVolumeHL(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("volumeHL === " + Gasket.getVolumeHL()));
                    break;
                case "volumeHLSmall":
                    Gasket.setVolumeHLSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("volumeHLSmall === " + Gasket.getVolumeHLSmall()));
                    break;
                case "volumeSmall":
                    Gasket.setVolumeSmall(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("volumeSmall === " + Gasket.getVolumeSmall()));
                    break;


                case "M1":
                    Gasket.setM1(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("M1 === " + Gasket.getM1()));
                    break;
                case "M5":
                    Gasket.setM5(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("M5 === " + Gasket.getM5()));
                    break;
                case "M15":
                    Gasket.setM15(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("M15 === " + Gasket.getM15()));
                    break;
                case "M30":
                    Gasket.setM30(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("M30 === " + Gasket.getM30()));
                    break;
                case "H1":
                    Gasket.setH1(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("H1 === " + Gasket.getH1()));
                    break;
                case "H4":
                    Gasket.setH4(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("H4 === " + Gasket.getH4()));
                    break;


                case "numberFutureCandles":
                    Gasket.setNumberFutureCandles(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("numberFutureCandles === " + Gasket.getNumberFutureCandles()));
                    break;
                case "dateDifference":
                    Gasket.setDateDifference(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("dateDifference === " + Gasket.getDateDifference()));
                    break;
                case "takeProfit":
                    Gasket.setTakeProfit(Double.parseDouble(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("takeProfit === " + Gasket.getTakeProfit()));
                    break;
                case "stopLoss":
                    Gasket.setStopLoss(Double.parseDouble(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("stopLoss === " + Gasket.getStopLoss()));
                    break;
                case "symbol":
                    Gasket.setSymbol(strings[1]);
                    ConsoleHelper.writeMessage(StringHelper.getString("symbol === " + Gasket.getSymbol()));
                    break;
                case "dirCandle":
                    Gasket.setDirCandle(strings[1].equalsIgnoreCase("true"));
                    ConsoleHelper.writeMessage(StringHelper.getString("dirCandle === " + Gasket.isDirCandle()));
                    break;
                case "takeAndStopOrNot" :
                    Gasket.setDirCandle(strings[1].equalsIgnoreCase("true"));
                    ConsoleHelper.writeMessage(StringHelper.getString("dirCandle === " + Gasket.isDirCandle()));
                    break;
                case "showPattern":
                    Gasket.setShowPattern(strings[1].equalsIgnoreCase("true"));
                    ConsoleHelper.writeMessage(StringHelper.getString("showPattern === " + Gasket.isShowPattern()));
                    break;
                case "readHistoryOrConvertFilesToHistory":
                    Gasket.setReadHistoryOrConvertFilesToHistory(strings[1].equalsIgnoreCase("true"));
                    ConsoleHelper.writeMessage(StringHelper.getString("readHistoryOrConvertFilesToHistory === "
                            + Gasket.isReadHistoryOrConvertFilesToHistory()));
                    break;
                case "indentFromLastLevelInPattern":
                    Gasket.setIndentFromLastLevelInPattern(Integer.parseInt(strings[1]));
                    ConsoleHelper.writeMessage(StringHelper.getString("indentFromLastLevelInPattern === "
                            + Gasket.getIndentFromLastLevelInPattern()));
                    break;

                default:
                    ConsoleHelper.writeMessage(TimesHelper.getDateTerminal()
                            + " --- Вы ввели неверную команду, попробуйте еще раз === " + string
                            + "\n"
                    );
            }
            new LevelAccounting();
        } catch (Exception e) {
            ConsoleHelper.writeMessage(TimesHelper.getDateTerminal()
                    + " --- Ошибочка, повторите ввод === " + string
                    + "\n"
            );
        }
        readAndWriteSetting.writeSettings();
    }
}
