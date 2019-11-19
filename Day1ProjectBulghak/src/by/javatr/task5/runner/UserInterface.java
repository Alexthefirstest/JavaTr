/*
 *
 *пользовательский интерфейс
 *
 */

package by.javatr.task5.runner;

import by.javatr.scanner.InputFromKeyboardScanner;
import by.javatr.task5.util.IdealNumberChecker;

public class UserInterface {

    public static void main(String[] args) {

        int number;

        System.out.print("Введите число: ");
        number= InputFromKeyboardScanner.inputIntNumberWithHints();

        if(IdealNumberChecker.idealNumberCheck(number)==true){
            System.out.println("число является совершенным");
        }else{
            System.out.println("число не является совершенным");
        }

    }

}
