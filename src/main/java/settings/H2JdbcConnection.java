package settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The class helps connection from database.
 */
public class H2JdbcConnection {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:./Database/my";
    static final String USER = "root";
    static final String PASSWORD = "mypassword";

    public H2JdbcConnection() {
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
        } catch (SQLException se) {
        }
        return connection;
    }
}
