package by.javatr.bulhak.task3_2.util;

public final class DeleteSymbolsBesidesLettersAndSpaces {

    private DeleteSymbolsBesidesLettersAndSpaces() {
    }

    public static String deleteSymbolsBesidesLettersAndSpaces(String text) {

        return text.replaceAll("[^A-Za-z\\s]", "");
    }

}
