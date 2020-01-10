package by.javatr.bulhak.task3_1.util;

public final class WrongLinkCheck {

    private WrongLinkCheck(){
    }

    public static void isObjectNull(Object obj) throws WrongLinkException {
        if(obj ==null){
            throw new WrongLinkException("текст не найден");
        }
    }
}
