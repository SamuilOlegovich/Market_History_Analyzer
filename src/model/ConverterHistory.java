package model;

import com.sun.source.tree.Tree;
import view.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;





public class ConverterHistory extends Thread {
    private ArrayList<String> historyJSON;
    private ArrayList<String> history;

    public ConverterHistory(ArrayList<String> historyJSON) {
        this.historyJSON = new ArrayList<>(historyJSON);
        this.history = new ArrayList<>();
        start();
    }



    @Override
    public void run() {
        convertHistory();
        removeDuplicateCandles();
//        show();
        new History(history);
        historyJSON.clear();
        history.clear();
    }

    private void show() {
            ConsoleHelper.writeMessage(history.size()+ "====");
        for (String s : history) {
            ConsoleHelper.writeMessage(s);
        }
    }



    // приводим в нужный нам формат историю
    private void convertHistory() {
        ConsoleHelper.writeMessage(StringHelper.getString(Outs.CONVERTING_HISTORY));
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder builder = new StringBuilder();

//        for (String s : historyJSON) {
        for (int a = 0; a < historyJSON.size(); a++) {
//            stringBuilder.append(s.contains(Str.time.toString())
            stringBuilder.append(historyJSON.get(a).contains(Str.time.toString())
//                    ? s.replaceAll(" ", "")
                    ? historyJSON.get(a).replaceAll(" ", "")
//                    : s.replaceAll(" ", "")
                    : historyJSON.get(a).replaceAll(" ", "")
                    .replaceAll(":", ": "));
//            if (s.contains(Str.time.toString())) {
            if (historyJSON.get(a).contains(Str.time.toString())) {
                builder.delete(0, builder.length());
                stringBuilder.insert(stringBuilder.length() - 10, " ");
                builder.append(stringBuilder.substring(1, stringBuilder.length()));
            }
            if (stringBuilder.toString().endsWith("levels\": [{")
                    || stringBuilder.toString().endsWith("},{")) {
                stringBuilder.append(builder.toString());
            }
            if (stringBuilder.toString().endsWith("]},")) {
                history.add(stringBuilder
                        .substring(0, stringBuilder.length() - 1));
                stringBuilder.delete(0, stringBuilder.length());
            }

            if (a == (historyJSON.size() / 100) * 10) ConsoleHelper.writeMessage(StringHelper.getString("10%"));
            else if (a == (historyJSON.size() / 100) * 20) ConsoleHelper.writeMessage(StringHelper.getString("20%"));
            else if (a == (historyJSON.size() / 100) * 30) ConsoleHelper.writeMessage(StringHelper.getString("30%"));
            else if (a == (historyJSON.size() / 100) * 40) ConsoleHelper.writeMessage(StringHelper.getString("40%"));
            else if (a == (historyJSON.size() / 100) * 50) ConsoleHelper.writeMessage(StringHelper.getString("50%"));
            else if (a == (historyJSON.size() / 100) * 60) ConsoleHelper.writeMessage(StringHelper.getString("60%"));
            else if (a == (historyJSON.size() / 100) * 70) ConsoleHelper.writeMessage(StringHelper.getString("70%"));
            else if (a == (historyJSON.size() / 100) * 80) ConsoleHelper.writeMessage(StringHelper.getString("80%"));
            else if (a == (historyJSON.size() / 100) * 90) ConsoleHelper.writeMessage(StringHelper.getString("90%"));
            else if (a == (historyJSON.size() - 5)) ConsoleHelper.writeMessage(StringHelper.getString("100%"));
        }

        ConsoleHelper.writeMessage(StringHelper.getString(Outs.SORTING_HISTORY));
        history.sort(ComparatorHelper.getSortTheDateAll());
    }



    // удаляем повторяющиеся свечи
    private void removeDuplicateCandles() {
        /////////
        ConsoleHelper.writeMessage(history.size() + "-");
        /////////
        ConsoleHelper.writeMessage(StringHelper.getString(Outs.REMOVING_EXTRA_FROM_HISTORY));
        TreeSet<Integer> treeSet = new TreeSet<>();
        int index = 60 * 48;

        for (int i = index; i >= 0; i--) {
            history.remove(history.size() - 1);
            history.remove(0);
        }

        /////////
        ConsoleHelper.writeMessage(history.size() + "--");
        /////////

        for (int a = 0; a < history.size() - 2; a++) {
            String s = StringHelper.getStringData(Str.time, history.get(a));

            for (int i = a + 1; i < history.size(); i++) {
                if (s.equals(StringHelper.getStringData(Str.time, history.get(i)))) {
                    treeSet.add(a);
                    treeSet.add(i);
                    break;
                }
            }

            if (a == (history.size() / 100) * 10) ConsoleHelper.writeMessage(StringHelper.getString("10%"));
            else if (a == (history.size() / 100) * 20) ConsoleHelper.writeMessage(StringHelper.getString("20%"));
            else if (a == (history.size() / 100) * 30) ConsoleHelper.writeMessage(StringHelper.getString("30%"));
            else if (a == (history.size() / 100) * 40) ConsoleHelper.writeMessage(StringHelper.getString("40%"));
            else if (a == (history.size() / 100) * 50) ConsoleHelper.writeMessage(StringHelper.getString("50%"));
            else if (a == (history.size() / 100) * 60) ConsoleHelper.writeMessage(StringHelper.getString("60%"));
            else if (a == (history.size() / 100) * 70) ConsoleHelper.writeMessage(StringHelper.getString("70%"));
            else if (a == (history.size() / 100) * 80) ConsoleHelper.writeMessage(StringHelper.getString("80%"));
            else if (a == (history.size() / 100) * 90) ConsoleHelper.writeMessage(StringHelper.getString("90%"));
            else if (a == (history.size() - 5)) ConsoleHelper.writeMessage(StringHelper.getString("100%\n"));
        }

        ArrayList<Integer> arrayList = new ArrayList<>(treeSet);
        Collections.reverse(arrayList);
        treeSet.clear();

        for (Integer ind : arrayList) {
            history.remove(ind);
        }

        /////////
        ConsoleHelper.writeMessage(history.size() + "---");
        /////////
    }
}
