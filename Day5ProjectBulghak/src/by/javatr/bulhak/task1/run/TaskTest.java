package by.javatr.bulhak.task1.run;

import by.javatr.bulhak.task1.util.entity.*;
import by.javatr.bulhak.task1.util.exceptions.WrongLinkException;
import by.javatr.bulhak.task1.util.validation.*;

public class TaskTest {

    public static void main(String[] args) {

        Array array = new Array();

        ArrayFiller.readFromFile(array, ".\\src\\by\\javatr\\bulhak\\task1\\numbers.txt");
        ArrayFiller.addRandomElements(array, 3);
        ArrayFiller.addElementsFromKeyboard(array);


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


}
