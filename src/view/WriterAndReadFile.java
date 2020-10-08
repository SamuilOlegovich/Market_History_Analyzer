package view;

import model.Outs;
import model.StringHelper;

import java.io.*;
import java.util.ArrayList;



public class WriterAndReadFile {
    public static void writerFile(String string, String path, boolean reWrite) {
        File file = new File(path);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, reWrite))) {
            writer.write(string);
            writer.flush();
        } catch (Exception e) {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.FILE_WRITE_ERROR)
                    + " - " + string + " === " + path);
        }
    }


    public static ArrayList<String> readFile(String path) throws Exception {
        File file = new File(path);
        ArrayList<String> arrayList = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                arrayList.add(reader.readLine());
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.FILE_READING_ERROR) + " - " + path);
            throw new Exception();
        }
        return arrayList;
    }
}
