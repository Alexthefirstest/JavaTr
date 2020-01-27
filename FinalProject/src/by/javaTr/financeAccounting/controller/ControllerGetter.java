package by.javaTr.financeAccounting.controller;

public final class ControllerGetter {

    private ControllerGetter() {
    }

    private static final Controller instance = new Controller();

    public static Controller getInstance() {
        return instance;
    }

}
