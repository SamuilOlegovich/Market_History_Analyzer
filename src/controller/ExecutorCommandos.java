package controller;

import model.DatesTimes;
import model.Enums;
import model.Gasket;
import model.ReadAndWriteSetting;
import view.ConsoleHelper;
import view.StringHelper;



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
            ConsoleHelper.writeMessage(DatesTimes.getDateTerminal()
                    + " --- Вы допустили ошибку, повторите ввод === " + string
                    + "\n"
            );
            return;
        } else {
            strings[1] = strings[1].replaceAll(",", ".");
        }

        try {
            switch (strings[0]) {
//                case "whetherOrNotShowLearningProcess" :
//                    Gasket.setWhetherOrNotShowLearningProcess(strings[1].equalsIgnoreCase("true"));
//                    ConsoleHelper.writeMessage(StringHelper.getString("whetherOrNotShowLearningProcess === "
//                            + Gasket.isWhetherOrNotShowLearningProcess())
//                    );
//                    break;
                case "SETTINGS" :
                    // SETTINGS=RESTART программа перезапустит настройки не отключаясь
                    if (strings[1].equalsIgnoreCase("RESTART")) readAndWriteSetting.writeSettings();
                    break;
                default:
                    ConsoleHelper.writeMessage(DatesTimes.getDateTerminal()
                            + " --- Вы ввели неверную команду, попробуйте еще раз === " + string
                            + "\n"
                    );
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage(DatesTimes.getDateTerminal()
                    + " --- Ошибочка, повторите ввод === " + string
                    + "\n"
            );
        }
        readAndWriteSetting.writeSettings();
    }
}
