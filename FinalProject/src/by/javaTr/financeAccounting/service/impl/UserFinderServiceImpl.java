package by.javaTr.financeAccounting.service.impl;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.dao.UserFinderDAO;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;
import by.javaTr.financeAccounting.dao.factory.DAOFactory;
import by.javaTr.financeAccounting.service.UserFindereService;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;

public class UserFinderServiceImpl implements UserFindereService {

    private UserFinderDAO userFinder = DAOFactory.getInstance().getUserFinderDAO();

    @Override
    public User findUser(String login) throws ServiceException {

        if (login == null) {
            throw new ServiceException("Text is null");
        }

        try {
            return userFinder.findUser(login);
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public User findAdmin(String login) throws ServiceException {

        if (login == null) {
            throw new ServiceException("Text is null");
        }

        try {
            return userFinder.findAdmin(login);
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
    }
}
