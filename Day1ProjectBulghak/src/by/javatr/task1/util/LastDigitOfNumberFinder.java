/*
 *
 *класс содержит метод, возвращающий последнюю цифру из числа
 * если число дробное - нули после запятой не учитываются
 *
 */

package by.javatr.task1.util;

public class LastDigitOfNumberFinder {

    public static int findLastDigitOfNumber(double number) {

        String numberToString = "" + number;
        int lastDigit;
        boolean isLastZero = ("" + numberToString.charAt(numberToString.length() - 1)).equals("0");

        numberToString = numberToString.replace(".", "");
        lastDigit = isLastZero ? Integer.parseInt("" + numberToString.charAt(numberToString.length() - 2))
                : Integer.parseInt("" + numberToString.charAt(numberToString.length() - 1));

        return lastDigit;
    }

}