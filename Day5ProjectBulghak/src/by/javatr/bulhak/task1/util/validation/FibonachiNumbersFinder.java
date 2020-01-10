package by.javatr.bulhak.task1.util.validation;

import by.javatr.bulhak.task1.util.entity.Array;
import by.javatr.bulhak.task1.util.exceptions.WrongPosition;

public final class FibonachiNumbersFinder {

    private FibonachiNumbersFinder() {
    }

    public static boolean isFibonachi(int number) {

        int f = 0;
        int n = 0;

        while (number >= f) {

            f = (int) ((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n)) / Math.sqrt(5));

            if (f == number) {
                return true;
            }

            n++;
        }
        return false;
    }

    public static Array findFibonachiNumbers(Array array){

        Array result=new Array();

        try {

            for (int i = 0; i < array.getLength(); i++) {

                if (isFibonachi(array.getElement(i))) {
                    result.addElement(array.getElement(i));
                }

            }

            return result;
        }catch (WrongPosition ex){

        }

        return array;
    }

}

