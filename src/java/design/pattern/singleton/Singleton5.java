package design.pattern.singleton;

/**
 * @author liuxucheng
 * @since 2022/12/13
 */
public enum Singleton5 {
    /**
     * 每个枚举元素对应一个枚举对象实例
     */
    INSTANCE;

    public void method() {
        System.out.println("singleton enum");
    }

    public static void main(String[] args) {
        Singleton5 singleton1 = Singleton5.INSTANCE;
        Singleton5 singleton2 = Singleton5.INSTANCE;
        System.out.println(singleton1 == singleton2);
    }
}
