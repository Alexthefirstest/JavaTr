package by.javaTr.financeAccounting.controller.command.impl.supputringClasses;

import java.util.Calendar;
import java.util.Date;

public class DateFromString {
    private DateFromString() {
    }



    public static Date getDateFromString(String dateStr) {

        Date date;

        try {


            if ( dateStr.equals("0")) {
                date = new Date();
            } else {

                String[] dateStrArr = dateStr.split("\\.");


                if (dateStrArr.length < 3) {
                    return null;
                }


                Calendar calendar = Calendar.getInstance();

                calendar.set(Integer.parseInt(dateStrArr[2]), (Integer.parseInt(dateStrArr[1]) - 1), Integer.parseInt(dateStrArr[0]));
                date = calendar.getTime();
            }
            return date;

        } catch (NumberFormatException ex) {

            return null;
        }
    }

}
