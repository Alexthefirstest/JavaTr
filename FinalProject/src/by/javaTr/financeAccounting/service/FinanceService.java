package by.javaTr.financeAccounting.service;

import by.javaTr.financeAccounting.bean.Bill;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;

import java.util.Date;

public interface FinanceService {

    boolean addBills(String login, Bill... bills) throws ServiceException;

    Bill[] getBillsForPeriod(String login, Date startDate, Date finishDate) throws ServiceException;

    Bill[] getBillsForMonth(String login, Date date) throws ServiceException;

    double getBalance(Bill... bills) throws ServiceException;

    double getIncome(Bill...bills) throws ServiceException;

    double getExpenses (Bill...bills) throws ServiceException;
}
