package design.pattern.singleton;

/**
 * 双重检测
 * 优点：高性能、延迟加载
 *
 * @author liuxucheng
 * @since 2022/12/13
 */
public class Singleton3 {

    /**
     * 禁止重排序
     */
    private static volatile Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        // 1. 在heap中为对象分配内存
        // 2. 调用Singleton的构造函数来初始化成员变量
        // 3. 将instance指向heap中的对象（执行完这步instance就为非null了）
        // 如果不加volatile修饰，第2步和第3步可能重排序，导致第一次判空为false，返回instance，但其中的成员变量未初始化
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
