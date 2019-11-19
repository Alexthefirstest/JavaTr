/*
 *
 *пользовательский интерфейс
 *
 */

package by.javatr.task9.runner;

import by.javatr.scanner.InputFromKeyboardScanner;
import by.javatr.task9.util.Circle;
import by.javatr.task9.util.RadiusException;

public class UserInterface {

    public static void main(String[] args) {

        double radius;

        System.out.print("Введите радиус: ");
        radius = InputFromKeyboardScanner.inputDoubleNumberWithHints();

        try {

            Circle circle = new Circle(radius);
            System.out.println("Длина окружности: " + circle.getLengthOfCircle());
            System.out.println("Площадь круга: " + circle.getSquareOfCircle());

        } catch (RadiusException ex) {
            System.out.println("неверно указан радиус");
        }

    }
}
