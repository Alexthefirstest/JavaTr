/*
 *
 *используется выводящими массив методами, преобразует массив в строковый ответ
 *
 * так же добавляет к нему баланс счетов в массиве, прибыль и затраты
 *
 */

package by.javaTr.financeAccounting.controller.command.impl.supputringClasses;

import by.javaTr.financeAccounting.bean.Bill;
import by.javaTr.financeAccounting.logger.MyLogger;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.factory.ServiceFactory;

import java.text.SimpleDateFormat;
import java.util.logging.Level;

public class ResponseFromArrayCreator {

    private ResponseFromArrayCreator() {
    }

    public static String responseFromBills(Bill[] bills) {

        LastRespondedArray.setBillsArray(bills);

        StringBuilder response = new StringBuilder();

        if (bills == null) {
            return "find nothing";
        }
        for (int i = 0; i < bills.length; i++) {
            response.append("name:").append(bills[i].getName()).append(", category: ").append(bills[i].getCategory());
            response.append(", balance: ").append(String.format("%.2f", bills[i].getMoney())).append(", date: ");
            response.append(new SimpleDateFormat("dd.MM.yyyy").format(bills[i].getDate())).append("\n");
        }
        response.append("\n_____________________________________________________________________________\n");

        try {
            response.append("\nBalance: ").append(ServiceFactory.getInstance().getFinanceService().getBalance(bills));
            response.append("\n");
            response.append("\nIncome: ").append(ServiceFactory.getInstance().getFinanceService().getIncome(bills));
            response.append("\nExpenses: ").append(ServiceFactory.getInstance().getFinanceService().getExpenses(bills));
        } catch (ServiceException ex) {
            MyLogger.getLogger().log(Level.WARNING, "responseFromBillsCreator", ex);
        }

        return response.toString() + "\n";
    }

}
