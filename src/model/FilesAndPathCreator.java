package model;

import view.ConsoleHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class FilesAndPathCreator {
    private String pathSavedPatterns;
    private String pathSettings;
    private String pathHistory;
    private String pathLogs;


    public FilesAndPathCreator() {
        Gasket.setFilesAndPathCreatorClass(this);
        createdPath();
        createdFileLog();
        isTheFileInPlace();
        showPath();
    }



    private void createdPath() {
        String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        String[] stringsSplit = path.split("/");
        path = stringsSplit[stringsSplit.length - 1];

        String[] strings = getClass().getResource("").getPath().split(path);
        String finish = strings[0].replaceAll("file:", "");



        if (System.getProperty("os.name").startsWith("Windows")) {
            finish = finish.replaceFirst("/", "").replaceAll("/", "\\\\");
        }

        if (strings.length == 2) {

            if (System.getProperty("os.name").startsWith("Windows")) {

                Path  patterns = Paths.get(finish + "Patterns");

                if (!Files.exists(patterns)) {
                    try {
                        Files.createDirectories(Paths.get("Patterns"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Path history = Paths.get(finish + "History");

                if (!Files.exists(history)) {
                    try {
                        Files.createDirectories(Paths.get("History"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Path pathSetting = Paths.get(finish + "Settings");

                if (!Files.exists(pathSetting)) {
                    // действия, если папка существует
                    try {
                        Files.createDirectories(Paths.get("Settings"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Path pathLog = Paths.get(finish + "Logs");

                if (!Files.exists(pathLog)) {
                    // действия, если папка существует
                    try {
                        Files.createDirectories(Paths.get("Logs"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                pathLogs = finish  + "Logs\\" + DatesTimes.getDateLogs().replaceAll(":", "-")
                        + " Log.txt";
                pathSavedPatterns = finish + "Patterns\\SavedPatterns.txt";
                pathSettings = finish + "Settings\\Settings.txt";
                pathHistory = finish + "History\\History.txt";

            } else {

                Path patterns = Paths.get(strings[0] + "Patterns");

                if (!Files.exists(patterns)) {
                    try {
                        Files.createDirectories(Paths.get("Patterns"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Path history = Paths.get(strings[0] + "History");

                if (!Files.exists(history)) {
                    try {
                        Files.createDirectories(Paths.get("History"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Path pathSetting = Paths.get(strings[0] + "Settings");

                if (!Files.exists(pathSetting)) {
                    // действия, если папка существует
                    try {
                        Files.createDirectories(Paths.get("Settings"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Path pathLog = Paths.get(strings[0] + "Logs");

                if (!Files.exists(pathLog)) {
                    // действия, если папка существует
                    try {
                        Files.createDirectories(Paths.get("Logs"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                pathLogs = finish + "Logs/" + DatesTimes.getDateLogs() + " Log.txt";
                pathSavedPatterns = finish + "Patterns/SavedPatterns.txt";
                pathHistory = finish + "History/History.txt";
                pathSettings = finish + "Settings/Settings.txt";
            }
        } else {
            String string = getClass().getResource("").getPath()
                    .replaceAll("target/classes", "src/main/java")
                    .replaceAll("model/", "");

            pathLogs = string + "Logs/Log/" + DatesTimes.getDateLogs() + "===Log.txt";
            pathSavedPatterns = string + "Logs/Patterns/SavedPatterns.txt";
            pathHistory = string + "Logs/History/History.txt";
            pathSettings = string + "Logs/Settings.txt";
        }

        if (System.getProperty("os.name").startsWith("Windows")) {
            pathSavedPatterns = pathSavedPatterns
                    .replaceFirst("/", "").replaceAll("/", "\\\\");
            pathSettings = pathSettings
                    .replaceFirst("/", "").replaceAll("/", "\\\\");
            pathHistory = pathHistory
                    .replaceFirst("/", "").replaceAll("/", "\\\\");
            pathLogs = pathLogs
                    .replaceFirst("/", "").replaceAll("/", "\\\\");
        }
    }



    private void showPath() {
        ConsoleHelper.writeMessage(DatesTimes.getDateTerminal() + " --- " + pathSavedPatterns);
        ConsoleHelper.writeMessage(DatesTimes.getDateTerminal() + " --- " + pathSettings);
        ConsoleHelper.writeMessage(DatesTimes.getDateTerminal() + " --- " + pathHistory);
        ConsoleHelper.writeMessage(DatesTimes.getDateTerminal() + " --- " + pathLogs);
    }



    private void isTheFileInPlace() {
        if (!Files.exists(Paths.get(pathSavedPatterns))) createdFileSavedPatterns();
        if (!Files.exists(Paths.get(pathSettings))) createdFileSettings();
        if (!Files.exists(Paths.get(pathHistory))) createdFileHistory();
    }



    private void createdFileSavedPatterns() {
        File file = new File(pathSavedPatterns);
        try {
            boolean newFile = file.createNewFile();
            ConsoleHelper.writeMessage(DatesTimes.getDateTerminal() + " --- "
                    + "Новый файл SavedPatterns успешно создан.");
        } catch (IOException ex) {
            ConsoleHelper.writeMessage(DatesTimes.getDateTerminal() + " --- "
                    + "Не удалось создать файл SavedPatterns.");
        }
    }



    private void createdFileSettings() {
        File file = new File(pathSettings);
        try {
            boolean newFile = file.createNewFile();
            ConsoleHelper.writeMessage(DatesTimes.getDateTerminal() + " --- "
                    + "Новый файл Settings успешно создан.");
        } catch (IOException ex) {
            ConsoleHelper.writeMessage(DatesTimes.getDateTerminal() + " --- "
                    + "Не удалось Settings файл Настроек.");
        }
    }


    private void createdFileHistory() {
        File file = new File(pathHistory);
        try {
            boolean newFile = file.createNewFile();
            ConsoleHelper.writeMessage(DatesTimes.getDateTerminal() + " --- "
                    + "Новый файл для History успешно создан.");
        } catch (IOException ex) {
            ConsoleHelper.writeMessage(DatesTimes.getDateTerminal() + " --- "
                    + "Не удалось создать файл History.");
        }
    }



    private void createdFileLog() {
        File file = new File(pathLogs);
        try {
            boolean newFile = file.createNewFile();
            ConsoleHelper.writeMessage(DatesTimes.getDateTerminal() + " --- "
                    + "Новый Лог файл успешно создан.");
        } catch (IOException ex) {
            ConsoleHelper.writeMessage(DatesTimes.getDateTerminal() + " --- "
                    + "Не удалось создать Лог файл.");
        }
    }


    public String getPathSettings() {
        return pathSettings;
    }

    public String getPathSavedPatterns() {
        return pathSavedPatterns;
    }

    public String getPathHistory() {
        return pathHistory;
    }

    public String getPathLogs() {
        return pathLogs;
    }
}

