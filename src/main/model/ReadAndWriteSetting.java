package main.model;

import main.controller.ExecutorCommandos;
import main.view.ConsoleHelper;
import main.view.WriterAndReadFile;

import java.util.ArrayList;



public class ReadAndWriteSetting {
    private ExecutorCommandos executorCommandos;
    private String path;



    public ReadAndWriteSetting(ExecutorCommandos executorCommandos) {
        this.path = Gasket.getFilesAndPathCreatorClass().getPathSettings();
        this.executorCommandos = executorCommandos;
        Gasket.setReadAndWriteSettingClass(this);
        readFileSettings();
    }


    private void readFileSettings() {
        executorCommandos.setReadAndWriteSetting(this);

        try {
            ArrayList<String> listSettings =  WriterAndReadFile.readFile(path);

            if (listSettings.size() < 1) {
                try {
                    ConsoleHelper.writeMessage(StringHelper
                            .getString(Outs.FILE_SETTINGS_NOT_DETECTED_STANDARD_SETTINGS_INCLUDED));
                    WriterAndReadFile.writerFile(getStringWrite(), path, false);
                } catch (Exception ex) {
                    ConsoleHelper.writeMessage(StringHelper.getString(Outs.SETTINGS_FILE_WRITE_ERROR));
                }
            }


            for (String string : listSettings) {
                if (string.equalsIgnoreCase(Str.END.toString())) {
                    ConsoleHelper.writeMessage(StringHelper.getString(Outs.SETTINGS_SUCCESSFULLY_READ));
                    return;
                }

                String[] strings;

                if (string.length() > 4
                        && !string.equalsIgnoreCase(Gasket.getSettingNow())) {
                    strings = string.split(" ----- ");
                    executorCommandos.parseAndExecute(strings[0]);
                }
            }

        } catch (Exception e) {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.SETTINGS_FILE_READING_ERROR));
        }
    }



    public void writeSettings() {
        try {
            WriterAndReadFile.writerFile(getStringWrite(), path, false);
        } catch (Exception e) {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.SETTINGS_WONT_OVERWRITE_AFTER_THE_CHANGE_COMMAND));
        }
    }



    private String getStringWrite() {
        return ConsoleHelper.getStringInfoSettings()
                + "\n"
                + Str.END.toString()
                + "\n";
    }
}
