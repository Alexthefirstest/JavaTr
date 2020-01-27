package by.javaTr.financeAccounting.controller.command.impl;

import by.javaTr.financeAccounting.controller.command.Command;
import by.javaTr.financeAccounting.logger.MyLogger;

import java.util.logging.Level;


public class WrongRequest implements Command {

    @Override
    public String execute(String request) {
        MyLogger.getLogger().log(Level.WARNING, "WRONG_REQUEST: " + request);
        return "wrong request";
    }
}
