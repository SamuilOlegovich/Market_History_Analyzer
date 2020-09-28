package controller;

import model.FilesAndPathCreator;
import model.Gasket;
import model.ReadAndWriteSetting;
import model.ReadHistory;
import view.View;



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
        ReadHistory readHistory = new ReadHistory();

    }

}
