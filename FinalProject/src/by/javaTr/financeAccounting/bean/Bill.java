//вроде готов

package by.javaTr.financeAccounting.bean;

import java.io.Serializable;
import java.util.Date;

public class Bill implements Serializable {

    private static final long serialVersionUID = 7953829627293509348L;

    private Bill() {
    }

    public Bill(String name, double money, Date date) {
        this(name, "", money, date);
    }

    public Bill(String name, String category, double money, Date date) {
        this.name = name;
        this.category = category;
        this.money = money;
        this.date = date;
    }

    private String name;
    private String category;
    private double money; //меньше нуля - затраты, больше - прибыль
    private Date date;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getName());
        sb.append(" {name='").append(name).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", money=").append(money);
        sb.append(", date='").append(date).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (Double.compare(bill.money, money) != 0) return false;
        if (name != null ? !name.equals(bill.name) : bill.name != null) return false;
        if (category != null ? !category.equals(bill.category) : bill.category != null) return false;
        return date != null ? date.equals(bill.date) : bill.date == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        temp = Double.doubleToLongBits(money);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

}
