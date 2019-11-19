/*
 *
 *пользовательский интерфейс
 *
 */

package by.javatr.task2.runner;

import by.javatr.scanner.InputFromKeyboardScanner;
import by.javatr.task2.util.QuantityOfDaysInMonthFinder;
import by.javatr.task2.util.WrongMonthException;
import by.javatr.task2.util.WrongYearException;

public class UserInterface {

    public static void main(String[] args) {

        int year;
        int month;
        int daysInMonthQuantity;

        System.out.print("Введите год: ");
        year = InputFromKeyboardScanner.inputIntNumberWithHints();

        System.out.print("Введите месяц: ");
        month = InputFromKeyboardScanner.inputIntNumberWithHints();

        try {

            daysInMonthQuantity = QuantityOfDaysInMonthFinder.FindQuantityOfDaysInMonth(year, month);
            System.out.println("количество дней в указанном месяце: " + daysInMonthQuantity);

        } catch (WrongYearException ex) {
            System.out.println("неверно указан год");
        } catch (WrongMonthException ex) {
            System.out.println("неверно указан месяц");
        }

    }

}
