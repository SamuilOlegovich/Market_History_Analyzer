package model;

import view.ConsoleHelper;

import java.util.ArrayList;

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
        removeStrings();
        convertHistory();
        new History(history);
        historyJSON.clear();
        history.clear();
    }


    // удаляем ненужные строки
    private void removeStrings() {
        historyJSON.remove(historyJSON.size() - 1);
        historyJSON.remove(historyJSON.size() - 1);
        historyJSON.remove(0);
        historyJSON.remove(0);
    }


    // приводим в нужный нам формат историю
    private void convertHistory() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder builder = new StringBuilder();

        for (String s : historyJSON) {
            stringBuilder.append(s.contains(Str.time.toString())
                    ? s.replaceAll(" ", "")
                    : s.replaceAll(" ", "")
                    .replaceAll(":", ": "));
            if (s.contains(Str.time.toString())) {
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
        }
//        for (int i = 0; i < 30; i ++) {
//            ConsoleHelper.writeMessage(history.get(i));
//        }
    }
}
