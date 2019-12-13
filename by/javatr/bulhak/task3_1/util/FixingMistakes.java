package by.javatr.bulhak.task3_1.util;

public final class FixingMistakes {

    private FixingMistakes() {

    }

    public static String replacePaOnPo(String text) {

        String[] splitedText = SplitText.splitTextBySpaces(text);
        StringBuilder result = new StringBuilder();
        StringBuilder word;

        for (int i = 0; i < splitedText.length; i++) {

            word = new StringBuilder(splitedText[i]);

            for (int j = 0; j < word.length() - 1; j++) {


                if (word.charAt(j) == 'P' && (word.charAt(j + 1) == 'A')) {
                    word.insert(j + 2, "\b\bPO");
                }

            }
            result.append(word).append(" ");

        }

        return result.toString();
    }


}
