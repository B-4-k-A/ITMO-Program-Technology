package ru.billing.client;

import ru.itmo.exceptions.CatalogLoadException;

public interface CatalogLoader {

    public void load(ItemCatalog catalog) throws CatalogLoadException;
}
