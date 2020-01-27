package by.javaTr.financeAccounting.dao;

import by.javaTr.financeAccounting.bean.Bill;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;

import java.util.Date;

public interface FinanceDAO {


    boolean writeBills(String login, Bill... bill) throws DAOException;

    Bill[] getBillsForMonth(String login, Date date) throws DAOException;

}
