package by.javaTr.financeAccounting.controller.command.impl.supputringClasses;

import by.javaTr.financeAccounting.bean.Bill;
import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.logger.MyLogger;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.factory.ServiceFactory;

import java.util.logging.Level;

public class LastRespondedArray {

    private LastRespondedArray() {
    }

    public static Bill[] billsArray;

    public static Bill[] getBillsArray() {
        return billsArray;
    }

    public static void setBillsArray(Bill[] billsArray) {
        LastRespondedArray.billsArray = billsArray;
    }

}
