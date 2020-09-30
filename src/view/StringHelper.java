package view;

import model.DatesTimes;
import model.Outs;
import model.Str;




public class StringHelper {

    public static synchronized String getString(Outs in) {
        return DatesTimes.getDateTerminal() + " --- " + in.toString();
    }

    public static synchronized String getString(String in) {
        return DatesTimes.getDateTerminal() + " --- " + in;
    }


    // "period": "M5","preview": "1","price": "9075.5","value": "-635002","type": "DELTA_BID_HL","avg": "0"
    public static synchronized String getStringData(Str key, String in) {
        String[] strings = in.replaceAll("\"", "")
                .replaceAll("\\{", "")
                .replaceAll("\\[", "")
                .replaceAll("}", "")
                .replaceAll("]", "")
                .replaceAll(" ", "")
                .split(",");
        String out = null;
        for (String s : strings) {
            if (s.startsWith(key.toString())) {
                String[] ss = s.split(":");
                return ss[1];
            }
        }
        return null;
    }
}
