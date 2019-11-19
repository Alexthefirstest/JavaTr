/*
 *
 *класс содержит метод, возвращающий квадрат последней цифру из числа
 *
 */

package by.javatr.task1.util;

public class SquareOfLastNumberDigitFinder {

    public static int findSquareOfLastNumberDigit(double number) {

        int lastDigitOfNumber = LastDigitOfNumberFinder.findLastDigitOfNumber(number);
        int squareOfLastDigit = SquareOfNumberFinder.getSquareOfNumber(lastDigitOfNumber);

        return LastDigitOfNumberFinder.findLastDigitOfNumber(squareOfLastDigit);
    }

}
