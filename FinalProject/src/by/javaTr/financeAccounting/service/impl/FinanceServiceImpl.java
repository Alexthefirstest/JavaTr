package by.javaTr.financeAccounting.service.impl;

import by.javaTr.financeAccounting.bean.Bill;
import by.javaTr.financeAccounting.dao.FinanceDAO;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;
import by.javaTr.financeAccounting.dao.factory.DAOFactory;
import by.javaTr.financeAccounting.service.FinanceService;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;
import java.util.Calendar;

public class FinanceServiceImpl implements FinanceService {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private FinanceDAO financeDAO = daoFactory.getFinanceDAO();

    private Bill[] concatArray(Bill[] arr1, Bill[] arr2) {

        if (arr1 == null) {
            return arr2;
        }
        if (arr2 == null) {
            return arr1;
        }

        Bill[] newArr = Arrays.copyOf(arr1, (arr1.length + arr2.length));
        System.arraycopy(arr2, 0, newArr, arr1.length, arr2.length);

        return newArr;
    }

    @Override
    public boolean addBills(String login, Bill... bills) throws ServiceException {

        if (login == null) {
            throw new ServiceException("login is null");
        }

        FinanceServiceImpl.nullCheck(bills);

        Bill[] oldBills;


        try {

            oldBills = financeDAO.getBillsForMonth(login, bills[0].getDate());

        } catch (DAOException ex) {

            if (ex.getMessage().equals("File not found")) {
                oldBills = null;
            } else {
                throw new ServiceException(ex);
            }

        }


        try {

            return financeDAO.writeBills(login, concatArray(oldBills, bills));

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }

    }

    @Override
    public Bill[] getBillsForPeriod(String login, Date startDate, Date finishDate) throws ServiceException {

        if (startDate == null) {
            throw new ServiceException("startDate is null ");
        }

        if (finishDate == null) {
            throw new ServiceException("finish date is null ");
        }

        if (login == null) {
            throw new ServiceException("login is null");
        }

        Bill[] bills;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        bills = findByDay(startDate, getBillsForMonth(login, calendar.getTime()));
        calendar.set(calendar.MONTH, +1);

        int forFinish = Integer.parseInt(new SimpleDateFormat("MM").format(calendar.getTime()))
                - Integer.parseInt(new SimpleDateFormat("MM").format(startDate));

        for (int i = 0; i < forFinish; i++) {

            try {
                bills = concatArray(financeDAO.getBillsForMonth(login, calendar.getTime()), bills);

            } catch (DAOException ex) {

                if (!ex.getMessage().equals("File not found")) {
                    throw new ServiceException(ex);
                }

            }

            calendar.set(calendar.MONTH, +1);
        }

        bills = concatArray(findByDay(finishDate, getBillsForMonth(login, finishDate)), bills);

        return bills;
    }

    @Override
    public Bill[] getBillsForMonth(String login, Date date) throws ServiceException {

        if (date == null) {
            throw new ServiceException("date is null");
        }

        if (login == null) {
            throw new ServiceException("login is null");
        }


        try {
            return financeDAO.getBillsForMonth(login, date);
        } catch (DAOException ex) {

            if (!ex.getMessage().equals("File not found")) {
                throw new ServiceException(ex);
            }
            return null;
        }

    }

    @Override
    public double getBalance(Bill... bills) throws ServiceException {
        nullCheck(bills);
        double balance = 0;

        for (int i = 0; i < bills.length; i++) {
            balance += bills[i].getMoney();
        }
        return balance;
    }

    @Override
    public double getIncome(Bill... bills) throws ServiceException {
        nullCheck(bills);
        double balance = 0;

        for (int i = 0; i < bills.length; i++) {
            double money = bills[i].getMoney();
            balance += money > 0 ? bills[i].getMoney() : 0;
        }
        return balance;
    }

    @Override
    public double getExpenses(Bill... bills) throws ServiceException {
        nullCheck(bills);
        double balance = 0;

        for (int i = 0; i < bills.length; i++) {
            double money = bills[i].getMoney();
            balance += money > 0 ? bills[i].getMoney() : 0;
        }
        return balance;
    }

    private Bill[] findByDay(Date date, Bill[] bills) {

        if (bills == null) {
            return null;
        }

        Bill[] newBills = new Bill[0];

        String day = new SimpleDateFormat("dd").format(date);

        for (int i = 0; i < bills.length; i++) {

            if ((new SimpleDateFormat("dd").format(bills[i].getDate()).equals(day))) {
                newBills = concatArray(newBills, new Bill[]{bills[i]});
            }

        }

        return newBills;
    }

    static void nullCheck(Bill[] bills) throws ServiceException {

        if (bills == null) {
            throw new ServiceException("bills is null");
        }

        for (int i = 0; i < bills.length; i++) {

            if (bills[i] == null) {
                throw new ServiceException("bill[" + i + "] is null");
            }

        }
    }

}