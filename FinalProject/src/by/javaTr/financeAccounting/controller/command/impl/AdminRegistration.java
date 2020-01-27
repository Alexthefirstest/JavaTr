package by.javaTr.financeAccounting.controller.command.impl;

import by.javaTr.financeAccounting.controller.command.Command;
import by.javaTr.financeAccounting.controller.conditions.Conditions;
import by.javaTr.financeAccounting.logger.MyLogger;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.factory.ServiceFactory;

import java.util.logging.Level;

public class AdminRegistration implements Command {

    @Override
    public String execute(String request) {

        if (!Conditions.checkCondition(Conditions.ADMIN)) {
            MyLogger.getLogger().log(Level.WARNING, "wrong conditions", getClass().getName());
            return "program error, wrong available";
        }

        String[] parameters = request.split(" ");

        if (parameters.length < 3) {
            return "please, enter login and password";
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        try {
            boolean isSuccess = serviceFactory.getUserService().adminRegistration(
                    serviceFactory.getTextEncodeService().encode(parameters[1]),
                    serviceFactory.getTextEncodeService().encode(parameters[2]));

            return isSuccess ? "welcome" : "user with this name already exist";

        } catch (ServiceException ex) {

            if (ex.getMessage().equals("login is null") || ex.getMessage().equals("password is null")) {
                MyLogger.getLogger().log(Level.WARNING, "AdminRegistration", ex);
                return "program error";
            }

            return ex.getMessage();
        }

    }
}
