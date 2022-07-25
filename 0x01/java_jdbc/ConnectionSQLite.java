import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {
    public static void main(String[] args) {
        Connection connection = initConnection();
    }

    public static Connection initConnection() {
        Connection connection = null;
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:sqlite_database_2022.db");
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);;
            }

        return connection;
    }
}
