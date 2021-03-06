/*
 *
 * -регистрация пользователей
 * -вход в систему пользователей
 *
 */


package by.javaTr.financeAccounting.service.impl;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.dao.UserDAO;
import by.javaTr.financeAccounting.dao.UserFinderDAO;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;
import by.javaTr.financeAccounting.dao.factory.DAOFactory;
import by.javaTr.financeAccounting.service.UserService;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;

import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
    private UserFinderDAO userFinder = DAOFactory.getInstance().getUserFinderDAO();

    /*проверка тектста на соответствие шаблону(допустимы только буквы, цифры и нижнее подчеркивание*/
    private void isLoginOk(String text) throws ServiceException {

        if (text == null) {
            throw new ServiceException("login is null");
        }

        if (!Pattern.matches("\\w+", text)) {

            throw new ServiceException("wrong syntax");

        }
    }

    /*
     *проверка, есть ли пытающийя войти в систему пользователь в источнике данных и совпадают ли вводимый и
     *
     * заданный пароли
     *
     */
    private String userExistCheck(String login, String password, boolean findAdmin) throws ServiceException {


        if (password == null) {
            throw new ServiceException("password is null");
        }

        try {

            User user = findAdmin ? userFinder.findAdmin(login) : userFinder.findUser(login);

            if (user == null || !user.getPassword().equals(password)) {
                throw new ServiceException("Wrong login or password");
            }

        } catch (DAOException ex) {
            throw new ServiceException(ex.getMessage(),ex);
        }

        return login;
    }

    @Override
    public String userSignIn(String login, String password) throws ServiceException {

        isLoginOk(login);
        return userExistCheck(login, password, false);
    }

    @Override
    public boolean userRegistration(String login, String password) throws ServiceException {

        isLoginOk(login);
        if (login == null) {
            throw new ServiceException("login is null");
        }

        if (password == null) {
            throw new ServiceException("password is null");
        }

        try {

            if (userFinder.findUser(login) == null) {
                return userDAO.addUser(new User(login, password));
            }

        } catch (DAOException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }

        return false;
    }

    @Override
    public String adminSignIn(String login, String password) throws ServiceException {

        if (login == null) {
            throw new ServiceException("login is null");
        }

        if (password == null) {
            throw new ServiceException("password is null");
        }

        return userExistCheck(login, password, true);
    }


    @Override
    public boolean adminRegistration(String login, String password) throws ServiceException {

        if (login == null) {
            throw new ServiceException("login is null");
        }

        if (password == null) {
            throw new ServiceException("password is null");
        }

        try {

            if (userFinder.findAdmin(login) == null) {
                return userDAO.addAdmin(new User(login, password));
            }

        } catch (DAOException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }

        return false;
    }

    @Override
    public User[] getUsers() throws ServiceException {

        try {
            return userDAO.getUsers();
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }

    }

    @Override
    public User[] getAdmins() throws ServiceException {

        try {
            return userDAO.getAdmins();
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }

    }


}
