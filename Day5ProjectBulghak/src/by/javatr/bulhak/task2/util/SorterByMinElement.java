package by.javatr.bulhak.task2.util;

public class SorterByMinElement extends Sorter {


    @Override
    protected int methodToCompare(int[] arr) {

        int min = 999999999;

        for (int i = 0; i < arr.length; i++) {

            if (min > arr[i]) {
                min = arr[i];
            }

        }

        return min;
    }


}
