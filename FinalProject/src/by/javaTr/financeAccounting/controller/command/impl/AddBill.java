package by.javaTr.financeAccounting.controller.command.impl;

import by.javaTr.financeAccounting.bean.Bill;
import by.javaTr.financeAccounting.controller.command.Command;
import by.javaTr.financeAccounting.controller.command.impl.supputringClasses.DateFromString;
import by.javaTr.financeAccounting.controller.conditions.Conditions;
import by.javaTr.financeAccounting.logger.MyLogger;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.factory.ServiceFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;


public class AddBill implements Command {


    @Override
    public String execute(String request) {

        if(!Conditions.checkCondition(Conditions.USER)){
            MyLogger.getLogger().log(Level.WARNING, "wrong conditions", getClass().getName());
            return "program error, wrong available";
        }

        String[] parameters = request.split(" ");

        if (parameters.length < 6) {
            return "wrong parameters";
        }

        Date date= DateFromString.getDateFromString(parameters[4]);
        if(date == null){
            return "wrong date format, use: day.month.year";
        }

        double money;

        try {
            money = Double.parseDouble(parameters[3]);
        } catch (NumberFormatException ex) {
            return "wrong money format";
        }

        Bill bill = new Bill(parameters[1], parameters[2], money, date);

        try {
            ServiceFactory.getInstance().getFinanceService().addBills(parameters[5], bill);
        } catch (ServiceException ex) {
            MyLogger.getLogger().log(Level.WARNING, "AddBill Method", ex);
            return "program error";
        }
        return "bill added successfully: name:" + bill.getName() + ", category: " + bill.getCategory() +
                ", balance: " + bill.getMoney() + ", date: " + (new SimpleDateFormat("dd.MM.yyyy").format(bill.getDate()));
    }


}
