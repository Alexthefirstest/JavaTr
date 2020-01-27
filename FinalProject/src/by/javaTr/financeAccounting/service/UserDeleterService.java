package by.javaTr.financeAccounting.service;

import by.javaTr.financeAccounting.service.exceptions.ServiceException;

public interface UserDeleterService {

    boolean deleteUser(String login) throws ServiceException;

}
