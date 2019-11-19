/*
 *
 *пользовательский интерфейс
 *
 */

package by.javatr.task8.runner;

import by.javatr.scanner.InputFromKeyboardScanner;
import by.javatr.task8.util.FunctionalValueFinder;

public class UserInterface {

    public static void main(String[] args) {

        double x;

        System.out.print("введите x: ");
        x= InputFromKeyboardScanner.inputDoubleNumberWithHints();
        System.out.println("F("+x+")="+FunctionalValueFinder.findValue(x));

    }

}
