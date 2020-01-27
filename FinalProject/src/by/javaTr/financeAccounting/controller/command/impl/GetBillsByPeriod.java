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

public class GetBillsByPeriod implements Command {

    @Override
    public String execute(String request) {

        if(!Conditions.checkCondition(Conditions.User)){
            MyLogger.getLogger().log(Level.WARNING, "wrong conditions", getClass().getName());
            return "program error, wrong available";
        }

        String[] parameters = request.split(" ");

        if (parameters.length < 4) {
            return "wrong parameters";
        }

        Date startDate = DateFromString.getDateFromString(parameters[2]);
        Date finishDate = DateFromString.getDateFromString(parameters[3]);
        if (startDate == null || finishDate == null) {
            return "wrong date format, use: day.month.year";
        }

        try {
            Bill[] bills = ServiceFactory.getInstance().getFinanceService().getBillsForPeriod(parameters[1],
                    startDate, finishDate);

            return ResponseFromArrayCreator.responseFromBills(bills);
        } catch (ServiceException ex) {
            MyLogger.getLogger().log(Level.WARNING, "GetBillsByPeriod", ex);
            return "programme error";
        }

    }

}
