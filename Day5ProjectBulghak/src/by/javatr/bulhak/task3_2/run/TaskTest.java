package by.javatr.bulhak.task3_2.run;

import by.javatr.bulhak.task3_2.util.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TaskTest {

    public static void main(String[] args) {

        System.out.println(ChangeLetter.changeLetter("big, big bird falling", 4, 'Q'));
        System.out.println(FixingMistakes.replacePaOnPo("PAPA , PAlle lePA  lePALe"));
        System.out.println(ChangeWords.changeWordsWithFixedLength("word, lalala word word", 4, "AAA"));
        System.out.println
                (DeleteSymbolsBesidesLettersAndSpaces.deleteSymbolsBesidesLettersAndSpaces("big, big bird falling:("));
        System.out.println(ConsonantFirsdLetterFixedLengthWordsDelete.deleteWordFixedLengthFirstLetterConsonant(
                "delete some kord, words adla", 4));
    }


    public static String readFromFile(String FileAddress) {

        StringBuilder textToAdd = new StringBuilder();
        if (textToAdd == null) {
            System.out.println("текст не задан");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FileAddress))) {

            String line;
            while ((line = br.readLine()) != null) {
                textToAdd.append(line).append("\n");
            }

            return textToAdd.toString();
        } catch (FileNotFoundException ex) {
            System.out.println("файл не найден");
        } catch (IOException | NumberFormatException ex) {
            System.out.println("файл неверно заполнен");
        }
        return "";
    }


    public static String AddElementsFromKeyboard() {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String line = in.nextLine();
        return line;
    }
}
