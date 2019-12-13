package by.javatr.bulhak.task3_1.util;

public final class SplitText {

    private SplitText(){}

    public static String[] splitTextBySpaces(String text){

        return text.split(" ");
    }


    public static String[] splitTextOnLaters(String text){

        return text.split("");
    }

}
