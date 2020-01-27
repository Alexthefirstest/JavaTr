/*
 *
 *  класс содержит override метод, который удаляет из источника данных каталог счетов заданного пользователя
 *
 */

package by.javaTr.financeAccounting.dao.impl;

import by.javaTr.financeAccounting.dao.BillsCatalogDeleter;

import java.io.File;

public class SQLBillsCatalogDeleter implements BillsCatalogDeleter {

    private boolean deleteFileOrDirectory(File file) {

        if (file.isDirectory()) {
            String[] files = file.list();

            for (int i = 0; i < files.length; i++) {
                deleteFileOrDirectory(new File(file.getPath() + "\\" + files[i]));
            }

        }

        file.delete();

        return true;
    }

    @Override
    public boolean deleteUserBillsCatalog(String login) {

        File file = new File(".\\src\\by\\javaTr\\financeAccounting\\source\\bills\\" + login);

        if (file.exists()) {

            return deleteFileOrDirectory(file);
        } else {
            return false;
        }

    }

}
