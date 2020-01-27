/*
*
* класс для логирования в контроллере
*
*/

package by.javaTr.financeAccounting.logger;


import java.io.FileInputStream;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MyLogger {

    private MyLogger() {
    }

    private static Logger myLogger;

    public static Logger getLogger() {
        return myLogger;
    }

    static {

        try (FileInputStream conf =
                     new FileInputStream((".\\src\\by\\javaTr\\financeAccounting\\logger\\configs.config"))) {

            LogManager.getLogManager().readConfiguration(conf);
            myLogger = Logger.getLogger("ControllerLogin");
        } catch (Exception ex) {
            ex.printStackTrace();//lkjlk
        }

    }

}
