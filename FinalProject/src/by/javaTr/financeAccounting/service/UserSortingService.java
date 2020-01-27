package by.javaTr.financeAccounting.service;

import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;

public interface UserSortingService {

    User[] sortingByName(User...users) throws ServiceException;

}
