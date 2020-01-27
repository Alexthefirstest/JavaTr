package by.javaTr.financeAccounting.service;

import by.javaTr.financeAccounting.service.exceptions.ServiceException;


public interface AdminDeleterService {

    boolean deleteAdmin(String login) throws ServiceException;

}
