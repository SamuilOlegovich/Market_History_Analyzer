package model;

import view.ConsoleHelper;
import view.WriterAndReadFile;

import java.util.ArrayList;

public class WritePatterns {
    private String path;



    public WritePatterns() {
        this.path = Gasket.getFilesAndPathCreatorClass().getPathSavedPatterns();
        Gasket.setWritePatternsClass(this);
    }


    public void writePattern() {
        if (Gasket.getPatternClass().getPatternSize() > 0) {
            try {
                WriterAndReadFile.writerFile(getStringWrite(Gasket.getPatternClass()
                        .getFullPatternList()), path, true);
            } catch (Exception ex) {
                ConsoleHelper.writeMessage(StringHelper.getString(Outs.SAVED_PATTERNS_FILE_WRITE_ERROR));
            }
        } else {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.NO_PATTERN_TO_SAVE));
        }
        ConsoleHelper.writeMessage(StringHelper.getString(Outs.PATTERN_SUCCESSFULLY_SAVED));
        Gasket.getViewThreadClass().setPreviousColor();
    }


     private String getStringWrite(ArrayList<String> in) {
        ArrayList<String> mainLevel = Gasket.getLevelAccountingClass().getMainLevelsList();
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : in) {
            if (mainLevel.contains(StringHelper.getStringData(Str.type, s))) {
                stringBuilder.append("MAIN-").append(s).append("\n");
            } else {
                stringBuilder.append("SIMPLE-").append(s).append("\n");
            }
        }
        stringBuilder.append(Str.NEXT.toString()).append("\n");
        return stringBuilder.toString();
    }
}
