package ru.billing.client

fun main(args: Array<String>) {
    val filePath = "C:\\Users\\SmiLE\\Github repos\\ITMO-Program-Technology\\lab2\\resources\\items.lst"
    val charsetName = "windows-1251"
    val catalog = ItemCatalog()
    val loader = CatalogFileLoader(filePath, charsetName)
    loader.load(catalog)
    catalog.printItems()
}