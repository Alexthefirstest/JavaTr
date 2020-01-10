package by.javatr.bulhak.task1.util.validation;

import by.javatr.bulhak.task1.util.entity.Array;
import by.javatr.bulhak.task1.util.exceptions.*;

public final class MaxOrMinElementFinder {

    private MaxOrMinElementFinder() {

    }

    public static int maxElementFinder(Array array) throws WrongLinkException {

        if (array == null) {
            throw new WrongLinkException("массив не найден");
        }

        int max = -999999999;

        try {

            for (int i = 0; i < array.getLength(); i++) {
                if (max < array.getElement(i)) {
                    max = array.getElement(i);
                }
            }

        } catch (WrongPosition ex) {

        }

        return max;
    }

    public static int minElementFinder(Array array) throws WrongLinkException {

        if (array == null) {
            throw new WrongLinkException("массив не найден");
        }

        int min = +999999999;

        try {

            for (int i = 0; i < array.getLength(); i++) {

                if (min > array.getElement(i)) {
                    min = array.getElement(i);
                }

            }

        } catch (WrongPosition ex) {
        }

        return min;
    }
}
