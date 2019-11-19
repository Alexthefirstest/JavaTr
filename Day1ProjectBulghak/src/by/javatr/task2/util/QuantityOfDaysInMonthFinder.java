/*
 *
 *класс содержит метод находящий количество дней в указанном месяце указанного года
 *
 */

package by.javatr.task2.util;

public class QuantityOfDaysInMonthFinder {

    public static int FindQuantityOfDaysInMonth(int year, int month) throws WrongYearException, WrongMonthException {

        if (year < 1) {
            throw new WrongYearException("Incorrect year: " + year);
        }

        if (month < 1 || month > 12) {
            throw new WrongMonthException("Incorrect month: " + month);
        }

        if (month == 2) {
            return LeapYearChecker.isLeapYear(year) ? 29 : 28;
        }

        if (month <= 7) {
            return month % 2 == 0 ? 30 : 31;
        }

        return month % 2 == 0 ? 31 : 30;
    }

}
