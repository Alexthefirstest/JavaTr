/*
 *
 *удаление пользователя:
 * -считать в массив
 * -проверить, содержит ли пользователя массив
 * -удалить если содержит
 * -удалить каталог счетов пользователя
 *
 */

package by.javaTr.financeAccounting.service.impl;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.dao.BillsCatalogDeleter;
import by.javaTr.financeAccounting.dao.UserDAO;
import by.javaTr.financeAccounting.dao.UserFinderDAO;
import by.javaTr.financeAccounting.dao.UserRewriterDAO;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;
import by.javaTr.financeAccounting.dao.factory.DAOFactory;
import by.javaTr.financeAccounting.service.UserDeleterService;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;

public class UserDeleterServiceImpl implements UserDeleterService {

    @Override
    public boolean deleteUser(String login) throws ServiceException {


        if (login == null) {
            throw new ServiceException("Text is null");
        }

        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        UserFinderDAO userFinder = DAOFactory.getInstance().getUserFinderDAO();
        UserRewriterDAO userRewriter = DAOFactory.getInstance().getUserRewriter();
        BillsCatalogDeleter billsDeleter = DAOFactory.getInstance().getBillsCatalogDeleter();

        try {

            if (userFinder.findUser(login) == null) {
                return false;
            }

            User[] users = userDAO.getUsers();
            User[] newUsers = new User[users.length - 1];

            int position = AdminDeleterServiceImpl.findUser(login, users);

            if (position == -1) {
                return false;
            }

            System.arraycopy(users, 0, newUsers, 0, position);
            System.arraycopy(users, position + 1, newUsers, position, newUsers.length - position);
            userRewriter.rewriteUsers(newUsers);

            return billsDeleter.deleteUserBillsCatalog(login);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }

    }

}
