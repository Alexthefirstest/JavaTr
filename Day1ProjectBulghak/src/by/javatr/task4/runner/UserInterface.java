/*
 *
 *пользовательский интерфейс
 *
 */

package by.javatr.task4.runner;

import by.javatr.scanner.InputFromKeyboardScanner;
import by.javatr.task4.util.EvenNumbersChecker;

public class UserInterface {

    public static void main(String[] args) {

        int a;
        int b;
        int c;
        int d;

        System.out.print("Введите A: ");
        a = InputFromKeyboardScanner.inputIntNumberWithHints();
        System.out.print("Введите B: ");
        b = InputFromKeyboardScanner.inputIntNumberWithHints();
        System.out.print("Введите C: ");
        c = InputFromKeyboardScanner.inputIntNumberWithHints();
        System.out.print("Введите D: ");
        d = InputFromKeyboardScanner.inputIntNumberWithHints();

        System.out.println(EvenNumbersChecker.isTwoOfFourNumbersEvenCheck(new int[]{a, b, c, d}));
    }

}
