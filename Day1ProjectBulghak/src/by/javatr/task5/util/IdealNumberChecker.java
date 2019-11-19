/*
 *
 *класс содержащий методы для проверки является ли число совершенным
 *
 */

package by.javatr.task5.util;

public class IdealNumberChecker {

    public static boolean idealNumberCheck(int number) {

        return number == sumOfNumbersFinder(DividersFinder.findDividers(number));
    }

    public static int sumOfNumbersFinder(int[] numbers) {

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }

}
