/*
 *
 *класс создающий квадрат вписанный в заданную окружность
 *
 */

package by.javatr.task3.util;

import by.javatr.task3.util.circle.Circle;
import by.javatr.task3.util.square.Square;
import by.javatr.task3.util.square.SquareException;

public class SquarePutInCircleGetter {

    public static Square squareGetter(Circle circle) throws SquareException {
        System.out.println(circle.getRadius());
        return new Square(Math.pow((circle.getRadius() * Math.sqrt(2)), 2));

    }
}
