package model;



public class StringHelper {

    public static synchronized String getString(Outs in) {
        return TimesHelper.getDateTerminal() + " --- " + in.toString();
    }

    public static synchronized String getString(String in) {
        return TimesHelper.getDateTerminal() + " --- " + in;
    }


    // "period": "M5","preview": "1","price": "9075.5","value": "-635002","type": "DELTA_BID_HL","avg": "0"
    public static synchronized String getStringData(Str key, String in) {
        String[] strings = in.replaceAll("\\{", "")
                .replaceAll("\\[", "")
                .replaceAll("}", "")
                .replaceAll("]", "")
                .replaceAll(" ", "")
                .split("\",\"");
        for (String s : strings) {
            if (s.contains(key.toString())) {
                if (key == Str.time) {
                    StringBuilder stringBuilder =
                            new StringBuilder(s.replaceAll(key.toString() + "\":\"", "")
                            .replaceAll("\"","")
                            .replaceAll(",", ""));
                    stringBuilder.insert(10, " ");
                    return stringBuilder.toString();
                }
                return s.replaceAll(key.toString() + "\":\"", "")
                        .replaceAll("\"","")
                        .replaceAll(",", "");
            }
        }
        return null;
    }
}
