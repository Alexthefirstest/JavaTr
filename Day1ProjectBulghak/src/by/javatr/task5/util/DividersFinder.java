/*
 *
 *класс содержащий статические методы для нахождения делителей числа
 *
 */

package by.javatr.task5.util;

import java.util.Arrays;

public class DividersFinder {

    public static int[] findDividers(int number) {

        int[] dividers = new int[0];

        for (int i = 1; i < number; i++) {

            if (isDivider(number, i)) {
                dividers = Arrays.copyOf(dividers, dividers.length + 1);
                dividers[dividers.length - 1] = i;
            }

        }

        return dividers;

    }

    public static boolean isDivider(int number, int divide) {

        return number % divide == 0;
    }

}
