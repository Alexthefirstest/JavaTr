package by.javatr.bulhak.task2.util;

public class SorterByMaxElement extends Sorter {


    @Override
    protected int methodToCompare(int[] arr) {

        int max = -999999999;

        for (int i = 0; i < arr.length; i++) {

            if (max < arr[i]) {
                max = arr[i];
            }

        }

        return max;
    }

}
