package by.javaTr.financeAccounting.controller.command.impl;

import by.javaTr.financeAccounting.controller.command.Command;
import by.javaTr.financeAccounting.controller.conditions.Conditions;
import by.javaTr.financeAccounting.logger.MyLogger;

import java.util.logging.Level;

public class AdminSignOut implements Command {
    @Override
    public String execute(String request) {

        if(!Conditions.checkCondition(Conditions.ADMIN)){
            MyLogger.getLogger().log(Level.WARNING, "wrong conditions", getClass().getName());
            return "program error, wrong available";
        }

        Conditions.setCondition(Conditions.EMPTY);
        return "successfully logout";
    }

}
