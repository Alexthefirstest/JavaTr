package by.javaTr.financeAccounting.controller.conditions;

public enum Conditions {

    ADMIN, USER, EMPTY;

    public static Conditions conditionHolder = Conditions.EMPTY;

    public static boolean checkCondition(Conditions condition) {
        return condition == conditionHolder;
    }

    public static Conditions setCondition(Conditions condition) {
        conditionHolder = condition;
        return conditionHolder;
    }

}
