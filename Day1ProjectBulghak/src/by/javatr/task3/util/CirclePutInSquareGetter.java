/*
 *
 *класс создающий огружность вписанную в заданный квадрат
 *
 */

package by.javatr.task3.util;

import by.javatr.task3.util.circle.Circle;
import by.javatr.task3.util.circle.RadiusException;
import by.javatr.task3.util.square.Square;

public class CirclePutInSquareGetter {

    public static Circle circleGetter(Square square) throws RadiusException {

        return new Circle(square.getSide()/2);

    }
}
