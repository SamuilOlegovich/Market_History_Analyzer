package model;

import view.ConsoleHelper;
import view.StringHelper;
import view.WriterAndReadFile;

import java.util.ArrayList;

public class WritePatterns extends Thread {
    private ArrayList<String> patternList;
    private String path;



    public WritePatterns() {
        this.path = Gasket.getFilesAndPathCreatorClass().getPathSavedPatterns();
        this.patternList = new ArrayList<>();
        Gasket.setWritePatternsClass(this);
    }




    public void writePattern() {
        if (patternList.size() > 0) {
            try {
                WriterAndReadFile.writerFile(getStringWrite(patternList), path, true);
            } catch (Exception ex) {
                ConsoleHelper.writeMessage(StringHelper.getString(Outs.SAVED_PATTERNS_FILE_WRITE_ERROR));
                Gasket.getViewThreadClass().setPreviousColor();
            }
        } else {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.NO_PATTERN_TO_SAVE));
        }
        Gasket.getViewThreadClass().setPreviousColor();
    }



    private String getStringWrite(ArrayList<String> in) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : in) {
            stringBuilder.append(s).append("\n");
        }
        stringBuilder.append(Str.NEXT.toString()).append("\n");
        return stringBuilder.toString();
    }



    public ArrayList<String> getPatternList() {
        ArrayList<String> strings = new ArrayList<>(patternList);
        strings.remove(0);
        return strings;
    }

    public void setPatternList(ArrayList<String> patternList) {
        if (patternList.size() > 0) {
            patternList.clear();
        }
        ArrayList<String> strings = new ArrayList<>(patternList);
        strings.add(0, Gasket.getStartDate()
                + " => " + Gasket.getEndDate()
                + " => " + Gasket.getSymbol());
        this.patternList = strings;
    }

    public int getPatternSize() {
        return patternList.size() - 1;
    }
}
