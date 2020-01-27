package by.javaTr.financeAccounting.service.impl.comparators;

import by.javaTr.financeAccounting.bean.Bill;

import java.util.Comparator;

public class BillsComparatorByMoney implements Comparator<Bill> {


    @Override
    public int compare(Bill o1, Bill o2) {
        return o1.getMoney() < o2.getMoney() ? -1 : o1.getMoney() == o2.getMoney() ? 0 : 1;
    }
}
