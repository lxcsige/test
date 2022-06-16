package jmm;

/**
 * 单例模式-双重锁校验
 *
 * @author xucheng.liu
 * @since 2022/4/15
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton != null) {
            return singleton;
        }
        synchronized (Singleton.class) {
            if (singleton == null) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}
