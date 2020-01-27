package by.javaTr.financeAccounting.service;

import by.javaTr.financeAccounting.bean.Bill;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;

public interface BillsSortingService {

    Bill[] sortByName(Bill... bills) throws ServiceException;

    Bill[] sortByCategory(Bill... bills) throws ServiceException;

    Bill[] sortByMoney(Bill... bills) throws ServiceException;

    Bill[] sortByDate(Bill... bills) throws ServiceException;

}
