package model;

import view.ConsoleHelper;
import view.WriterAndReadFile;

import java.util.ArrayList;

public class WriteHistory {
    private String path;



    public WriteHistory() {
        this.path = Gasket.getFilesAndPathCreatorClass().getPathHistory();
        Gasket.setWriteHistoryClass(this);
        writeHistory();
    }


    public void writeHistory() {
        if (Gasket.getHistoryClass().getHistorySize() > 0) {
            try {
                WriterAndReadFile.writerFile(getStringWrite(Gasket.getHistoryClass()
                        .getHistoryList()), path, false);
            } catch (Exception ex) {
                ConsoleHelper.writeMessage(StringHelper.getString(Outs.SAVED_HISTORY_FILE_WRITE_ERROR));
            }
        } else {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.NO_HISTORY_TO_SAVE));
        }
        ConsoleHelper.writeMessage(StringHelper.getString(Outs.HISTORY_SUCCESSFULLY_SAVED));
    }


    private String getStringWrite(ArrayList<String> in) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : in) {
            stringBuilder.append(s).append("\n");
        }
//        stringBuilder.append(Str.NEXT.toString()).append("\n");
        return stringBuilder.toString();
    }
}
