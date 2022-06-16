package base.reflect;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author xucheng.liu
 * @since 2022/3/23
 */
public class ClassForNameTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 通用反射加载Driver类，替换Driver很方便
//        Class.forName("com.mysql.jdbc.Driver");
//        DriverManager.getConnection("", "root", "root");

        // 默认类初始化
        Class testClass = Class.forName("base.reflect.Test");

        // 不包含类初始化动作
        testClass = ClassLoader.getSystemClassLoader().loadClass("base.reflect.Test");
    }
}
