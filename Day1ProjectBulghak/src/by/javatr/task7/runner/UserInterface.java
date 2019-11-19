/*
 *
 *пользовательский интерфейс
 *
 */

package by.javatr.task7.runner;

import by.javatr.scanner.InputFromKeyboardScanner;
import by.javatr.task7.util.ClosestPointToStartFinder;

public class UserInterface {

    public static void main(String[] args) {

        double[] point1 = new double[2];
        double[] point2 = new double[2];

        System.out.print("Введите x первой точки: ");
        point1[0] = InputFromKeyboardScanner.inputDoubleNumberWithHints();
        System.out.print("Введите y первой точки: ");
        point1[1] = InputFromKeyboardScanner.inputDoubleNumberWithHints();

        System.out.print("Введите x второй точки: ");
        point2[0] = InputFromKeyboardScanner.inputDoubleNumberWithHints();
        System.out.print("Введите y второй точки: ");
        point2[1] = InputFromKeyboardScanner.inputDoubleNumberWithHints();

        int result = ClosestPointToStartFinder.closestFromTwoPointFinder(point1[0], point1[1], point2[0], point2[1]);

        switch (result) {

            case 1:
                System.out.println("первая точка ближе к началу координат");
                break;

            case -1:
                System.out.println("вторая точка ближе к началу координат");
                break;

            default:
                System.out.println("обе точки находятся на равном расстоянии от начала координат");
                break;
        }


    }

}
