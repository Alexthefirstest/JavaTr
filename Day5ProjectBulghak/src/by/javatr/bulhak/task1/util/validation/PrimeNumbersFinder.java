package by.javatr.bulhak.task1.util.validation;

import by.javatr.bulhak.task1.util.entity.Array;
import by.javatr.bulhak.task1.util.exceptions.*;

public final class PrimeNumbersFinder {

    private PrimeNumbersFinder() {
    }

    public static boolean isPrime(int number) {

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                return false;
            }

        }

        return true;
    }

    public static Array getOnlyPrimeNumbers(Array array) throws WrongLinkException {

        if (array == null) {
            throw new WrongLinkException("массив не найден");
        }

        try {
            Array result = new Array(0);


            for (int i = 0; i < array.getLength(); i++) {

                if (isPrime(array.getElement(i))) {

                    result.addElement(array.getElement(i));
                }

            }

            return result;

        } catch (WrongElementsQuantity | WrongPosition ex) {
            return array;
        }

    }

}
