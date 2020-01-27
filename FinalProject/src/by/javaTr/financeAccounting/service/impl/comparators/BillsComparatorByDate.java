package by.javaTr.financeAccounting.service.impl.comparators;

import by.javaTr.financeAccounting.bean.Bill;

import java.util.Comparator;

public class BillsComparatorByDate implements Comparator<Bill> {

    @Override
    public int compare(Bill bill1, Bill bill2) {
        return bill1.getDate().after(bill2.getDate()) ? 1 : bill1.getDate().before(bill2.getDate()) ? -1 : 0;
    }
}
