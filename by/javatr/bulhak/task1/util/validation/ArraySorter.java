package by.javatr.bulhak.task1.util.validation;

import by.javatr.bulhak.task1.util.entity.Array;
import by.javatr.bulhak.task1.util.exceptions.WrongLinkException;

public final class ArraySorter {

    private ArraySorter() {
    }

    public static Array sortMaxToMin(Array array) throws WrongLinkException {

        if (array == null) {
            throw new WrongLinkException("массив не найден");
        }

        int min;
        int minI;
        int forSort;

        try {

            for (int i = 0; i < array.getLength(); i++) {
                min = array.getElement(i);
                minI = i;

                for (int j = i + 1; j < array.getLength(); j++) {

                    if (min < array.getElement(j)) {
                        min = array.getElement(j);
                        minI = j;
                    }

                }

                if (i != minI) {
                    forSort = array.getElement(i);
                    array.setElement(array.getElement(minI), i);
                    array.setElement(forSort, minI);
                }

            }

            return array;

        } catch (Exception ex) {
            return new Array(0, 0, 0, 0, 0);
        }

    }

    public static Array sortMinToMax(Array array) throws WrongLinkException {


        if (array == null) {
            throw new WrongLinkException("массив не найден");
        }

        int forSort;

        int i = 0;

        try {

            while (i < array.getLength() - 1) {

                if (array.getElement(i) > array.getElement(i + 1)) {
                    forSort = array.getElement(i);
                    array.setElement(array.getElement(i + 1), i);
                    array.setElement(forSort, i + 1);
                    i--;
                } else {
                    i++;
                }

                if (i < 0) {
                    i = 0;
                }

            }

            return array;

        } catch (Exception ex) {
            return new Array(0, 0, 0, 0, 0);
        }
    }

    public static Array sortAnotherMaxToMin(Array array) throws WrongLinkException {

        if (array == null) {
            throw new WrongLinkException("массив не найден");
        }

        int forSort;

        try {

            for (int i = array.getLength() - 1; i > 0; i--) {

                for (int j = 0; j < i; j++) {

                    if (array.getElement(j) < array.getElement(j + 1)) {
                        forSort = array.getElement(j + 1);
                        array.setElement(array.getElement(j), j + 1);
                        array.setElement(forSort, j);
                    }

                }

            }

            return array;

        } catch (Exception ex) {
            return new Array(0, 0, 0, 0, 0);
        }
    }


}
