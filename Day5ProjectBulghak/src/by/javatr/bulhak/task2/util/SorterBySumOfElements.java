package by.javatr.bulhak.task2.util;

public class SorterBySumOfElements extends Sorter {

    protected int methodToCompare(int[] elements) {

        int sum = 0;

        for (int i = 0; i < elements.length; i++) {
            sum += elements[i];
        }

        return sum;
    }

}
