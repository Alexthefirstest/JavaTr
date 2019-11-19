/*
 *
 *пользовательский интерфейс
 *
 */

package by.javatr.task3.runner;

import by.javatr.scanner.InputFromKeyboardScanner;
import by.javatr.task3.util.AreaOfInnerSquareAndDifferenceBetweenAreaFinder;
import by.javatr.task3.util.circle.RadiusException;
import by.javatr.task3.util.square.SquareException;

public class UserInterface {

    public static void main(String[] args) {

        double areaOfExternalSquare;

        System.out.println("введите площадь квадрата: ");
        areaOfExternalSquare = InputFromKeyboardScanner.inputDoubleNumberWithHints();

        try {

            double[] externalSquareAreaAndDifferenceBetweenAreas =
                    AreaOfInnerSquareAndDifferenceBetweenAreaFinder.findAreaAndDifference(areaOfExternalSquare);

            System.out.println("Площадь вписанного квадрата: " + externalSquareAreaAndDifferenceBetweenAreas[0] +
                    "\nплощадь описанного квадрата больше площади вписанного в "
                    + externalSquareAreaAndDifferenceBetweenAreas[1] + " раз");

        } catch (SquareException | RadiusException ex) {
            System.out.println("неверно указана площадь квадрата");
        }
    }

}
