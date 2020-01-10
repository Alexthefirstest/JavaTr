package by.javatr.bulhak.task3_2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ChangeLetter {

    private ChangeLetter() {
    }

    public static String changeLetter(String text, int number, char symbolChangeOn) {

        Pattern pattern = Pattern.compile("\\b[A-Z,a-z]{"+number+",}\\b");

        Matcher matcher= pattern.matcher(text);

        while(matcher.find()){
           text=text.replaceAll(matcher.group()," "+matcher.group()+"\b"+symbolChangeOn);
        }

        return text;
    }


}
