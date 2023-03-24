package design.pattern.singleton;

/**
 * 饿汉式
 * 优点：线程安全，高性能
 * 缺点：不支持延迟加载
 *
 * @author liuxucheng
 * @since 2022/12/13
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
