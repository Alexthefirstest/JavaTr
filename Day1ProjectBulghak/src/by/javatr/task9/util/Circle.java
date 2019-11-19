/*
 *
 *класс описывающий круг
 *
 */

package by.javatr.task9.util;

public class Circle {

    public Circle(double radius) throws RadiusException {

        if (radius <= 0) {
            throw new RadiusException("радиус не может быть меньше либо равен нулю");
        }

        this.radius = radius;
        squareOfCircle = 3.14 * radius * radius;
        lengthOfCircle = 2 * 3.14 * radius;

    }

    private double radius;
    private double squareOfCircle;
    private double lengthOfCircle;

    public double getRadius() {
        return radius;
    }

    public double getSquareOfCircle() {
        return squareOfCircle;
    }

    public double getLengthOfCircle() {
        return lengthOfCircle;
    }
}
