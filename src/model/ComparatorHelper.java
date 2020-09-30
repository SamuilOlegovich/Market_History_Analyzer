package model;

import view.StringHelper;

import java.util.Comparator;

public class ComparatorHelper {
    private static SortTheAlphabet sortTheAlphabet = new SortTheAlphabet();
    private static SortPrice sortPrice = new SortPrice();

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

    public static SortTheAlphabet getSortTheAlphabet() {
        return sortTheAlphabet;
    }

    public static SortPrice getSortPrice() {
        return sortPrice;
    }
}
