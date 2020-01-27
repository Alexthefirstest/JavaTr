package by.javaTr.financeAccounting.controller.conditions;

public enum Conditions {

    Admin, User, Empty;

    public static Conditions conditionHolder = Conditions.Empty;

    public static boolean checkCondition(Conditions condition) {
        return condition == conditionHolder;
    }

    public static Conditions setCondition(Conditions condition) {
        conditionHolder = condition;
        return conditionHolder;
    }

}
