package by.javatr.bulhak.task1.run;

import by.javatr.bulhak.task1.util.entity.*;
import by.javatr.bulhak.task1.util.exceptions.WrongLinkException;
import by.javatr.bulhak.task1.util.validation.*;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TaskTest {

    public static void main(String[] args) {

        Array array = new Array();

        readFromFile(array, ".\\src\\by\\javatr\\bulhak\\task1\\numbers.txt");
        addRandomElements(array, 3);
        AddElementsFromKeyboard(array);
        System.out.println(array.elementsToString());
        System.out.println(array.getLength());

        try {
            System.out.println(ArraySorter.sortMinToMax(array));
            System.out.println(ElementPositionFinder.findElement(array, 121));
            System.out.println(MaxOrMinElementFinder.maxElementFinder(array));
            System.out.println(PrimeNumbersFinder.getOnlyPrimeNumbers(array).elementsToString());
            System.out.println(FibonachiNumbersFinder.findFibonachiNumbers(array));
            System.out.println(ThreeDiferentsDigitsNumbersFinder.getThreeDifferentDigitsNumbers(array));
        } catch (WrongLinkException ex) {
            ex.printStackTrace();
        }
    }

    public static void AddElementsFromKeyboard(Array arrToAdd) {

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
