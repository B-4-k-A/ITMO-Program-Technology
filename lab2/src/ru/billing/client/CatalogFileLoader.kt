package ru.billing.client

import ru.billing.stocklist.FoodItem
import ru.billing.stocklist.Reader
import java.io.File
import java.lang.Exception

class CatalogFileLoader(var filePath: String, var charsetName: String) : CatalogLoader{

    override fun load(catalog: ItemCatalog) {
//        val items = ArrayList<FoodItem>()

        try {
            val reader = Reader(
                File(filePath),
                charsetName)
            while (reader.hasNext()) {
                val line = reader.next()
                val words = line.split(";".toRegex()).toTypedArray()
                val item = FoodItem(words[0],words[1].toFloat(), words[2].toShort())
                catalog.addItem(item)
//                items.add(item)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

//        items.forEach(Consumer { x: FoodItem? -> println(x) })
    }
}