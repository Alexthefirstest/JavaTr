package by.javaTr.financeAccounting.service.factory;

import by.javaTr.financeAccounting.service.*;
import by.javaTr.financeAccounting.service.impl.*;

public class ServiceFactory {

    private ServiceFactory() {
    }

    private static final ServiceFactory instance = new ServiceFactory();

    private final AdminDeleterService adminDeleterService = new AdminDeleterServiceImpl();
    private final BillsFinderService billsFinderService = new BillsFinderServiceImpl();
    private final BillsSortingService billsSortingService = new BillsSortingServiceImpl();
    private final FinanceService financeService = new FinanceServiceImpl();
    private final TextEncodeService textEncodeService = new TextEncodeServiceImpl();
    private final UserDeleterService userDeleterService = new UserDeleterServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final UserSortingService userSortingService = new UserSortingServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AdminDeleterService getAdminDeleterService() {
        return adminDeleterService;
    }

    public BillsFinderService getBillsFinderService() {
        return billsFinderService;
    }

    public BillsSortingService getBillsSortingService() {
        return billsSortingService;
    }

    public FinanceService getFinanceService() {
        return financeService;
    }

    public TextEncodeService getTextEncodeService() {
        return textEncodeService;
    }

    public UserDeleterService getUserDeleterService() {
        return userDeleterService;
    }

    public UserService getUserService() {
        return userService;
    }

    public UserSortingService getUserSortingService() {
        return userSortingService;
    }
}
