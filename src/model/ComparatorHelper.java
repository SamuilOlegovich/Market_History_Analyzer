package model;

import java.util.Comparator;

public class ComparatorHelper {
    private static SortTheAlphabet sortTheAlphabet = new SortTheAlphabet();

    private static class SortTheAlphabet implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int result = o1.compareTo(o2);
            return Integer.compare(result, 0);
        }
    }

    public static SortTheAlphabet getSortTheAlphabet() {
        return sortTheAlphabet;
    }
}
