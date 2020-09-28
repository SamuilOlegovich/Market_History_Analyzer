package model;

import controller.ExecutorCommandos;
import controller.RunAndStopProgram;
import view.View;




public class Gasket {
    // Class
    private static FilesAndPathCreator filesAndPathCreatorClass;
    private static ExecutorCommandos executorCommandosClass;
    private static RunAndStopProgram runAndStopProgramClass;
    private static WritePatterns writePatternsClass;
    private static ReadHistory readHistoryClass;
    private static View viewThreadClass;


    // Settings
    private static int dateDifference = 0;


    // Strings
    private static final String SETTING_NOW = " --- SETTING_NOW --- ";




    public static String getSettingNow() {
        return SETTING_NOW;
    }

    public static WritePatterns getWritePatternsClass() {
        return writePatternsClass;
    }

    public static void setWritePatternsClass(WritePatterns writePatternsClass) {
        Gasket.writePatternsClass = writePatternsClass;
    }

    public static ReadHistory getReadHistoryClass() {
        return readHistoryClass;
    }

    public static void setReadHistoryClass(ReadHistory readHistoryClass) {
        Gasket.readHistoryClass = readHistoryClass;
    }

    public static ExecutorCommandos getExecutorCommandosClass() {
        return executorCommandosClass;
    }

    public static void setExecutorCommandosClass(ExecutorCommandos executorCommandosClass) {
        Gasket.executorCommandosClass = executorCommandosClass;
    }

    public static FilesAndPathCreator getFilesAndPathCreatorClass() {
        return filesAndPathCreatorClass;
    }

    public static void setFilesAndPathCreatorClass(FilesAndPathCreator filesAndPathCreatorClass) {
        Gasket.filesAndPathCreatorClass = filesAndPathCreatorClass;
    }

    public static RunAndStopProgram getRunProgramClass() {
        return runAndStopProgramClass;
    }

    public static void setRunProgramClass(RunAndStopProgram runAndStopProgramClass) {
        Gasket.runAndStopProgramClass = runAndStopProgramClass;
    }

    public static int getDateDifference() {
        return dateDifference;
    }

    public static void setDateDifference(int dateDifference) {
        Gasket.dateDifference = dateDifference;
    }

    public static View getViewThreadClass() {
        return viewThreadClass;
    }

    public static void setViewThreadClass(View viewThreadClass) {
        Gasket.viewThreadClass = viewThreadClass;
    }
}

