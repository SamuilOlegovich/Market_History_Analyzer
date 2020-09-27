package view;

import model.Gasket;

public class ConsoleHelper {
    public static void writeMessage(String string) {
        Gasket.getViewThread().updateInfoView(string);
//        WriterAndReadFile.writerFile(string + "\n"
//                , Gasket.getFilesAndPathCreator().getPathLogs()
//                , true);
        System.out.println(string);
    }
}
