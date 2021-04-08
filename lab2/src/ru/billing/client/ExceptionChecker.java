package ru.billing.client;

import ru.billing.stocklist.Category;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.GenericItem;

import java.util.Date;

public class ExceptionChecker {
    public static void main(String[] args) {
        ItemCatalog catalog = new ItemCatalog();
        CatalogStubLoader loader = new CatalogStubLoader();

        GenericItem item1 = new GenericItem("Sony TV",23000, Category.GENERAL);
        FoodItem item2 = new FoodItem("Bread",12,null,new Date(),(short)10);
//      Закоментировал сравнение ID из метода equals в классе GenericItem
        try {
            catalog.addItem(item1);
            catalog.addItem(item2);
            loader.load(catalog);
        } catch(Exception e) {
            e.printStackTrace();
        }
        catalog.printItems();

    }
}
