/*
 *
 *класс считающий во сколько раз площадь описанного квадрата больше площади вписанного
 *
 */

package by.javatr.task3.util;

import by.javatr.task3.util.square.Square;

public class AreaOfExternalSquareDivideIntoAreaOfInnerSquare {

    public static double externalAreaDivideOnInnerArea(Square externalSquare, Square innerSquare){

        return externalSquare.getArea()/innerSquare.getArea();
    }
}
