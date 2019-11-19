/*
 *
 *пользовательский интерфейс
 *
 */

package by.javatr.task10.runable;

import by.javatr.scanner.InputFromKeyboardScanner;
import by.javatr.task10.util.CoordinatesException;
import by.javatr.task10.util.FunctionalValueFinder;

public class UserInterface {

    public static void main(String[] args) {

        double startPoint;
        double finishPoint;
        double step;
        double[][] result;

        System.out.print("Введите начальную точку: ");
        startPoint = InputFromKeyboardScanner.inputDoubleNumberWithHints();
        System.out.print("Введите конечную точку: ");
        finishPoint = InputFromKeyboardScanner.inputDoubleNumberWithHints();
        System.out.print("Введите шаг: ");
        step = InputFromKeyboardScanner.inputDoubleNumberWithHints();

        try {
            result = FunctionalValueFinder.findFuntionalValueInInterval(startPoint, finishPoint, step);

            for (int i = 0; i < result.length; i++) {
                System.out.println("F(" + result[i][0] + ")=" + result[i][1]);
            }

        } catch (CoordinatesException ex) {
            System.out.println("неверно введены координаты");
        }

    }

}
