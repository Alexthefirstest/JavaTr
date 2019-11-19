/*
 *
 *класс содержащий статические методы для ввода с клавиатуры
 *
 */

package by.javatr.scanner;

import java.util.Scanner;

public class InputFromKeyboardScanner {

    /*ввод значения типа double с проверкой вода*/
    public static double inputDoubleNumberWithHints() {

        Scanner in=new Scanner(System.in);
        double number;

        while(!in.hasNextDouble()){
            System.out.print("введите число: ");
            in.next();
        }

        number=in.nextDouble();

        return number;
    }

    /*ввод значения типа int с проверкой вода*/
    public static int inputIntNumberWithHints() {

        Scanner in=new Scanner(System.in);
        int number;

        while(!in.hasNextInt()){
            System.out.print("введите целое число: ");
            in.next();
        }

        number=in.nextInt();

        return number;
    }

}
