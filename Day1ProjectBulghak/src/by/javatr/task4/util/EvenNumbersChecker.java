/*
 *
 *класс содержащий методы:
 * - для определения является ли число четным
 * -для определения являются ли 2 из 4 чисел четными
 *
 */

package by.javatr.task4.util;

public class EvenNumbersChecker {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isTwoOfFourNumbersEvenCheck(int[] numbers) {

        boolean previousEven = false;

        for (int i = 0; i < 4; i++) {

            if (isEven(numbers[i]) == true) {

                if (previousEven) {
                    return true;
                } else {
                    previousEven = true;
                }

            }
        }

        return false;
    }
}
