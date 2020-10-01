package model;

import java.util.ArrayList;

public class Pattern {
    private ArrayList<String> patternList;


    public Pattern() {
        this.patternList = new ArrayList<>();
        Gasket.setPatternClass(this);
    }



    public ArrayList<String> getPatternList() {
        ArrayList<String> strings = new ArrayList<>(patternList);
        strings.remove(0);
        return strings;
    }

    public ArrayList<String> getFullPatternList() {
        ArrayList<String> strings = new ArrayList<>(patternList);
        return strings;
    }

    public void setPatternList(ArrayList<String> in) {
        if (patternList.size() > 0) {
            patternList.clear();
        }
        patternList.add(Gasket.getSymbol()
                + " => " + Gasket.getStartDate()
                + " => " + Gasket.getEndDate());
        patternList.addAll(in);
    }

    public int getPatternSize() {
        return patternList.size() - 1;
    }
}
