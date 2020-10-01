package model;

import view.ConsoleHelper;

import java.text.SimpleDateFormat;
import java.util.Date;




public class DataParser extends Thread {
    private String startDate;
    private String endDate;

    public DataParser(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.start();
    }

    @Override
    public void run() {
        try {
            Date start = getDate(startDate);
            Date end = getDate(endDate);
            Gasket.setStartDate(TimesHelper.getDataStringFormat(start));
            Gasket.setEndDate(TimesHelper.getDataStringFormat(end));
            new PatternFinder(start, end);
        } catch (Exception e) {
            ConsoleHelper.writeMessage(StringHelper.getString(Outs.WRONG_DATE_FORMAT));
            Gasket.getViewThreadClass().setPreviousColor();
        }
    }

    private Date getDate(String string) throws Exception {
        String result = string.replaceAll(":", "_").replaceAll("-", "_")
                .replaceAll("\\.", "_").replaceAll(",", "_")
                .replaceAll(" ", "_");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH_mm_dd_MM_yyyy");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dd_MM_yyyy_HH_mm_ss");
        return simpleDateFormat.parse(result);
    }
}
