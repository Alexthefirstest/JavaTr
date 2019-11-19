/*
 *
 *перевод времени из секунд в формат: часы:минуты:секунды
 *
 */

package by.javatr.task6.util;

public class DayTimeInSecondsToClassicTIme {

    public static String convertSecondsToClassicTime(int seconds) throws TimeException {

        if(seconds<0 || seconds>86400){
            throw new TimeException("wrong time");
        }

        String classicTime;
        int hours;
        int minutes;

        hours=SecondsToTime.secondsToHours(seconds);
        seconds-=(hours*60*60);

        minutes = SecondsToTime.secondsToMinutes(seconds);
        seconds-=(minutes*60);

        classicTime=String.format("%02d:%02d:%02d",hours,minutes,seconds);
        return classicTime;
    }

}
