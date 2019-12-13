package by.javatr.bulhak.task1.util.validation;

import by.javatr.bulhak.task1.util.entity.*;
import by.javatr.bulhak.task1.util.exceptions.WrongLinkException;
import by.javatr.bulhak.task1.util.exceptions.WrongPosition;

public final class ThreeDiferentsDigitsNumbersFinder {

    private ThreeDiferentsDigitsNumbersFinder() {
    }

    public static Array getThreeDifferentDigitsNumbers(Array array) throws WrongLinkException {

        if (array == null) {
            throw new WrongLinkException("массив не задан");
        }

        try {

            Array result = new Array();

            for (int i = 0; i < array.getLength(); i++) {

                if (getLenghtOfNumber(array.getElement(i)) == 3
                        && !isConsistTheSameDigits(array.getElement(i))) {
                    result.addElement(array.getElement(i));
                }

            }

            return result;
        } catch (WrongPosition ex) {
            return array;
        }
    }

    public static int getLenghtOfNumber(int number) {
        return ("" + number).length();
    }

    public static Array getDigitsFromNumber(int number) {

        Array result = new Array();

        int times=getLenghtOfNumber(number);
        for (int i = 0; i < times; i++) {

            result.addElement(number % 10);
            number = number / 10;
        }
        return result;
    }

    public static boolean isConsistTheSameNumbers(Array numbers) throws WrongLinkException {

        int number;

        if (numbers == null) {
            throw new WrongLinkException("массив не задан");
        }

        try {


            for (int i = 0; i < numbers.getLength(); i++) {

                number = numbers.getElement(i);

                for (int j = i + 1; j < numbers.getLength(); j++) {
                    if (number == numbers.getElement(j)) {
                        return true;
                    }
                }

            }
            return false;

        } catch (WrongPosition ex) {
            return false;
        }
    }

    public static boolean isConsistTheSameDigits(int number) {

        Array digits = getDigitsFromNumber(number);

        try {
            return isConsistTheSameNumbers(digits);
        } catch (WrongLinkException ex) {
            return false;
        }

    }
}
