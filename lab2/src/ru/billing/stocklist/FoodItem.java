package ru.billing.stocklist;

import java.util.Date;
import java.util.HashSet;

public class FoodItem extends GenericItem{

    private Date dateOfIncome;

    private short expires;

    public FoodItem(String name, float price, HashSet<GenericItem> analogs, Date dateOfIncome, short expires) {
        super(name, price, analogs);
        setCategory(Category.FOOD);
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires) {
        this(name, price, null, null, expires);
    }

    public FoodItem(String name) {
        this(name, 0f, null, null, (short) 0);
    }

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FoodItem foodItem = (FoodItem) o;

        if (expires != foodItem.expires) return false;
        return dateOfIncome.equals(foodItem.dateOfIncome);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + dateOfIncome.hashCode();
        result = 31 * result + (int) expires;
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FoodItem temp = (FoodItem) super.clone();
        temp.setDateOfIncome(dateOfIncome);
        temp.setExpires(expires);
        return temp;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(",\tDate of income:%-10s,", dateOfIncome) +
                String.format("\tExpires:%5d", expires);
    }
}
