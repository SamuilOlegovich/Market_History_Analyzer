package view;

import model.DatesTimes;
import model.Outs;

public class StringHelper {
    public static synchronized String getString(Outs in) {
        return DatesTimes.getDateTerminal() + " --- " + in.toString();
    }
}
