package ru.billing.stocklist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TemplatesRunner {
    public static void main(String[] args) {
        ArrayList<FoodItem> items = new ArrayList<>();

        try {
            Reader reader = new Reader(new File("C:\\Users\\SmiLE\\Github repos\\ITMO-Program-Technology\\lab2\\resources\\items.lst"), "windows-1251");
            while (reader.hasNext()){
                String line = reader.next();
                String[] words = line.split(";");
                FoodItem item = new FoodItem(words[0], Float.parseFloat(words[1]), Short.parseShort(words[2]));
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        items.forEach(System.out::println);
    }
}
