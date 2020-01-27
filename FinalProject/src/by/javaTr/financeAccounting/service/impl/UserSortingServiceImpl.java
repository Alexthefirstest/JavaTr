package by.javaTr.financeAccounting.service.impl;


import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.service.UserSortingService;
import by.javaTr.financeAccounting.service.exceptions.ServiceException;
import by.javaTr.financeAccounting.service.impl.comparators.UserComparatorByLogin;

import java.util.Arrays;

public class UserSortingServiceImpl implements UserSortingService {


    @Override
    public User[] sortingByName(User... users) throws ServiceException {

        if (users == null) {
            throw new ServiceException("users is null");
        }

        for (int i = 0; i < users.length; i++) {

            if (users[i] == null) {
                throw new ServiceException("user[" + i + "] is null");
            }

        }

        User[] newUsers = new User[users.length];
        System.arraycopy(users, 0, newUsers, 0, users.length);
       Arrays.sort(newUsers, new UserComparatorByLogin());

        return newUsers;
    }

}
