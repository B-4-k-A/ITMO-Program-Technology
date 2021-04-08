package ru.billing.stocklist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemsRunner {
    public static void main(String[] args){
        try {
            var item1 = new GenericItem("Item1", 250000.752345f);
            var item2 = new GenericItem("Item2", 250.7484f);
            var item3 = new GenericItem("Item3", 100.50f);
            System.out.println(item1);
            System.out.println(item2);
            System.out.println(item3);

            List<GenericItem> items = new ArrayList<>();

            var item4 = new FoodItem("Item4", 100, null, new Date(), (short) 7);
            var item5 = new TechnicalItem("Item5", 200, (short) 180);

            items.add(item4);
            items.add(item5);

            items.forEach(System.out::println);

            System.out.println(item1.equals(item2));

            item1.addAnalog(item2);
            item1.addAnalog(item3);

            var temp = (GenericItem) item1.clone();
            System.out.println(item1.equals(temp));

            System.out.println("Analogs of temp after clone");
            temp.getAnalogs().forEach(o -> System.out.println("\t" + o));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
