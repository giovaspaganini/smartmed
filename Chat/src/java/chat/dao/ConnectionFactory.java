
package chat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
           "jdbc:postgresql://localhost/cyka_blyat", "postgres", "12345678");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}