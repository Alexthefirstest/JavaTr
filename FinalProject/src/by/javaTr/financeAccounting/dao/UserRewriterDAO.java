package by.javaTr.financeAccounting.dao;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;

public interface UserRewriterDAO  {

    boolean rewriteAdmins(User...newUsers) throws DAOException;

    boolean rewriteUsers(User...newUsers) throws DAOException;

}
