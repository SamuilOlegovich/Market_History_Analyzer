package model;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;

public class ComparatorHelper {
    private static final SortTheAlphabetAll sortTheAlphabetAll = new SortTheAlphabetAll();
    private static final SortTheAlphabet sortTheAlphabet = new SortTheAlphabet();
    private static final SortTheDateAll sortTheDateAll = new SortTheDateAll();
    private static final SortPrice sortPrice = new SortPrice();



    private static class SortTheAlphabet implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int result = o1.compareTo(o2);
            return Integer.compare(result, 0);
        }
    }

    private static class SortPrice implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            double result = Double.parseDouble(StringHelper.getStringData(Str.price, o2))
                    - Double.parseDouble(StringHelper.getStringData(Str.price, o1));
            return Double.compare(result, 0);
        }
    }

    // сортируем по алфавиту полную строку со всеми данными
    private static class SortTheAlphabetAll implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int result = StringHelper.getStringData(Str.dir, o1).compareTo(StringHelper.getStringData(Str.dir, o2));
            return Integer.compare(result, 0);
        }
    }

    // сортируем по дате полную строку со всеми данными
    private static class SortTheDateAll implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String s1 = StringHelper.getStringData(Str.time, o1.split(",\"" + Str.levels.toString())[0]);
            String s2 = StringHelper.getStringData(Str.time, o2.split(",\"" + Str.levels.toString())[0]);
            Date d1 = null;
            Date d2 = null;

            try {
                d1 = TimesHelper.getDateLong(s1);
                d2 = TimesHelper.getDateLong(s2);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            int result = d1.compareTo(d2);
            return Integer.compare(result, 0);
        }
    }

    public static SortTheAlphabetAll getSortTheAlphabetAll() {
        return sortTheAlphabetAll;
    }

    public static SortTheDateAll getSortTheDateAll() {
        return sortTheDateAll;
    }

    public static SortTheAlphabet getSortTheAlphabet() {
        return sortTheAlphabet;
    }

    public static SortPrice getSortPrice() {
        return sortPrice;
    }
}
