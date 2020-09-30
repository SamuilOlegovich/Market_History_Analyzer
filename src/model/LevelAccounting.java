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
        if (Gasket.getAsk() == 1 || Gasket.getAsk() == 2) {
            accountingLevelsList.add(Levels.Ask.toString());
        }
        if (Gasket.getAskHL() == 1 || Gasket.getAskHL() == 2) {
            accountingLevelsList.add(Levels.AskHL.toString());
        }
        if (Gasket.getAskHLSmall() == 1 || Gasket.getAskHLSmall() == 2) {
            accountingLevelsList.add(Levels.AskHLSmall.toString());
        }
        if (Gasket.getAskSmall() == 1 || Gasket.getAskSmall() == 2) {
            accountingLevelsList.add(Levels.AskSmall.toString());
        }
        if (Gasket.getBid() == 1 || Gasket.getBid() == 2) {
            accountingLevelsList.add(Levels.Bid.toString());
        }
        if (Gasket.getBidHL() == 1 || Gasket.getBidHL() == 2) {
            accountingLevelsList.add(Levels.BidHL.toString());
        }
        if (Gasket.getBidHLSmall() == 1 || Gasket.getBidHLSmall() == 2) {
            accountingLevelsList.add(Levels.BidHLSmall.toString());
        }
        if (Gasket.getBidSmall() == 1 || Gasket.getBidSmall() == 2) {
            accountingLevelsList.add(Levels.BidSmall.toString());
        }
        if (Gasket.getDeltaAsk() == 1 || Gasket.getDeltaAsk() == 2) {
            accountingLevelsList.add(Levels.DeltaAsk.toString());
        }
        if (Gasket.getDeltaAskHL() == 1 || Gasket.getDeltaAskHL() == 2) {
            accountingLevelsList.add(Levels.DeltaAskHL.toString());
        }
        if (Gasket.getDeltaAskHLSmall() == 1 || Gasket.getDeltaAskHLSmall() == 2) {
            accountingLevelsList.add(Levels.DeltaAskHLSmall.toString());
        }
        if (Gasket.getDeltaAskSmall() == 1 || Gasket.getDeltaAskSmall() == 2) {
            accountingLevelsList.add(Levels.DeltaAskSmall.toString());
        }
        if (Gasket.getDeltaBid() == 1 || Gasket.getDeltaBid() == 2) {
            accountingLevelsList.add(Levels.DeltaBid.toString());
        }
        if (Gasket.getDeltaBidHL() == 1 || Gasket.getDeltaBidHL() == 2) {
            accountingLevelsList.add(Levels.DeltaBidHL.toString());
        }
        if (Gasket.getDeltaBidHLSmall() == 1 || Gasket.getDeltaBidHLSmall() == 2) {
            accountingLevelsList.add(Levels.DeltaBidHLSmall.toString());
        }
        if (Gasket.getDeltaBidSmall() == 1 || Gasket.getDeltaBidSmall() == 2) {
            accountingLevelsList.add(Levels.DeltaBidSmall.toString());
        }
        if (Gasket.getDeltaZSMinMinus() == 1 || Gasket.getDeltaZSMinMinus() == 2) {
            accountingLevelsList.add(Levels.DeltaZSMinMinus.toString());
        }
        if (Gasket.getDeltaZSMinPlus() == 1 || Gasket.getDeltaZSMinPlus() == 2) {
            accountingLevelsList.add(Levels.DeltaZSMinPlus.toString());
        }
        if (Gasket.getDeltaZSMinus() == 1 || Gasket.getDeltaZSMinus() == 2) {
            accountingLevelsList.add(Levels.DeltaZSMinus.toString());
        }
        if (Gasket.getDeltaZSPlus() == 1 || Gasket.getDeltaZSPlus() == 2) {
            accountingLevelsList.add(Levels.DeltaZSPlus.toString());
        }
        if (Gasket.getOIZSMinMinus() == 1 || Gasket.getOIZSMinMinus() == 2) {
            accountingLevelsList.add(Levels.OIZSMinMinus.toString());
        }
        if (Gasket.getOIZSMinPlus() == 1 || Gasket.getOIZSMinPlus() == 2) {
            accountingLevelsList.add(Levels.OIZSMinPlus.toString());
        }
        if (Gasket.getOIZSMinus() == 1 || Gasket.getOIZSMinus() == 2) {
            accountingLevelsList.add(Levels.OIZSMinus.toString());
        }
        if (Gasket.getOIZSPlus() == 1 || Gasket.getOIZSPlus() == 2) {
            accountingLevelsList.add(Levels.OIZSPlus.toString());
        }
        if (Gasket.getOpenPosAskMinus() == 1 || Gasket.getOpenPosAskMinus() == 2) {
            accountingLevelsList.add(Levels.OpenPosAskMinus.toString());
        }
        if (Gasket.getOpenPosAskMinusSmall() == 1 || Gasket.getOpenPosAskMinusSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosAskMinusSmall.toString());
        }
        if (Gasket.getOpenPosAskPlus() == 1 || Gasket.getOpenPosAskPlus() == 2) {
            accountingLevelsList.add(Levels.OpenPosAskPlus.toString());
        }
        if (Gasket.getOpenPosAskPlusSmall() == 1 || Gasket.getOpenPosAskPlusSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosAskPlusSmall.toString());
        }
        if (Gasket.getOpenPosBidMinus() == 1 || Gasket.getOpenPosBidMinus() == 2) {
            accountingLevelsList.add(Levels.OpenPosBidMinus.toString());
        }
        if (Gasket.getOpenPosBidMinusSmall() == 1 || Gasket.getOpenPosBidMinusSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosBidMinusSmall.toString());
        }
        if (Gasket.getOpenPosBidPlus() == 1 || Gasket.getOpenPosBidPlus() == 2) {
            accountingLevelsList.add(Levels.OpenPosBidPlus.toString());
        }
        if (Gasket.getOpenPosBidPlusSmall() == 1 || Gasket.getOpenPosBidPlusSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosBidPlusSmall.toString());
        }
        if (Gasket.getOpenPosMinus() == 1 || Gasket.getOpenPosMinus() == 2) {
            accountingLevelsList.add(Levels.OpenPosMinus.toString());
        }
        if (Gasket.getOpenPosMinusHL() == 1 || Gasket.getOpenPosMinusHL() == 2) {
            accountingLevelsList.add(Levels.OpenPosMinusHL.toString());
        }
        if (Gasket.getOpenPosMinusHLSmall() == 1 || Gasket.getOpenPosMinusHLSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosMinusHLSmall.toString());
        }
        if (Gasket.getOpenPosMinusSmall() == 1 || Gasket.getOpenPosMinusSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosMinusSmall.toString());
        }
        if (Gasket.getOpenPosPlus() == 1 || Gasket.getOpenPosPlus() == 2) {
            accountingLevelsList.add(Levels.OpenPosPlus.toString());
        }
        if (Gasket.getOpenPosPlusHL() == 1 || Gasket.getOpenPosPlusHL() == 2) {
            accountingLevelsList.add(Levels.OpenPosPlusHL.toString());
        }
        if (Gasket.getOpenPosPlusHLSmall() == 1 || Gasket.getOpenPosPlusHLSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosPlusHLSmall.toString());
        }
        if (Gasket.getOpenPosPlusSmall() == 1 || Gasket.getOpenPosPlusSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosPlusSmall.toString());
        }
        if (Gasket.getVolume() == 1 || Gasket.getVolume() == 2) {
            accountingLevelsList.add(Levels.Volume.toString());
        }
        if (Gasket.getVolumeHL() == 1 || Gasket.getVolumeHL() == 2) {
            accountingLevelsList.add(Levels.VolumeHL.toString());
        }
        if (Gasket.getVolumeHLSmall() == 1 || Gasket.getVolumeHLSmall() == 2) {
            accountingLevelsList.add(Levels.VolumeHLSmall.toString());
        }
        if (Gasket.getVolumeSmall() == 1 || Gasket.getVolumeSmall() == 2) {
            accountingLevelsList.add(Levels.VolumeSmall.toString());
        }
    }

    private void fillMainLevelsList() {
        if (Gasket.getAsk() == 2) {
            accountingLevelsList.add(Levels.Ask.toString());
        }
        if (Gasket.getAskHL() == 2) {
            accountingLevelsList.add(Levels.AskHL.toString());
        }
        if (Gasket.getAskHLSmall() == 2) {
            accountingLevelsList.add(Levels.AskHLSmall.toString());
        }
        if (Gasket.getAskSmall() == 2) {
            accountingLevelsList.add(Levels.AskSmall.toString());
        }
        if (Gasket.getBid() == 2) {
            accountingLevelsList.add(Levels.Bid.toString());
        }
        if (Gasket.getBidHL() == 2) {
            accountingLevelsList.add(Levels.BidHL.toString());
        }
        if (Gasket.getBidHLSmall() == 2) {
            accountingLevelsList.add(Levels.BidHLSmall.toString());
        }
        if (Gasket.getBidSmall() == 2) {
            accountingLevelsList.add(Levels.BidSmall.toString());
        }
        if (Gasket.getDeltaAsk() == 2) {
            accountingLevelsList.add(Levels.DeltaAsk.toString());
        }
        if (Gasket.getDeltaAskHL() == 2) {
            accountingLevelsList.add(Levels.DeltaAskHL.toString());
        }
        if (Gasket.getDeltaAskHLSmall() == 2) {
            accountingLevelsList.add(Levels.DeltaAskHLSmall.toString());
        }
        if (Gasket.getDeltaAskSmall() == 2) {
            accountingLevelsList.add(Levels.DeltaAskSmall.toString());
        }
        if (Gasket.getDeltaBid() == 2) {
            accountingLevelsList.add(Levels.DeltaBid.toString());
        }
        if (Gasket.getDeltaBidHL() == 2) {
            accountingLevelsList.add(Levels.DeltaBidHL.toString());
        }
        if (Gasket.getDeltaBidHLSmall() == 2) {
            accountingLevelsList.add(Levels.DeltaBidHLSmall.toString());
        }
        if (Gasket.getDeltaBidSmall() == 2) {
            accountingLevelsList.add(Levels.DeltaBidSmall.toString());
        }
        if (Gasket.getDeltaZSMinMinus() == 2) {
            accountingLevelsList.add(Levels.DeltaZSMinMinus.toString());
        }
        if (Gasket.getDeltaZSMinPlus() == 2) {
            accountingLevelsList.add(Levels.DeltaZSMinPlus.toString());
        }
        if (Gasket.getDeltaZSMinus() == 2) {
            accountingLevelsList.add(Levels.DeltaZSMinus.toString());
        }
        if (Gasket.getDeltaZSPlus() == 2) {
            accountingLevelsList.add(Levels.DeltaZSPlus.toString());
        }
        if (Gasket.getOIZSMinMinus() == 2) {
            accountingLevelsList.add(Levels.OIZSMinMinus.toString());
        }
        if (Gasket.getOIZSMinPlus() == 2) {
            accountingLevelsList.add(Levels.OIZSMinPlus.toString());
        }
        if (Gasket.getOIZSMinus() == 2) {
            accountingLevelsList.add(Levels.OIZSMinus.toString());
        }
        if (Gasket.getOIZSPlus() == 2) {
            accountingLevelsList.add(Levels.OIZSPlus.toString());
        }
        if (Gasket.getOpenPosAskMinus() == 2) {
            accountingLevelsList.add(Levels.OpenPosAskMinus.toString());
        }
        if (Gasket.getOpenPosAskMinusSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosAskMinusSmall.toString());
        }
        if (Gasket.getOpenPosAskPlus() == 2) {
            accountingLevelsList.add(Levels.OpenPosAskPlus.toString());
        }
        if (Gasket.getOpenPosAskPlusSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosAskPlusSmall.toString());
        }
        if (Gasket.getOpenPosBidMinus() == 2) {
            accountingLevelsList.add(Levels.OpenPosBidMinus.toString());
        }
        if (Gasket.getOpenPosBidMinusSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosBidMinusSmall.toString());
        }
        if (Gasket.getOpenPosBidPlus() == 2) {
            accountingLevelsList.add(Levels.OpenPosBidPlus.toString());
        }
        if (Gasket.getOpenPosBidPlusSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosBidPlusSmall.toString());
        }
        if (Gasket.getOpenPosMinus() == 2) {
            accountingLevelsList.add(Levels.OpenPosMinus.toString());
        }
        if (Gasket.getOpenPosMinusHL() == 2) {
            accountingLevelsList.add(Levels.OpenPosMinusHL.toString());
        }
        if (Gasket.getOpenPosMinusHLSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosMinusHLSmall.toString());
        }
        if (Gasket.getOpenPosMinusSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosMinusSmall.toString());
        }
        if (Gasket.getOpenPosPlus() == 2) {
            accountingLevelsList.add(Levels.OpenPosPlus.toString());
        }
        if (Gasket.getOpenPosPlusHL() == 2) {
            accountingLevelsList.add(Levels.OpenPosPlusHL.toString());
        }
        if (Gasket.getOpenPosPlusHLSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosPlusHLSmall.toString());
        }
        if (Gasket.getOpenPosPlusSmall() == 2) {
            accountingLevelsList.add(Levels.OpenPosPlusSmall.toString());
        }
        if (Gasket.getVolume() == 2) {
            accountingLevelsList.add(Levels.Volume.toString());
        }
        if (Gasket.getVolumeHL() == 2) {
            accountingLevelsList.add(Levels.VolumeHL.toString());
        }
        if (Gasket.getVolumeHLSmall() == 2) {
            accountingLevelsList.add(Levels.VolumeHLSmall.toString());
        }
        if (Gasket.getVolumeSmall() == 2) {
            accountingLevelsList.add(Levels.VolumeSmall.toString());
        }
    }

    public ArrayList<String> getAccountingLevelsList() {
        return accountingLevelsList;
    }

    public ArrayList<String> getMainLevelsList() {
        return mainLevelsList;
    }
}
