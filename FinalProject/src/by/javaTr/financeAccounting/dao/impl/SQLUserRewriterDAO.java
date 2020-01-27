/*
 *
 *  методы для полной перезаписи файла с пользователями
 *
 */

package by.javaTr.financeAccounting.dao.impl;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.dao.UserRewriterDAO;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;

public class SQLUserRewriterDAO implements UserRewriterDAO {

    @Override
    public boolean rewriteUsers(User... newUsers) throws DAOException {
        return SQLUserDAO.addUsersOrAdmins(".\\src\\by\\javaTr\\financeAccounting\\source\\Users.txt",
                false, newUsers);
    }

    @Override
    public boolean rewriteAdmins(User... newUsers) throws DAOException {
        return SQLUserDAO.addUsersOrAdmins(".\\src\\by\\javaTr\\financeAccounting\\source\\Admins.txt",
                false, newUsers);
    }

}
