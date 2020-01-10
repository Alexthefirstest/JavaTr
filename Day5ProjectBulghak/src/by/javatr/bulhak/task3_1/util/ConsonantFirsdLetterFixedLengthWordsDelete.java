package by.javatr.bulhak.task3_1.util;

public final class ConsonantFirsdLetterFixedLengthWordsDelete {

    private ConsonantFirsdLetterFixedLengthWordsDelete() {

    }

    public static String deleteWordFixedLengthFirstLetterConsonant(String text, int length) {

        String[] words = SplitText.splitTextBySpaces(text);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            int wordLength=SymbolCheck.isLater(words[i].charAt(words[i].length() - 1)) ?words[i].length()
                    :words[i].length()-1;

            if (wordLength != length || !SymbolCheck.isConsonant(words[i].charAt(0))) {

                result.append(words[i]).append(" ");
            }


        }

        return result.toString();
    }


}
