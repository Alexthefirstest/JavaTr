/*
 *
 *  содержит методы для записи счетов в файл(сериализация) - в файле счета за месяц
 * и полуаения из файла счтеа за месяц
 *
 */

package by.javaTr.financeAccounting.dao.impl;

import by.javaTr.financeAccounting.bean.Bill;
import by.javaTr.financeAccounting.dao.FinanceDAO;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLFinanceDAO implements FinanceDAO {

    /*создание директории для файла*/
    private File createFileDirectory(String login, Date date) {

        String strDate = new String(new SimpleDateFormat("\\MM_yyyy").format(date) + ".ser");
        String directory = new String(".\\src\\by\\javaTr\\financeAccounting\\source\\bills\\"
                + login + strDate);

        return new File(directory);
    }

    @Override
    public boolean writeBills(String login, Bill... bills) throws DAOException {

        File file = createFileDirectory(login, bills[0].getDate());

        if (!file.exists()) {

            try {

                file.createNewFile();

            } catch (Exception ex) {
                throw new DAOException(ex);
            }

        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(bills);

        } catch (FileNotFoundException ex) {
            throw new DAOException("File not found", ex);
        } catch (IOException ex) {
            throw new DAOException(ex);
        }

        return true;
    }

    @Override
    public Bill[] getBillsForMonth(String login, Date date) throws DAOException {

        Bill[] bills;

        File file = createFileDirectory(login, date);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            bills = (Bill[]) ois.readObject();

        } catch (FileNotFoundException ex) {
            throw new DAOException("File not found", ex);
        } catch (IOException ex) {
            throw new DAOException(ex);
        } catch (ClassNotFoundException e) {
            throw new DAOException(e);
        }

        return bills;
    }

}
