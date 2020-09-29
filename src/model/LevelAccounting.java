package model;

import java.util.ArrayList;

// тут мы смотрим и составляем список какие уровни нам надо учитывать, а какие нет
// а так же формируем главные уровни
public class LevelAccounting {
    private ArrayList<String> accountingLevelsList; // уровни которые учитывать
    private ArrayList<String> mainLevelsList; // главные уровни

    public LevelAccounting() {
        Gasket.setLevelAccountingClass(this);
        this.accountingLevelsList = new ArrayList<>();
        this.mainLevelsList = new ArrayList<>();
        fillAccountingLevelsList();
        fillMainLevelsList();
    }




    private void fillAccountingLevelsList() {

    }

    private void fillMainLevelsList() {

    }

    public ArrayList<String> getAccountingLevelsList() {
        return accountingLevelsList;
    }

    public ArrayList<String> getMainLevelsList() {
        return mainLevelsList;
    }
}
