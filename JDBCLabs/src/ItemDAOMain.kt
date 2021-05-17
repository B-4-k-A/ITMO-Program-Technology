import com.javatunes.util.ItemDAO
import com.javatunes.util.MusicItem
import java.math.BigDecimal
import java.sql.DriverManager

fun main() {
    var musicItem: MusicItem?
    val clientDriver = Class.forName("org.apache.derby.jdbc.ClientDriver")
    val conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaTunesDB")
    var itemDAO = ItemDAO(conn)
    musicItem = itemDAO.searchById(1)
    println(musicItem)

    var itemList = itemDAO.searchByKeyword("of")
    println("Result of searchByKeyword method")
    itemList.forEach { println(it) }

    println("Result of create method")
    var item = MusicItem(1, "title", "artist", "2021-04-19",
                            BigDecimal(150.0), BigDecimal(12.0))
    itemDAO.create(item)
    conn.commit()

}
