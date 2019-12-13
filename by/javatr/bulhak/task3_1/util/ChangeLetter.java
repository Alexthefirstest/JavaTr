package by.javatr.bulhak.task3_1.util;

public final class ChangeLetter {

    private ChangeLetter() {
    }

    public static String changeLetter(String text, int number, char symbolChangeOn) {

        String[] splitedText = SplitText.splitTextBySpaces(text);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < splitedText.length; i++) {
            result.append(changeLetterInWord(splitedText[i], number, symbolChangeOn)).append(" ");
        }

        return result.toString();
    }

    private static String changeLetterInWord(String word, int number, char symbolChangeOn) {

        if (word.length() < number) {
            return word;
        }

        if (!SymbolCheck.isLater(word.charAt(number-1))) {
            return word;
        }

        StringBuilder sb = new StringBuilder(word);
        String toInsert = "\b" + symbolChangeOn;
        sb.insert(number, toInsert);

        return sb.toString();
    }


}
