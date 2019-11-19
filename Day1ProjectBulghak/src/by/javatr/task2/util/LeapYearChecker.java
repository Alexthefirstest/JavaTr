/*
 *
 *класс содержит единственный публичный метод,
 * который проверяет, является ли переданный год высокосным
 *
 */

package by.javatr.task2.util;

public class LeapYearChecker {

    public static boolean isLeapYear(int year) throws WrongYearException {

        if (year < 1) {
            throw new WrongYearException("Incorrect year: " + year);
        }

        if (isNumberMultipleAnotherNumber(year, 400)) {
            return true;
        }

        if (isNumberMultipleAnotherNumber(year, 100)) {
            return false;
        }

        if (isNumberMultipleAnotherNumber(year, 4)) {
            return true;
        }

        return false;
    }

    private static boolean isNumberMultipleAnotherNumber(int number, int anotherNumber) {

        return number % anotherNumber == 0;
    }

}
