package by.javatr.bulhak.task1.util.entity;

import by.javatr.bulhak.task1.util.exceptions.WrongElementsQuantity;
import by.javatr.bulhak.task1.util.exceptions.WrongLinkException;
import by.javatr.bulhak.task1.util.exceptions.WrongPosition;

public class Array {

    private int[] array;
    private int realSize;

    public Array() {
        array = new int[0];
        realSize = 0;
    }

    public Array(int quantity) throws WrongElementsQuantity {

        if (quantity < 0) {
            throw new WrongElementsQuantity("количество элементов не может быть меньше нуля");
        }

        array = new int[quantity];
        realSize = quantity;
    }

    public Array(int... elements) {
        array = elements;
        realSize = elements.length;
    }

    public int getLength() {
        return realSize;
    }

    public boolean setElement(int element, int position) throws WrongPosition {

        if (position > realSize - 1 || position < 0) {
            throw new WrongPosition("позиция задана неверно");
        }

        array[position] = element;
        return true;
    }

    public int getElement(int position) throws WrongPosition {

        if (position > realSize - 1 || position < 0) {
            throw new WrongPosition("позиция задана неверно");
        }

        return this.array[position];
    }

    public boolean addElement(int element) {

        if (realSize == array.length) {
            int[] oldArray = array;
            array = new int[oldArray.length + 20];
            fullArrayCopy(oldArray, array, realSize);
        }

        try {
            realSize++;
            setElement(element, realSize - 1);
            return true;
        } catch (WrongPosition ex) {
            return false;
        }
    }

    public boolean deleteElement(int position) {

        try {
            getElement(position);
        } catch (WrongPosition ex) {
            return false;
        }

        realSize--;

        for (int i = position; i < realSize; i++) {
            array[i] = array[i + 1];
        }


        if (realSize < array.length - 30) {
            int[] oldArray = array;
            array = new int[oldArray.length - 15];
            fullArrayCopy(oldArray, array, realSize);
        }

        return true;
    }

    private void fullArrayCopy(int[] from, int[] to, int realSize) {

        for (int i = 0; i < realSize; i++) {
            to[i] = from[i];
        }

    }

    public boolean FullArrayCopy(Array from, Array to) throws WrongLinkException, WrongElementsQuantity {

        if (from == null) {
            throw new WrongLinkException("отправной массив не задан");
        }

        if (to == null) {
            throw new WrongLinkException("конечный массив не задан");
        }

        if (from.getLength() < to.getLength()) {
            throw new WrongElementsQuantity("размер конечного массива должен быть больше либо равен размеру отправного");
        }

        try {

            for (int i = 0; i < from.getLength(); i++) {
                setElement(from.getElement(i), i);
            }

        } catch (WrongPosition ex) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        int result = 0;

        for (int i = 0; i < realSize; i++) {
            result = 31 * array[i];
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Array array = (Array) obj;

        if (getLength() != array.getLength()) {
            return false;
        }

        try {

            for (int i = 0; i < realSize; i++) {

                if (getElement(i) != array.getElement(i)) {
                    return false;
                }

            }

            return true;

        } catch (Exception ex) {
            return false;
        }

    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        result.append(getClass().getName()).append("[");

        int i;

        for (i = 0; i < realSize; i++) {
            result.append(array[i]).append(", ");
        }

        if (i == 0) {
            return result.append("]").toString();
        }

        result.append("\b\b").append("]");

        return result.toString();
    }

    public String elementsToString() {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < realSize; i++) {
            result.append(array[i]).append(", ");
        }

        return result.append("\b\b").toString();
    }

    public boolean isEmpty() {
        return realSize == 0;
    }

}