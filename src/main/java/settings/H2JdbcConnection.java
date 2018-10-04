package settings;

import org.apache.log4j.Logger;
import service.ReportImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The class helps connection from database.
 */
public class H2JdbcConnection {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:mem:dbInMemory;INIT=runscript from 'classpath:createTable.sql'";
    private static final String USER = "root";
    private static final String PASSWORD = "mypassword";
    private static final Logger LOGGER = Logger.getLogger(ReportImpl.class);

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (SQLException se) {
            LOGGER.error(se.getMessage());
        }
        return connection;
    }
}
