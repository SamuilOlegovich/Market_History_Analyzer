package model;

import controller.RunAndStopProgram;
import view.View;




public class Gasket {
    private static RunAndStopProgram runAndStopProgramClass;
    private static View viewThread;

    private static int dateDifference = 0;





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

    public static View getViewThread() {
        return viewThread;
    }

    public static void setViewThread(View viewThread) {
        Gasket.viewThread = viewThread;
    }
}

