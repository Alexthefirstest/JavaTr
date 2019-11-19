/*
 *
 *класс описываюищй квадрат
 *
 */

package by.javatr.task3.util.square;

public class Square {

    public Square(double area) throws SquareException {

        if(area<=0){
            throw new SquareException("площадь не может быть меньше или равна нулю");
        }

        this.area=area;
        this.side=Math.sqrt(area);
        this.diagonal=side*Math.sqrt(2);
    }

    private double area;
    private double side;
    private double diagonal;

    public double getArea() {
        return area;
    }

    public double getSide() {
        return side;
    }

    public double getDiagonal() {
        return diagonal;
    }
}
