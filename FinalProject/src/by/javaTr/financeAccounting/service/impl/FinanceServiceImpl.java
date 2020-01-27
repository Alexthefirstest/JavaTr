/*
 *
 * методы добавления счета пользователя
 * получения счетов за месяц и за выбранный период
 *
 *
 */

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

    /*объединяет два массива, не выбрасывает exception если null*/
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

    /*добавление счета через десериализацию, добавление в массив, сериализацию обратно в файл*/
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

        bills = findByDaysInStartMonth(startDate, getBillsForMonth(login, calendar.getTime()));

        calendar.add(calendar.MONTH, +1);

        SimpleDateFormat mouthForm = new SimpleDateFormat("MM");
        SimpleDateFormat yearsForm = new SimpleDateFormat("yyyy");

        while (Integer.parseInt(mouthForm.format(calendar.getTime())) != Integer.parseInt(mouthForm.format(finishDate))
                && Integer.parseInt(yearsForm.format(calendar.getTime())) != Integer.parseInt(yearsForm.format(finishDate))) {

            try {

                bills = concatArray(financeDAO.getBillsForMonth(login, calendar.getTime()), bills);

            } catch (DAOException ex) {

                if (!ex.getMessage().equals("File not found")) {
                    throw new ServiceException(ex);
                }

            }

            calendar.add(calendar.MONTH, +1);
        }

        bills = concatArray(findByDaysInFinishMonth(finishDate, getBillsForMonth(login, finishDate)), bills);

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
            balance += money < 0 ? bills[i].getMoney() : 0;
        }

        return balance;
    }

    /*метод для помощи поиску в указанном диапазоне - ищет в первом месяце совпадения по дням после указаннного*/
    private Bill[] findByDaysInStartMonth(Date date, Bill[] bills) {

        if (bills == null) {
            return null;
        }

        Bill[] newBills = new Bill[0];
        SimpleDateFormat daysForm = new SimpleDateFormat("dd");

        for (int i = 0; i < bills.length; i++) {


            if (Integer.parseInt(daysForm.format(bills[i].getDate())) >= Integer.parseInt(daysForm.format(date))) {
                newBills = concatArray(newBills, new Bill[]{bills[i]});
            }

        }

        return newBills;
    }

    /*метод для помощи поиску в указанном диапазоне - ищет в последнем месяце совпадения по дням перед указаннным*/
    private Bill[] findByDaysInFinishMonth(Date date, Bill[] bills) {

        if (bills == null) {
            return null;
        }

        Bill[] newBills = new Bill[0];
        SimpleDateFormat daysForm = new SimpleDateFormat("dd");

        for (int i = 0; i < bills.length; i++) {

            if (Integer.parseInt(daysForm.format(bills[i].getDate())) <= Integer.parseInt(daysForm.format(date))) {
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