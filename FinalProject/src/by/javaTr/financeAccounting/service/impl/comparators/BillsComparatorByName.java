package by.javaTr.financeAccounting.service.impl.comparators;

import by.javaTr.financeAccounting.bean.Bill;

import java.util.Comparator;

public final class BillsComparatorByName implements Comparator<Bill> {


    @Override
    public int compare(Bill bill1, Bill bill2) {
        return bill1.getName().compareTo(bill2.getName());
    }

}
