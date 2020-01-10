package by.javatr.bulhak.task2.run;

import by.javatr.bulhak.task2.util.*;

import java.util.Arrays;

public class TaskTest {

    public static void main(String[] args) throws WrongLinkException{

        int[][] arr = new int[3][];

        arr[0] = new int[]{1, 2, 15, 10};
        arr[1] = new int[]{-1, 2, 20};
        arr[2] = new int[]{0, 1, 3, 2, 5, 4};

        printArray(new SorterBySumOfElements().maxToMin(arr));
        System.out.println();
        printArray(new SorterBySumOfElements().minToMax(arr));

        System.out.println("\n");

        printArray(new SorterByMinElement().maxToMin(arr));
        System.out.println();
        printArray(new SorterByMinElement().minToMax(arr));

        System.out.println("\n");
        printArray(new SorterByMaxElement().maxToMin(arr));
        System.out.println();
        printArray(new SorterByMaxElement().minToMax(arr));
    }

    public static void printArray(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }

}
