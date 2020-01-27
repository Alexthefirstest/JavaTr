package by.javaTr.financeAccounting.service;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;

public interface UserFindereService {

    User findUser(String login) throws ServiceException;
    User findAdmin(String login) throws ServiceException;

}
