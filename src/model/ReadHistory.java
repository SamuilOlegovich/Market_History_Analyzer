package model;

import view.ConsoleHelper;
import view.WriterAndReadFile;

import java.util.ArrayList;



public class ReadHistory {
    private String path;



    public ReadHistory() {
        this.path = Gasket.getFilesAndPathCreatorClass().getPathHistory();
        Gasket.setReadHistoryClass(this);
        readFileHistory();
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
        new ConverterHistory(historyList);
        historyList.clear();
    }
}
