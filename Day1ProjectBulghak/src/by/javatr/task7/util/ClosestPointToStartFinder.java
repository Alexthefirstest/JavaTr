/*
 *
 *поиск ближайшей к началу координат точке
 *
 */


package by.javatr.task7.util;

public class ClosestPointToStartFinder {

    private static double distanceFromStartFinder(double x, double y) {

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

    }

    public static int closestFromTwoPointFinder(double x1, double y1, double x2, double y2) {

        double distanceFromStart1 = distanceFromStartFinder(x1, y1);
        double distanceFromStart2 = distanceFromStartFinder(x2, y2);

        if (distanceFromStart1 == distanceFromStart2) {
            return 0;
        }

        if (distanceFromStart1 < distanceFromStart2) {
            return 1;
        }

        return -1;
    }

}
