/*
 *
 *класс описывающий круг
 *
 */

package by.javatr.task3.util.circle;

public class Circle {

    public Circle(double radius) throws RadiusException {

        if(radius<=0){
            throw new RadiusException("радиус не может быть меньше либо равен нулю");
        }

        this.radius=radius;
    }

    private double radius;

    public double getRadius() {
        return radius;
    }
}
