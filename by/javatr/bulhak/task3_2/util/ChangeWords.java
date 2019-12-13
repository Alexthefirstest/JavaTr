package by.javatr.bulhak.task3_2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ChangeWords {

    private ChangeWords() {

    }

    public static String changeWordsWithFixedLength(String text, int length, String newPhrase) {

        Pattern pattern = Pattern.compile("\\b[A-Z,a-z]{"+length+"}\\b");

        Matcher matcher= pattern.matcher(text);

        while(matcher.find()){
            text=text.replaceAll(matcher.group()," "+newPhrase);
        }

        return text;
    }

}