package by.javaTr.financeAccounting.controller.command.impl;

import by.javaTr.financeAccounting.controller.command.Command;
import by.javaTr.financeAccounting.controller.command.impl.supputringClasses.LastRespondedArray;
import by.javaTr.financeAccounting.controller.command.impl.supputringClasses.ResponseFromArrayCreator;
import by.javaTr.financeAccounting.controller.conditions.Conditions;
import by.javaTr.financeAccounting.logger.MyLogger;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.factory.ServiceFactory;

import java.util.logging.Level;

public class BillsFindByCategory implements Command {

    @Override
    public String execute(String request) {

        if(!Conditions.checkCondition(Conditions.USER)){
            MyLogger.getLogger().log(Level.WARNING, "wrong conditions", getClass().getName());
            return "program error, wrong available";
        }

        String[] parameters = request.split(" ");

        if (parameters.length < 2) {
            MyLogger.getLogger().log(Level.WARNING, "ask for login in finding method: " + getClass().getName());
            return "program error";
        }

        try {
            return ResponseFromArrayCreator.responseFromBills(
                    ServiceFactory.getInstance().getBillsFinderService().findByCategory(parameters[1],
                            LastRespondedArray.getBillsArray()));

        } catch (ServiceException ex) {

            if (ex.getMessage().equals("bills is null")) {
                return "bills wasn't choose";
            } else {
                MyLogger.getLogger().log(Level.WARNING, "sorting", ex);
                return "program error";
            }

        }

    }

}
