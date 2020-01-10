package by.javatr.bulhak.task3_2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ConsonantFirsdLetterFixedLengthWordsDelete {

    private ConsonantFirsdLetterFixedLengthWordsDelete() {

    }

    public static String deleteWordFixedLengthFirstLetterConsonant(String text, int length) {

        Pattern pattern = Pattern.compile("\\b([A-Z,a-z])[A-Z,a-z]{"+(length-1)+"}\\b");

        Matcher matcher= pattern.matcher(text);

        while(matcher.find()){

            if(!Pattern.matches("[AEIOUWYaeiouwy]", matcher.group(1))) {
                text = text.replaceAll(matcher.group(), "");
            }
        }

        return text;
    }


}
