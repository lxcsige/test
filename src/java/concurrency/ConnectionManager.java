package concurrency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author liuxucheng
 * @since 2022/12/14
 */
public class ConnectionManager {

    private static final ThreadLocal<Connection> dbConnectionLocal = ThreadLocal.withInitial(() -> {
        try {
            return DriverManager.getConnection("", "", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    });

    public Connection getConnection() {
        return dbConnectionLocal.get();
    }
}
