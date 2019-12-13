package by.javatr.bulhak.task2.run;

import by.javatr.bulhak.task2.util.*;

import java.util.Arrays;

public class TaskTest {

    public static void main(String[] args) throws WrongLinkException {
        int[][] arr = new int[3][];

        arr[0] = new int[]{1, 2, 15, 10};
        arr[1] = new int[]{-1, 2, 20};
        arr[2] = new int[]{0, 1, 3, 2, 5, 4};

        Sorter sortBySumOfElements = new SorterBySumOfElements();
        printArray(sortBySumOfElements.maxToMin(arr));
        System.out.println();
        printArray(sortBySumOfElements.minToMax(arr));

        System.out.println("/n");
        Sorter sortByMinElement = new SorterByMinElement();
        printArray(sortByMinElement.maxToMin(arr));
        System.out.println();
        printArray(sortByMinElement.minToMax(arr));

        System.out.println("/n");
        Sorter sortByMaxElement = new SorterByMaxElement();
        printArray(sortByMaxElement.maxToMin(arr));
        System.out.println();
        printArray(sortByMaxElement.minToMax(arr));
    }

    public static void printArray(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }
}
