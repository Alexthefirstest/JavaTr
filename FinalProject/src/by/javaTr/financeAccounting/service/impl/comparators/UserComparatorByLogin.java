package by.javaTr.financeAccounting.service.impl.comparators;

import by.javaTr.financeAccounting.bean.User;

import java.util.Comparator;

public class UserComparatorByLogin implements Comparator<User> {


    @Override
    public int compare(User user1, User user2) {
        return user1.getLogin().compareTo(user2.getLogin());
    }

}
