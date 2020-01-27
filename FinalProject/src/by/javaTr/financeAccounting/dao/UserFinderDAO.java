package by.javaTr.financeAccounting.dao;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;

public interface UserFinderDAO {

    User findUser(String login) throws DAOException;

    User findAdmin(String login) throws DAOException;

}
