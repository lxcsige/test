package JdbcPool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by liuxucheng on 2018/1/18.
 */
public class JdbcPool implements DataSource {

    private static LinkedList<Connection> connections = new LinkedList<>();

    static {
        //初始化连接池
    }

    @Override
    public Connection getConnection() throws SQLException {
        //从连接池中获取连接
        final Connection conn = connections.removeFirst();
        // 返回连接的代理对象，当connection.close()时将连接还到连接中
        return (Connection) Proxy.newProxyInstance(JdbcPool.class.getClassLoader(), Connection.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("close".equals(method.getName())) {
                    connections.add(conn);
                    return null;
                } else {
                    return method.invoke(conn, args);
                }
            }
        });
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
