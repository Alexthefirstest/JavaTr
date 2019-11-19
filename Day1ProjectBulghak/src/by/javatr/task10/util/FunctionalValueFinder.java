/*
 *
 *класс для нахождения значения функции на отрезке
 *
 */

package by.javatr.task10.util;

import java.util.Arrays;

public class FunctionalValueFinder {

    public static double[][] findFuntionalValueInInterval(double startPoint, double finishPoint, double step)
            throws CoordinatesException {

        if (startPoint > finishPoint) {
            throw new CoordinatesException("wrong coordinates");
        }

        double[][] values = new double[0][];

        for (double i = startPoint; i <= finishPoint; i += step) {
            values = Arrays.copyOf(values, values.length + 1);
            values[values.length - 1] = new double[]{i, findFunctionalValue(i)};
        }

        return values;
    }

    public static double findFunctionalValue(double x) {
        return Math.tan(x);
    }

}
