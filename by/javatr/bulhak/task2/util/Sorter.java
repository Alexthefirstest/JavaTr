package by.javatr.bulhak.task2.util;

public abstract class Sorter {

    public int[][] maxToMin(int[][] array) throws WrongLinkException {

        WrongLinkCheck.isObjectNull(array);

        int[] forSort;

        for (int i = array.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (methodToCompare(array[j]) < methodToCompare(array[j + 1])) {
                    forSort = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = forSort;
                }

            }

        }

        return array;
    }

    public int[][] minToMax(int[][] array) throws WrongLinkException {

        WrongLinkCheck.isObjectNull(array);

        int[] forSort;

        for (int i = array.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (methodToCompare(array[j]) > methodToCompare(array[j + 1])) {
                    forSort = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = forSort;
                }

            }

        }

        return array;
    }


   protected abstract int methodToCompare(int[] arr);

}
