package by.javaTr.financeAccounting.controller;

import by.javaTr.financeAccounting.controller.command.Command;
import by.javaTr.financeAccounting.controller.command.CommandName;
import by.javaTr.financeAccounting.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.ADD_BILL, new AddBill());
        repository.put(CommandName.ADMIN_REGISTRATION, new AdminRegistration());
        repository.put(CommandName.ADMIN_SIGN_IN, new AdminSignIn());
        repository.put(CommandName.ADMIN_SIGN_OUT, new AdminSignOut());
        repository.put(CommandName.BILLS_FIND_BY_CATEGORY, new BillsFindByCategory());
        repository.put(CommandName.BILLS_FIND_BY_NAME, new BillsFindByName());
        repository.put(CommandName.BILLS_SORT_BY_BALANCE, new BillsSortByBalance());
        repository.put(CommandName.BILLS_SORT_BY_CATEGORY, new BillsSortByCategory());
        repository.put(CommandName.BILLS_SORT_BY_DATE, new BillsSortByDate());
        repository.put(CommandName.BILLS_SORT_BY_NAME, new BillsSortByName());
        repository.put(CommandName.DELETE_ADMIN, new DeleteAdmin());
        repository.put(CommandName.DELETE_USER, new DeleteUser());
        repository.put(CommandName.GET_BILLS_FOR_MONTH, new GetBillsForMonth());
        repository.put(CommandName.GET_BILLS_FOR_PERIOD, new GetBillsByPeriod());
        repository.put(CommandName.PRINT_ADMIN_LIST, new PrintAdminList());
        repository.put(CommandName.PRINT_USERS_LIST, new PrintUsersList());
        repository.put(CommandName.USER_REGISTRATIONS, new UserRegistrations());
        repository.put(CommandName.USER_SIGN_IN, new UserSignIn());
        repository.put(CommandName.USER_SIGN_OUT, new UserSignOut());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());


    }

    Command getCommand(String name) {
        CommandName commandName;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            return repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException ex) {

            return repository.get(CommandName.WRONG_REQUEST);
        }

    }

}
