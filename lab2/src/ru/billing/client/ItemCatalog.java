package ru.billing.client;

import ru.billing.stocklist.GenericItem;
import ru.itmo.exceptions.ItemAlreadyExistsException;

import java.util.*;

public class ItemCatalog {
    private Map<Integer, GenericItem> catalog = new HashMap<>();

    private List<GenericItem> ALCatalog = new ArrayList<>();

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if (catalog.containsValue(item) | ALCatalog.contains(item)) {
            throw new ItemAlreadyExistsException("");
        }
        catalog.put(item.getID(), item);
        ALCatalog.add(item);
    }

    public void printItems() {
        for (GenericItem i : ALCatalog) {
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id) {
        return catalog.getOrDefault(id, null);
    }

    public GenericItem findItemByIDAL(int id) {
        return ALCatalog.stream()
                .filter(obj -> obj.getID() == id)
                .findFirst().orElse(null);
    }
}
