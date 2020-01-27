package by.javaTr.financeAccounting.controller.command.impl;

import by.javaTr.financeAccounting.bean.Bill;
import by.javaTr.financeAccounting.controller.command.Command;
import by.javaTr.financeAccounting.controller.command.impl.supputringClasses.DateFromString;
import by.javaTr.financeAccounting.controller.command.impl.supputringClasses.ResponseFromArrayCreator;
import by.javaTr.financeAccounting.controller.conditions.Conditions;
import by.javaTr.financeAccounting.logger.MyLogger;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.factory.ServiceFactory;

import java.util.Date;
import java.util.logging.Level;

public class GetBillsForMonth implements Command {
    @Override
    public String execute(String request) {

        if(!Conditions.checkCondition(Conditions.User)){
            MyLogger.getLogger().log(Level.WARNING, "wrong conditions", getClass().getName());
            return "program error, wrong available";
        }

        String[] parameters = request.split(" ");

        if (parameters.length < 3) {
            return "wrong parameters";
        }

        Date date = DateFromString.getDateFromString(parameters[2]);
        if (date == null) {
            return "wrong date format, use: day.month.year";
        }

        try {
            Bill[] bills = ServiceFactory.getInstance().getFinanceService().getBillsForMonth(parameters[1], date);
            return ResponseFromArrayCreator.responseFromBills(bills);
        } catch (ServiceException ex) {
            MyLogger.getLogger().log(Level.WARNING, "GetBillsForMonth", ex);
            return "programme error";
        }

    }

}
