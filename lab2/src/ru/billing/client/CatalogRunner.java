package ru.billing.client;

import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.Reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class CatalogRunner {
    public static void main(String[] args) {
        ItemCatalog catalog = new ItemCatalog();
        try {
            Reader reader = new Reader(new File("C:\\Users\\SmiLE\\Github repos\\ITMO-Program-Technology\\lab2\\resources\\items.lst"), "windows-1251");
            do {
                String line = reader.next();
                String[] words = line.split(";");
                FoodItem item = new FoodItem(words[0], Float.parseFloat(words[1]), Short.parseShort(words[2]));
                catalog.addItem(item);
            } while (reader.hasNext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        long begin = new Date().getTime();

        for(int i = 0; i < 100000; i++) {
            catalog.findItemByID(15);
        }
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));
        begin = new Date().getTime();

        for(int i = 0; i < 100000; i++) {
            catalog.findItemByIDAL(15);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        ItemCatalog cat = new ItemCatalog();
        CatalogStubLoader loader = new CatalogStubLoader();
        try {
            loader.load(cat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cat.printItems();
//        var list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(list.stream().filter(i -> i.equals(3)).findFirst().orElse(null));
    }
}
