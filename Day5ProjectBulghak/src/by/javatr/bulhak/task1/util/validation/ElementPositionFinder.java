package by.javatr.bulhak.task1.util.validation;

import by.javatr.bulhak.task1.util.entity.Array;
import by.javatr.bulhak.task1.util.exceptions.WrongLinkException;

public final class ElementPositionFinder {

    private ElementPositionFinder() {
    }

    public static int findElement(Array array, int element) throws WrongLinkException {

        if (array == null) {
            throw new WrongLinkException("массив не найден");
        }

        int position;
        int startPoint = 0;
        int finishPoint = array.getLength() - 1;

        array = ArraySorter.sortMinToMax(array);


        try {

            while (true) {

                position = (finishPoint + startPoint) / 2;

                if (array.getElement(position) == element) {
                    return position;
                }

                if (array.getElement(position) < element) {
                    startPoint = position + 1;
                } else if (array.getElement(position) > element) {
                    finishPoint = position - 1;
                } else {
                    return -1;
                }

            }

        } catch (Exception ex) {
            return -2;
        }

    }

}
