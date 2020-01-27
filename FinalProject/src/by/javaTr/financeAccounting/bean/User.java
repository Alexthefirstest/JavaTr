/*
 *
 *класс - пользователь:
 * администраторы и пользователи объеденены в один класс
 *
 */

package by.javaTr.financeAccounting.bean;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 3428726868598773973L;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder(getClass().getName());
        sb.append("{login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {

        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

}
