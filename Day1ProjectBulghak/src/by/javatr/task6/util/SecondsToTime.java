/*
 *
 *методы перевода секунд в часы и минуты
 *
 */

package by.javatr.task6.util;

public class SecondsToTime {

    public static int secondsToHours(int seconds){

        return seconds/(60*60);
    }

    public static int secondsToMinutes(int seconds){

        return seconds/60;
    }

}
