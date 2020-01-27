package by.javaTr.financeAccounting.dao.factory;

import by.javaTr.financeAccounting.dao.BillsCatalogDeleter;
import by.javaTr.financeAccounting.dao.FinanceDAO;
import by.javaTr.financeAccounting.dao.UserDAO;
import by.javaTr.financeAccounting.dao.UserFinderDAO;
import by.javaTr.financeAccounting.dao.impl.*;

public final class DAOFactory {

    private DAOFactory() {
    }

    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO sqlUserDAOImpl = new SQLUserDAO();
    private final UserFinderDAO sqlUserFinderDAOImpl = new SQLUserFinderDAO();
    private final SQLUserRewriterDAO sqlUserRewriterDAOImpl = new SQLUserRewriterDAO();

    private final FinanceDAO sqlFinanceDAOImpl = new SQLFinanceDAO();
    private final BillsCatalogDeleter sqlBillsCatalogDeleter = new SQLBillsCatalogDeleter();

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return sqlUserDAOImpl;
    }

    public UserFinderDAO getUserFinderDAO() {
        return sqlUserFinderDAOImpl;
    }

    public SQLUserRewriterDAO getUserRewriter() {
        return sqlUserRewriterDAOImpl;
    }

    public FinanceDAO getFinanceDAO() {
        return sqlFinanceDAOImpl;
    }

    public BillsCatalogDeleter getBillsCatalogDeleter() {
        return sqlBillsCatalogDeleter;
    }

}
