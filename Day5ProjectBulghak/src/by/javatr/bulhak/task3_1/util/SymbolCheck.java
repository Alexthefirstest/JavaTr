package by.javatr.bulhak.task3_1.util;

public final class SymbolCheck {

    private SymbolCheck() {
    }

    public static boolean isLater(char symbol) {

        int code = symbol;
        if (code >= 65 && code <= 90 || code >= 97 && code <= 122) {
            return true;
        }

        return false;
    }

    public static boolean isSymbol(char regex, char symbol){
        return regex==symbol;
    }

    public static boolean isConsonant(char symbol){

        if(symbol == 'A' ||symbol =='E'||symbol =='I'||symbol =='O'||symbol =='U'||symbol =='W'||symbol =='Y'||symbol =='Z'){
            return false;
        }

        if(symbol == 'a' ||symbol =='e'||symbol =='i'||symbol =='o'||symbol =='u'||symbol =='w'||symbol =='y'||symbol =='z'){
            return false;
        }
        return true;
    }
}
