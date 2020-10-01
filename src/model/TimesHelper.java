package model;

import model.Gasket;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimesHelper {
    public static synchronized String getDateTerminal() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        date.setTime(Gasket.getDateDifference() > 0
                ? date.getTime() + (1000 * 60 * 60 * Math.abs(Gasket.getDateDifference()))
                : date.getTime() - (1000 * 60 * 60 * Math.abs(Gasket.getDateDifference())));
        return dateFormat.format(date);
    }

    public static synchronized String getDateLogs() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        return dateFormat.format(date);
    }

    public static String getDataStringFormat(Date in) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH_mm_dd_MM_yyyy");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dd_MM_yyyy_HH_mm_ss");
        return simpleDateFormat.format(in);
    }
}
