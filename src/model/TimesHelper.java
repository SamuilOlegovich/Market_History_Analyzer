package model;

import model.Gasket;

import java.text.DateFormat;
import java.text.ParseException;
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
        return simpleDateFormat.format(in);
    }


    // 2020-05-21 15:30:00
    public static synchronized Date getDateLong(String string) throws ParseException {
        String s = string.replace(".", "-").replace(":", "-")
                .replace(" ", "-");
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        Date date = null;
        date = dateFormat.parse(s);
        return date;
    }
}
