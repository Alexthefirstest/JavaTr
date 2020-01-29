/*
 *
 *  методы для получения пользователей из файла и записи их туда
 *
 */

package by.javaTr.financeAccounting.dao.impl;

import by.javaTr.financeAccounting.dao.UserDAO;
import by.javaTr.financeAccounting.bean.User;
import by.javaTr.financeAccounting.dao.exceptions.DAOException;

import java.io.*;
import java.util.ArrayList;

public class SQLUserDAO implements UserDAO {

    private final File commonDirectory = new File(getClass().getResource("").getPath() + ("..\\..\\source"));

    public SQLUserDAO() {

        try {

            new File(commonDirectory + "\\Users.txt").createNewFile();
            new File(commonDirectory + "\\Admins.txt").createNewFile();
            new File(commonDirectory + "\\bills").mkdir();
        } catch (Exception ex) {
        }

    }


    static boolean addUsersOrAdmins(String directory, boolean flag, User... users) throws DAOException {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(directory, flag))) {

            for (int i = 0; i < users.length; i++) {
                bufferedWriter.write(users[i].getLogin() + "/" + users[i].getPassword() + "\n");
            }

        } catch (FileNotFoundException ex) {
            throw new DAOException("Source file not found", ex);
        } catch (IOException ex) {
            throw new DAOException("IOException", ex);
        }

        return true;
    }

    private User[] getUsersOrAdmins(String directory) throws DAOException {

        ArrayList<User> users = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(directory))) {

            String line = null;
            String[] userData;

            while ((line = bf.readLine()) != null) {
                userData = line.split("/");
                users.add(new User(userData[0], userData[1]));
            }


        } catch (FileNotFoundException ex) {
            throw new DAOException("Source file not found", ex);
        } catch (IOException ex) {
            throw new DAOException("IOException", ex);
        }

        return users.toArray(new User[]{});
    }

    @Override
    public boolean addUser(User user) throws DAOException {

        File newBillsCatalog = new File(commonDirectory+"\\bills\\" + user.getLogin());

        if (!newBillsCatalog.mkdir()) {
            return false;
        }

        addUsersOrAdmins(commonDirectory+"\\Users.txt", true, user);

        return true;
    }

    @Override
    public User[] getUsers() throws DAOException {

        return getUsersOrAdmins(commonDirectory+"\\Users.txt");
    }

    @Override
    public boolean addAdmin(User user) throws DAOException {

        return addUsersOrAdmins(commonDirectory+"\\Admins.txt", true, user);
    }

    @Override
    public User[] getAdmins() throws DAOException {

        return getUsersOrAdmins(commonDirectory+"\\Admins.txt");
    }

}
