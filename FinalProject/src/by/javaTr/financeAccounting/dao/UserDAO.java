package by.javaTr.financeAccounting.dao;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;

public interface UserDAO {

    boolean addUser(User user) throws DAOException;

    User[] getUsers() throws DAOException;

    boolean addAdmin(User user) throws DAOException;

    User[] getAdmins() throws DAOException;
}
