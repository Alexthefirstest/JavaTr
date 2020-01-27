/*
 *
 *метды поиска счетов, среди переданных в параметре
 *
 */

package by.javaTr.financeAccounting.service.impl;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.dao.UserDAO;
import by.javaTr.financeAccounting.dao.UserFinderDAO;
import by.javaTr.financeAccounting.dao.UserRewriterDAO;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;
import by.javaTr.financeAccounting.dao.factory.DAOFactory;
import by.javaTr.financeAccounting.service.AdminDeleterService;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;

public class AdminDeleterServiceImpl implements AdminDeleterService {

    static int findUser(String login, User[] users) {

        for (int i = 0; i < users.length; i++) {

            if (users[i].getLogin().equals(login)) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public boolean deleteAdmin(String login) throws ServiceException {

        if (login == null) {
            throw new ServiceException("login is null");
        }

        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        UserFinderDAO userFinder = DAOFactory.getInstance().getUserFinderDAO();
        UserRewriterDAO userRewriter = DAOFactory.getInstance().getUserRewriter();

        try {

            if (userFinder.findAdmin(login) == null) {
                return false;
            }

            User[] users = userDAO.getAdmins();
            User[] newUsers = new User[users.length - 1];

            int position = findUser(login, users);

            if(position==-1){
                return false;
            }

            System.arraycopy(users, 0, newUsers, 0, position);
            System.arraycopy(users, position + 1, newUsers, position, newUsers.length - position);
            userRewriter.rewriteAdmins(newUsers);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return true;
    }

}
