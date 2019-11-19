/*
 *
 *класс находящий площадь вписанного квадрата и
 * во сколько раз площадь описанного квадрата больше площади вписанного
 *
 */

package by.javatr.task3.util;

import by.javatr.task3.util.circle.Circle;
import by.javatr.task3.util.circle.RadiusException;
import by.javatr.task3.util.square.Square;
import by.javatr.task3.util.square.SquareException;

public class AreaOfInnerSquareAndDifferenceBetweenAreaFinder {

    public static double[] findAreaAndDifference(double area) throws SquareException, RadiusException {

        double[] result = new double[2];

        Square externalSquare = new Square(area);
        Circle circle = CirclePutInSquareGetter.circleGetter(externalSquare);
        Square innerSquare= SquarePutInCircleGetter.squareGetter(circle);

        result[0]=innerSquare.getArea();
        result[1]=AreaOfExternalSquareDivideIntoAreaOfInnerSquare.externalAreaDivideOnInnerArea
                (externalSquare, innerSquare);

        return result;
    }

}
