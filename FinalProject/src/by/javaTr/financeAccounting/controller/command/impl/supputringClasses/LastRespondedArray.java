/*
 *
 * последний отправленный массив
 * изначально равен Null, при первом выводе массива одной из команд, выводящийся массив заносится в этот класс,
 * чтобы после работать с помощью него с методами, которые принимают на вход массив (поиска и сортировки)
 *
 */

package by.javaTr.financeAccounting.controller.command.impl.supputringClasses;

import by.javaTr.financeAccounting.bean.Bill;

public class LastRespondedArray {

    private LastRespondedArray() {
    }

    public static Bill[] billsArray;

    public static Bill[] getBillsArray() {
        return billsArray;
    }

    public static void setBillsArray(Bill[] billsArray) {
        LastRespondedArray.billsArray = billsArray;
    }

}
