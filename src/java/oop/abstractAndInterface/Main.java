package oop.abstractAndInterface;

/**
 * @author liuxucheng
 * @since 2022/11/28
 */
public class Main {

    public static void main(String[] args) {
        InterImpl inter = new InterImpl();
        // 直接调用接口的默认方法
        inter.method();
        inter.method2();
        inter.show();
        // 通过接口名调用接口的静态方法
        Inter.test();
    }
}
