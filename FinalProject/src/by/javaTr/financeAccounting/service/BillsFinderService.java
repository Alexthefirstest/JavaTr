package by.javaTr.financeAccounting.service;

import by.javaTr.financeAccounting.bean.Bill;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;

public interface BillsFinderService {

    Bill[] findByName(String name, Bill... bills) throws ServiceException;

    Bill[] findByCategory(String category, Bill... bills) throws ServiceException;



}
