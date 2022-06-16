package base.exception.ClassNotFoundError;

/**
 * @author xucheng.liu
 * @since 2022/3/27
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.driver");
    }
}
