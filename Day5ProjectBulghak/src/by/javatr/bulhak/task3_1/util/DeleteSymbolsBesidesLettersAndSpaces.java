package by.javatr.bulhak.task3_1.util;

public final class DeleteSymbolsBesidesLettersAndSpaces {

    private DeleteSymbolsBesidesLettersAndSpaces() {
    }

    public static String deleteSymbolsBesidesLettersAndSpaces(String text) {

        String[] words = SplitText.splitTextBySpaces(text);
        StringBuilder result = new StringBuilder();
        StringBuilder word;

        for (int i = 0; i < words.length; i++) {

            word = new StringBuilder(words[i]);

            for (int j = 0; j < word.length(); j++) {

                if (!SymbolCheck.isLater(word.charAt(j))) {
                    word.deleteCharAt(j);
                    j--;
                }

            }
            result.append(word).append(" ");

        }
        return result.toString();
    }

}
