/*
 *
 *пользовательский интерфейс
 *
 */

package by.javatr.task1.runner;

import by.javatr.scanner.InputFromKeyboardScanner;
import by.javatr.task1.util.SquareOfLastNumberDigitFinder;

public class UserInterface {

    public static void main(String args[]){

        double number;
        int lastDigitSquare;

        System.out.print("Введите число: ");
        number= InputFromKeyboardScanner.inputDoubleNumberWithHints();
        lastDigitSquare=SquareOfLastNumberDigitFinder.findSquareOfLastNumberDigit(number);
        System.out.println("Последняя цифра квадрата введенного числа: "+ lastDigitSquare);
    }

}
