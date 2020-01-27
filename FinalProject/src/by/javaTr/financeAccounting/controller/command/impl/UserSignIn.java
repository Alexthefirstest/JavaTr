package by.javaTr.financeAccounting.controller.command.impl;

import by.javaTr.financeAccounting.controller.command.Command;
import by.javaTr.financeAccounting.controller.conditions.Conditions;
import by.javaTr.financeAccounting.logger.MyLogger;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.factory.ServiceFactory;

import java.util.logging.Level;

public class UserSignIn implements Command {

    @Override
    public String execute(String request) {

        String[] parameters = request.split(" ");

        if (parameters.length < 3) {
            return "please, enter login and password";
        }

        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        try {
            serviceFactory.getUserService().userSignIn(parameters[1],
                    serviceFactory.getTextEncodeService().encode(parameters[2]));
            Conditions.setCondition(Conditions.User);
            return "welcome";

        } catch (ServiceException ex) {

            if (ex.getMessage().equals("login is null") || ex.getMessage().equals("password is null")) {
                MyLogger.getLogger().log(Level.WARNING, "UserSignIn", ex);
                return "program error";
            }

            return ex.getMessage();
        }

    }
}
