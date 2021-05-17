import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.DriverManager

fun main(args: Array<String>) {
    var conn: Connection? = null
    val userName = "guest"
    val password = "password"
    val clientDriver = Class.forName("org.apache.derby.jdbc.ClientDriver")
    conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaTunesDB", userName, password)
    var dbmd: DatabaseMetaData? = conn.metaData;

    println(dbmd?.driverName)

    println(dbmd?.userName)

    conn.close()

}