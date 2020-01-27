/*
*
*метды сортировки счетов, переданных как параметр
*
*/


package by.javaTr.financeAccounting.service.impl;

import by.javaTr.financeAccounting.bean.Bill;
import by.javaTr.financeAccounting.service.BillsSortingService;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.impl.comparators.BillsComparatorByCategory;
import by.javaTr.financeAccounting.service.impl.comparators.BillsComparatorByDate;
import by.javaTr.financeAccounting.service.impl.comparators.BillsComparatorByMoney;
import by.javaTr.financeAccounting.service.impl.comparators.BillsComparatorByName;

import java.util.Arrays;

public class BillsSortingServiceImpl implements BillsSortingService {


    @Override
    public Bill[] sortByName(Bill... bills) throws ServiceException {

        FinanceServiceImpl.nullCheck(bills);

        Bill[] newBills = getBillsCopy(bills);
        Arrays.sort(newBills, new BillsComparatorByName());

        return newBills;
    }

    @Override
    public Bill[] sortByCategory(Bill... bills) throws ServiceException {

        FinanceServiceImpl.nullCheck(bills);

        Bill[] newBills = getBillsCopy(bills);
        Arrays.sort(newBills, new BillsComparatorByCategory());

        return newBills;
    }

    @Override
    public Bill[] sortByMoney(Bill... bills) throws ServiceException {

        FinanceServiceImpl.nullCheck(bills);

        Bill[] newBills = getBillsCopy(bills);
        Arrays.sort(newBills, new BillsComparatorByMoney());

        return newBills;
    }

    @Override
    public Bill[] sortByDate(Bill... bills) throws ServiceException {

        FinanceServiceImpl.nullCheck(bills);

        Bill[] newBills = getBillsCopy(bills);
        Arrays.sort(newBills, new BillsComparatorByDate());

        return newBills;
    }

    private Bill[] getBillsCopy(Bill[] bills) {

        Bill[] newBills = new Bill[bills.length];
        System.arraycopy(bills, 0, newBills, 0, bills.length);

        return newBills;
    }


}
