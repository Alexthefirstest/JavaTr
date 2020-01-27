package by.javaTr.financeAccounting.controller.command.impl;

import by.javaTr.financeAccounting.controller.command.Command;
import by.javaTr.financeAccounting.controller.conditions.Conditions;
import by.javaTr.financeAccounting.logger.MyLogger;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.factory.ServiceFactory;

import java.util.logging.Level;

public class DeleteAdmin implements Command {


    @Override
    public String execute(String request) {

        if (!Conditions.checkCondition(Conditions.User)) {
            MyLogger.getLogger().log(Level.WARNING, "wrong conditions", getClass().getName());
            return "program error, wrong available";
        }

        String[] parameters = request.split(" ");

        if (parameters.length < 2) {
            return "please, enter login";
        }

        try {
            return ServiceFactory.getInstance().getAdminDeleterService().deleteAdmin(parameters[2]) ? "admin delete" :
                    "admin wasn't exist";
        } catch (ServiceException ex) {
            MyLogger.getLogger().log(Level.WARNING, "DeleteAdmin", ex);
            return "program error";
        }

    }
}
