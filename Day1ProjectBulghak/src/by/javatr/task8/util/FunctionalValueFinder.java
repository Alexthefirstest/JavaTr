/*
 *
 * получение значения функции
 *
 */

package by.javatr.task8.util;

public class FunctionalValueFinder {

    public static double findValue(double x) {

        if (x >= 3) {
            return -x * x + 3 * x + 9;
        } else {
            return 1 / (Math.pow(x, 3) - 6);
        }

    }

}
