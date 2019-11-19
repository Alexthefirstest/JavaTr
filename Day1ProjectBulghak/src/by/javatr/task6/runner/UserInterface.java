/*
 *
 *пользовательский интерфейс
 *
 */

package by.javatr.task6.runner;

import by.javatr.scanner.InputFromKeyboardScanner;
import by.javatr.task6.util.DayTimeInSecondsToClassicTIme;
import by.javatr.task6.util.TimeException;

public class UserInterface {

    public static void main(String[] args) {

        int seconds;

        System.out.print("введите количество секунд: ");
        seconds=InputFromKeyboardScanner.inputIntNumberWithHints();

        try{
            String time= DayTimeInSecondsToClassicTIme.convertSecondsToClassicTime(seconds);
            System.out.println(time);
        }catch (TimeException ex){
            System.out.println("неверно введено время");
        }

    }

}
