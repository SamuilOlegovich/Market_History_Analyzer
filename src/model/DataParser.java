package model;

import view.ConsoleHelper;
import view.StringHelper;

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
            new PatternFinder(start, end);
        } catch (Exception e) {
            ConsoleHelper.writeMessage(StringHelper.getString(Enums.WRONG_DATE_FORMAT));
            Gasket.getViewThreadClass().setPreviousColor();
        }
    }

    private Date getDate(String string) throws Exception {
        String result = string.replaceAll(":", "_").replaceAll("-", "_")
                .replaceAll("\\.", "_").replaceAll(",", "_")
                .replaceAll(" ", "_");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH_mm_dd_MM_yyyy");
        return simpleDateFormat.parse(result);
    }
}
