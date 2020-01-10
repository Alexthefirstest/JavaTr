package by.javatr.bulhak.task1.run;

import by.javatr.bulhak.task1.util.entity.Array;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ArrayFiller {

    public static void addElementsFromKeyboard(Array arrToAdd) {

        if (arrToAdd == null) {
            System.out.println("Массив не задан");
        }

        Scanner in = new Scanner(System.in);
        String element;
        int number;

        System.out.println("Введите элементы массива, для завершения нажать \".\": ");

        while (true) {

            System.out.print("El[" + (arrToAdd.getLength() + 1) + "]: ");
            element = in.next();
            if (element.equals(".")) {
                return;
            } else {

                if (Pattern.matches("\\d+", element)) {
                    arrToAdd.addElement(Integer.parseInt(element));
                } else {
                    System.out.println("Введите целое число");
                }

            }

        }//while

    }

    public static void addRandomElements(Array arrayToAdd, int howManyElements) {

        if (arrayToAdd == null) {
            System.out.println("Массив не задан");
        }

        if (arrayToAdd == null) {
            System.out.println("Массив не задан");
        }

        for (int i = 0; i < howManyElements; i++) {
            arrayToAdd.addElement((int) (Math.random() * 10000000));
        }
    }

    public static void readFromFile(Array arrayToAdd, String FileAddress) {
        if (arrayToAdd == null) {
            System.out.println("Массив не задан");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FileAddress))) {

            String line;
            while ((line = br.readLine()) != null) {
                arrayToAdd.addElement(Integer.parseInt(line));
            }

        } catch (FileNotFoundException ex) {
            System.out.println("файл не найден");
        } catch (IOException | NumberFormatException ex) {
            System.out.println("файл неверно заполнен");
        }

    }

}
