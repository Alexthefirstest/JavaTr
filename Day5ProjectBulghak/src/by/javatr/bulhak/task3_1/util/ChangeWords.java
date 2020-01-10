package by.javatr.bulhak.task3_1.util;

public final class ChangeWords {

    private ChangeWords() {

    }

    public static String changeWordsWithFixedLength(String text, int length, String newPhrase) {

        String[] words = SplitText.splitTextBySpaces(text);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            if (SymbolCheck.isLater(words[i].charAt(words[i].length() - 1))) {

                if (length == words[i].length()) {
                    result.append(newPhrase).append(" ");
                } else result.append(words[i]).append(" ");

            } else if (length == words[i].length() - 1) {
                result.append(newPhrase).append(" ");
            } else {
                result.append(words[i]).append(" ");
            }

        }

        return result.toString();
    }

}