package design.pattern.singleton;

/**
 * 静态内部类
 * 优点：延迟加载，调用getInstance方法时才会加载SingletonHolder内部类；线程安全
 *
 * @author liuxucheng
 * @since 2022/12/13
 */
public class Singleton4 {

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }
}
