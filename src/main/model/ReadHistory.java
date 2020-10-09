package main.model;

import main.view.ConsoleHelper;
import main.view.WriterAndReadFile;

import java.io.File;
import java.util.ArrayList;



public class ReadHistory {
    private ArrayList<String> fullHistory;
    private ArrayList<String> filesList;
    private ArrayList<String> strings;
    private String path;



    public ReadHistory() {
        this.path = Gasket.getFilesAndPathCreatorClass().getPathHistory();
        this.fullHistory = new ArrayList<>();
        this.filesList = new ArrayList<>();
        this.strings = new ArrayList<>();
        createdPathFolderAndStartReading();
        Gasket.setReadHistoryClass(this);
    }



    private void createdPathFolderAndStartReading() {
        if (Gasket.isReadHistoryOrConvertFilesToHistory()) {
            readFileHistory();
        } else {
            String pathFolder = path.replace("/History.txt", "");
            File file = new File(pathFolder);
            addAllFilesList(file);

            for (String s : filesList) {
                String pathFile = pathFolder + "/" + s;
                readFileHistory(pathFile);
                strings.remove(strings.size() - 1);
                strings.remove(strings.size() - 1);
                strings.remove(0);
                strings.remove(0);
                strings.set(strings.size() - 1, strings.get(strings.size() - 1) + ",");
                fullHistory.addAll(strings);
                strings.clear();
            }
            new ConverterHistory(fullHistory);
            fullHistory.clear();
        }
    }



    // находим все нужные файлы в папке и заполняем ими лист
    private void addAllFilesList(File folder) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                addAllFilesList(fileEntry);
            } else {
                if (fileEntry.getName().endsWith("txt") && !fileEntry.getName().endsWith("History.txt")) {
                    filesList.add(fileEntry.getName());
                }
            }
        }
    }



    private void readFileHistory(String pathFile) {
        try {
            strings.addAll(WriterAndReadFile.readFile(pathFile));
            if (strings.size() < 1) {
                ConsoleHelper.writeMessage(StringHelper.getString(Outs.FILE_HISTORY_NOT_DETECTED));
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.HISTORY_FILE_READING_ERROR));
        }
    }


    private void readFileHistory() {
        ArrayList<String> historyList = new ArrayList<>();
        try {
            historyList.addAll(WriterAndReadFile.readFile(path));
            if (historyList.size() < 1) {
                ConsoleHelper.writeMessage(StringHelper.getString(Outs.FILE_HISTORY_NOT_DETECTED));
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.HISTORY_FILE_READING_ERROR));
        }

        historyList.remove(historyList.size() - 1);
        historyList.remove(historyList.size() - 1);
        historyList.remove(0);
        historyList.remove(0);

        new ConverterHistory(historyList);
        historyList.clear();
    }
}
