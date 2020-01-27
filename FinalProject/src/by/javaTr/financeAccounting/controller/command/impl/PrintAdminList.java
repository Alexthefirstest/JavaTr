package by.javaTr.financeAccounting.controller.command.impl;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.controller.command.Command;
import by.javaTr.financeAccounting.controller.conditions.Conditions;
import by.javaTr.financeAccounting.logger.MyLogger;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.factory.ServiceFactory;

import java.util.logging.Level;

public class PrintAdminList implements Command {


    @Override
    public String execute(String request) {

        if (!Conditions.checkCondition(Conditions.ADMIN)) {
            MyLogger.getLogger().log(Level.WARNING, "wrong conditions", getClass().getName());
            return "program error, wrong available";
        }

        StringBuilder response = new StringBuilder();

        try {
            User[] users = ServiceFactory.getInstance().getUserService().getAdmins();

            for (int i = 0; i < users.length; i++) {
                response.append(users[i].getLogin()).append("\n");
            }

        } catch (ServiceException ex) {
            MyLogger.getLogger().log(Level.WARNING, "PrintAdminList", ex);
            return "program error";
        }

        return response.toString();
    }
}
