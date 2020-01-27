package by.javaTr.financeAccounting.service.impl.comparators;

import by.javaTr.financeAccounting.bean.Bill;

import java.util.Comparator;

public class BillsComparatorByCategory implements Comparator<Bill> {


    @Override
    public int compare(Bill bill1, Bill bill2) {
        return bill1.getCategory().compareTo(bill2.getCategory());
    }

}
