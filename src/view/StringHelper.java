package view;

import model.Enums;

public class StringHelper {
    public static synchronized String getString(Enums in) {
        return DatesTimes.getDateTerminal() + " --- " + in.toString();
    }
}
