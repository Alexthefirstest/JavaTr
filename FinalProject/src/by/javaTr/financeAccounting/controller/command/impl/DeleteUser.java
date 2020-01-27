package by.javaTr.financeAccounting.controller.command.impl;

import by.javaTr.financeAccounting.controller.command.Command;
import by.javaTr.financeAccounting.controller.conditions.Conditions;
import by.javaTr.financeAccounting.logger.MyLogger;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.factory.ServiceFactory;

import java.util.logging.Level;

public class DeleteUser implements Command {


    @Override
    public String execute(String request) {

        if (!Conditions.checkCondition(Conditions.ADMIN)) {
            MyLogger.getLogger().log(Level.WARNING, "wrong conditions", getClass().getName());
            return "program error, wrong available";
        }

        String[] parameters = request.split(" ");

        if (parameters.length < 2) {
            return "please, enter login";
        }

        try {
            return ServiceFactory.getInstance().getUserDeleterService().deleteUser(parameters[1]) ? "user delete" :
                    "user or bills catalog wasn't exist";
        } catch (ServiceException ex) {
            MyLogger.getLogger().log(Level.WARNING, "DeleteUser", ex);
            return "program error";
        }

    }
}
