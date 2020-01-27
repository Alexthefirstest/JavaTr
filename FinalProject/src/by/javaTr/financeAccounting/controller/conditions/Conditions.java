/*
 *
 * переменная класса принимает одно из трех значений
 *
 * при входе в систему устанавливается USER или ADMIN в зависимости от вошедшего
 *
 * каждый метод(кроме регистрации и входа в систему), проверяет методом checkCondition,
 * может ли вошедший в систему вызывать его, если нет - возвзращает соответствующий ответ
 *
 * изначально и при выходе из системы(методы sign out) значения устанавливается = EMPTY
 *
 */

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
