package by.javaTr.financeAccounting.service;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;

public interface UserService {

    String userSignIn(String login, String password) throws ServiceException;
    String userSignOut(String login) throws ServiceException;
    boolean userRegistration(String login, String password) throws ServiceException;

    String adminSignIn(String login, String password) throws ServiceException;
    String adminSignOut(String login) throws ServiceException;
    boolean adminRegistration(String login, String password) throws ServiceException;

    User[] getUsers() throws ServiceException;
    User[] getAdmins() throws ServiceException;
}
