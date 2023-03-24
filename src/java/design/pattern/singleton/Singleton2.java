package design.pattern.singleton;

/**
 * 懒汉式
 * 优点：延迟加载
 * 缺点：性能瓶颈
 *
 * @author liuxucheng
 * @since 2022/12/13
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {

    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
