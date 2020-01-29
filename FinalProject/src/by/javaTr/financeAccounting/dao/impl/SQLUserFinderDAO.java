/*
 *
 *  методы поиска конкретного польвателя путем проверки файла на его наличие
 *
 */

package by.javaTr.financeAccounting.dao.impl;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.dao.UserFinderDAO;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SQLUserFinderDAO implements UserFinderDAO {


    private User findUserOrAdmin(String login, String directory) throws DAOException {

        try (BufferedReader bf = new BufferedReader(new FileReader(directory))) {

            String line = null;
            String[] userData;

            while ((line = bf.readLine()) != null) {
                userData = line.split("/");

                if (login.equals(userData[0])) {
                    return new User(userData[0], userData[1]);
                }

            }

        } catch (FileNotFoundException ex) {
            throw new DAOException("File not found", ex);
        } catch (IOException ex) {
            throw new DAOException("IOException", ex);
        }

        return null;
    }

    @Override
    public User findUser(String login) throws DAOException {
        return findUserOrAdmin(login, getClass().getResource("").getPath() + ("..\\..\\source\\Users.txt"));
    }

    @Override
    public User findAdmin(String login) throws DAOException {
        return findUserOrAdmin(login, getClass().getResource("").getPath() + ("..\\..\\source\\Admins.txt"));
    }

}
