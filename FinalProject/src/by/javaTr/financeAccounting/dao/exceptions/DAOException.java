package by.javaTr.financeAccounting.dao.exceptions;

public class DAOException extends Exception {

    public DAOException(){

    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception ex) {
        super(ex);
    }

    public DAOException(String message, Exception ex) {
        super(message, ex);
    }
}
