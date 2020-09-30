package controller;

import model.*;
import view.View;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        View view = new View();
        Gasket.setViewThreadClass(view);
        view.start();

        while (true) {
            if (view.isStartFlag()) {
                break;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Запускаем все что связано с путями, файлами, чнением и настройками.
//        Gasket.setCommandos(new Commandos());
        FilesAndPathCreator filesAndPathCreator = new FilesAndPathCreator();
        ExecutorCommandos executorCommandos = new ExecutorCommandos();
        ReadAndWriteSetting readAndWriteSetting = new ReadAndWriteSetting(executorCommandos);
        PatternStatistics patternStatistics = new PatternStatistics();
        LevelAccounting levelAccounting = new LevelAccounting();
        WritePatterns writePatterns = new WritePatterns();
        ReadHistory readHistory = new ReadHistory();



//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("{\"candle\": [\"time\": \"2020-05-21 15:30:00\",\"open\": \"9092.5\",\"close\": \"9085.0\",\"high\": \"9093.0\",\"low\": \"9081.0\",\"dir\": \"-1\"]}");
//        arrayList.add("{\"candle\": [\"time\": \"2020-05-21 15:31:00\",\"open\": \"9092.5\",\"close\": \"9085.0\",\"high\": \"9093.0\",\"low\": \"9081.0\",\"dir\": \"-1\"],\"levels\": [[\"period\": \"M5\",\"preview\": \"1\",\"price\": \"9075.5\",\"value\": \"-635002\",\"type\": \"DELTA_BID_HL\",\"avg\": \"0\"],[\"period\": \"M5\",\"preview\": \"1\",\"price\": \"9076.0\",\"value\": \"216117\",\"type\": \"OPEN_POS_ASK_PLUS\",\"avg\": \"505609\"]]}");
//        arrayList.add("{\"candle\": [\"time\": \"2020-05-21 15:32:00\",\"open\": \"9092.5\",\"close\": \"9085.0\",\"high\": \"9093.0\",\"low\": \"9081.0\",\"dir\": \"-1\"]}");
//        arrayList.add("{\"candle\": [\"time\": \"2020-05-21 15:32:00\",\"open\": \"9092.5\",\"close\": \"9085.0\",\"high\": \"9093.0\",\"low\": \"9081.0\",\"dir\": \"-1\"]}");
//        writePatterns.writePattern(arrayList);
    }

}
