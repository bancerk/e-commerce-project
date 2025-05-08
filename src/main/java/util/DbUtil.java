package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static final String url = "jdbc:postgresql://localhost:5432/patika_store";
    private static final String user = "example";
    private static final String password = "example";
    private DbUtil() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
