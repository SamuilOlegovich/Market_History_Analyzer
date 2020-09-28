package model;

import view.ConsoleHelper;
import view.StringHelper;
import view.WriterAndReadFile;

import java.util.ArrayList;



public class ReadHistory {
    private ArrayList<String> historyList;
    private String path;



    public ReadHistory() {
        this.path = Gasket.getFilesAndPathCreatorClass().getPathHistory();
        this.historyList = new ArrayList<>();
        Gasket.setReadHistoryClass(this);
        readFileHistory();
    }



    private void readFileHistory() {
        try {
            historyList.addAll(WriterAndReadFile.readFile(path));
            if (historyList.size() < 1) {
                ConsoleHelper.writeMessage(StringHelper.getString(Outs.FILE_HISTORY_NOT_DETECTED));
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.HISTORY_FILE_READING_ERROR));
        }
    }


    public ArrayList<String> getHistoryList() {
        return historyList;
    }
}
