package model;

import view.ConsoleHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;




// искатель паттернов
public class PatternFinder extends Thread {
    private long start;
    private long end;



    public PatternFinder(Date start, Date end) {
        this.start = start.getTime();
        this.end = end.getTime();
        this.start();
    }



    @Override
    public void run() {
        // получаем лист истории
        ArrayList<String> history = new ArrayList<>(Gasket.getHistoryClass().getHistoryList());
        ConsoleHelper.writeMessage("1");
        // получаем список свечей имеющих уровни
        ArrayList<String> candlesStrings = removeEmptyCandles(getAllCandlesPattern(history));
        ConsoleHelper.writeMessage("2");
        // получаем уже список непосредственно уровней
        Gasket.getWritePatternsClass().setPatternList(removeExtraLevels(getLevels(candlesStrings)));
        ConsoleHelper.writeMessage("3");
        candlesStrings.clear();
        ConsoleHelper.writeMessage("4");
        history.clear();
        ConsoleHelper.writeMessage("5");
        if (Gasket.getWritePatternsClass().getPatternSize() != 0) new HistoryIterator();
        ConsoleHelper.writeMessage("6");
    }




    // получить все свечи паттерна
    private ArrayList<String> getAllCandlesPattern(ArrayList<String> in) {
        ArrayList<String> result = new ArrayList<>();

        for (String s : in) {
            try {
                long dateThisCandle = getDate(s);
//                if (start.getTime() <= dateThisCandle && end.getTime() >= dateThisCandle) {
                if (start <= dateThisCandle && end >= dateThisCandle) {
                    result.add(s);
                }
            } catch (Exception e) {
                ConsoleHelper.writeMessage(StringHelper.getString(Outs.WRONG_DATE_FORMAT_IN_THE_HISTORY_FILE));
                Gasket.getViewThreadClass().setPreviousColor();
            }
        }
        return result;
    }


    // удаляем строки с пустыми свечами
    private ArrayList<String> removeEmptyCandles(ArrayList<String> in) {
        for (int i = in.size() - 1; i >= 0; i--) {
            if (in.get(i).contains("[]}")) { in.remove(i); }
        }
        return in;
    }


    // распарсиваем и получаем массив уровней
    private ArrayList<String> getLevels(ArrayList<String> in) {
        ArrayList<String> levels = new ArrayList<>();
        for (String s : in) {
            String[] str = s.contains(",\"levels\": \"")
                    ? s.split(",\"levels\": ")
                    : s.split(",\"levels\":");

            String[] strings = str[1].split("},\\{");

            for (String ss : strings) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(ss.replaceAll("\\{", "")
                        .replaceAll("}", "")
                        .replaceAll("\\[", "")
                        .replaceAll("]", ""));
                if (stringBuilder.substring(0, 1).toString().equals(" ")) {
                    stringBuilder.delete(0, 1);
                }
                levels.add(stringBuilder.toString());
            }
        }
        /////////////
        StringBuilder stringBuilder = new StringBuilder("size levels => " + levels.size() + "\n");
        for (String sss : levels) {
            stringBuilder.append(sss).append("\n");
        }
        ConsoleHelper.writeMessage(stringBuilder.toString());
        ////////////
        return levels;
    }


    // удаляем лишние уровни
    private ArrayList<String> removeExtraLevels(ArrayList<String> in) {
        ArrayList<String> accountingLevelsList = Gasket.getLevelAccountingClass().getAccountingLevelsList();
        //////////////
        ConsoleHelper.writeMessage("in in => " + in.size());
        //////////////

        for (int i = in.size() - 1; i >= 0; i--) {
            boolean flag = false;
            for (String s : accountingLevelsList) {
                if (s.equalsIgnoreCase(StringHelper.getStringData(Str.type, in.get(i)))) flag = true;
            }
            if (!flag) in.remove(i);
        }

        //////////////
        ConsoleHelper.writeMessage("accountingLevelsList => " + accountingLevelsList.size());
        ConsoleHelper.writeMessage("in out => " + in.size());
        /////////////

        return new ArrayList<>(in);
    }


    private long getDate(String in) throws Exception {
//        String[] strings = in.split("\",\"");
//        String result = in.replaceAll("\\{\"candle\": \\[\"time\": \"", "");
        String[] strings = in.split(Str.levels.toString());

        ////////////
        ConsoleHelper.writeMessage("strings[0] => " + strings[0]);
        ///////////

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        ////////////
        ConsoleHelper.writeMessage("strings[0] => " + StringHelper.getStringData(Str.time, strings[0]));
        ///////////
        ////////////
        ConsoleHelper.writeMessage("strings[0] => " + simpleDateFormat.parse(StringHelper.getStringData(Str.time, strings[0])).getTime());
        ///////////


        return simpleDateFormat.parse(StringHelper.getStringData(Str.time, strings[0])).getTime();
    }
}

//{"candle": ["time": "2020-05-21 15:30:00","open": "9092.5","close": "9085.0","high": "9093.0","low": "9081.0","dir": "-1"]} // если на этой свече нет уровней
//{"candle": ["time": "2020-05-21 15:31:00","open": "9092.5","close": "9085.0","high": "9093.0","low": "9081.0","dir": "-1"],"levels": [["period": "M5","preview": "1","price": "9075.5","value": "-635002","type": "DELTA_BID_HL","avg": "0"],["period": "M5","preview": "1","price": "9076.0","value": "216117","type": "OPEN_POS_ASK_PLUS","avg": "505609"]]}
//{"candle": ["time": "2020-05-21 15:32:00","open": "9092.5","close": "9085.0","high": "9093.0","low": "9081.0","dir": "-1"]}
//{"candle": ["time": "2020-05-21 15:32:00","open": "9092.5","close": "9085.0","high": "9093.0","low": "9081.0","dir": "-1"]}