package by.javaTr.financeAccounting.service;

import by.javaTr.financeAccounting.service.exceptions.ServiceException;

public interface TextEncodeService {

    String encode(String text) throws ServiceException;

}
