package ru.billing.stocklist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author McBek
 * @version 0.1
 */
public class GenericItem {
    private static int currentID = 1;
    private int ID;
    private String name;
    private float price;
    private Set<GenericItem> analogs = new HashSet<>();
    private Category category;

    public GenericItem() {
        this.ID = currentID++;
    }

    public GenericItem(String name, float price) {
        this();
        this.name = name;
        this.price = price;
        this.category = Category.GENERAL;
    }

    public GenericItem(String name, float price, Category category) {
        this();
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public GenericItem(String name, float price, Set<GenericItem> analogs) {
        this();
        this.name = name;
        this.price = price;
        this.analogs = analogs != null ? analogs : new HashSet<>();
        if (analogs != null) {
            analogs.stream().findFirst().ifPresent(obj -> this.setCategory(obj.getCategory()));
        }
    }

    protected GenericItem(int ID, String name, float price, Category category, Set<GenericItem> analogs) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.category = category;
        this.analogs = analogs;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void addAnalog(GenericItem item) {
        analogs.add(item);
    }

    public void removeAnalog(GenericItem item) {
        analogs.remove(item);
    }

    public void setAnalog(Set<GenericItem> analogs) {
        this.analogs = analogs;
    }

    public List<GenericItem> getAnalogs() {
        return new ArrayList<>(analogs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenericItem that = (GenericItem) o;

//        if (ID != that.ID) return false;
        if (Float.compare(that.price, price) != 0) return false;
        if (!name.equals(that.name)) return false;
        return category == that.category;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + name.hashCode();
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + category.hashCode();
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new GenericItem(ID, name, price, category, analogs);
    }

    @Override
    public String toString() {
        return String.format("ID: %2d, ", ID) +
                String.format("Name: %-30s, ", name) +
                String.format("Price: %10.2f", price);

    }
}
