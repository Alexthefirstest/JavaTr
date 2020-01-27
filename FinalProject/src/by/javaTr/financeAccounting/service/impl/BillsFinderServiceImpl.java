package by.javaTr.financeAccounting.service.impl;

import by.javaTr.financeAccounting.bean.Bill;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;

import java.util.ArrayList;

public class BillsFinderServiceImpl implements by.javaTr.financeAccounting.service.BillsFinderService {

    @Override
    public Bill[] findByName(String name, Bill... bills) throws ServiceException {

        FinanceServiceImpl.nullCheck(bills);

        if (name == null) {
            throw new ServiceException("bills is null");
        }

        ArrayList<Bill> foundBills = new ArrayList<>();


        for (int i = 0; i < bills.length; i++) {

            if (bills[i].getName().toUpperCase().equals(name.toUpperCase())) {
                foundBills.add(bills[i]);
            }

        }


        return (Bill[]) foundBills.toArray();
    }

    @Override
    public Bill[] findByCategory(String category, Bill... bills) throws ServiceException {

        FinanceServiceImpl.nullCheck(bills);

        if (category == null) {
            throw new ServiceException("bills is null");
        }

        ArrayList<Bill> foundBills = new ArrayList<>();


        for (int i = 0; i < bills.length; i++) {
            if (bills[i].getCategory().toUpperCase().equals(category.toUpperCase())) {
                foundBills.add(bills[i]);
            }
        }


        return (Bill[]) foundBills.toArray();
    }


}
