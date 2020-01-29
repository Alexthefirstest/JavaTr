package by.javaTr.financeAccounting.controller.command.impl;

import by.javaTr.financeAccounting.controller.command.Command;
import by.javaTr.financeAccounting.logger.MyLogger;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.factory.ServiceFactory;

import java.util.logging.Level;

public class UserRegistrations implements Command {
    @Override
    public String execute(String request) {
        String[] parameters = request.split(" ");

        if (parameters.length < 3) {
            return "please, enter login and password";
        }

        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        try {
            boolean isSuccess = serviceFactory.getUserService().userRegistration(parameters[1],
                    serviceFactory.getTextEncodeService().encode(parameters[2]));

            if (isSuccess) {

                return "welcome";
            } else {
                return "user with this name already exist";
            }

        } catch (ServiceException ex) {

            if (ex.getMessage().equals("login is null") || ex.getMessage().equals("password is null")) {
                MyLogger.getLogger().log(Level.WARNING, "UserRegistration", ex);
                return "program error";
            }

            if(ex.getMessage()=="Source file not found"){
                MyLogger.getLogger().log(Level.WARNING, "UserRegistrations, source problem", ex);
            }

            return ex.getMessage();
        }

    }
}
