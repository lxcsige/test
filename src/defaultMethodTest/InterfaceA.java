package defaultMethodTest;

/**
 * @author xucheng.liu
 * @since 2022/3/11
 */
public interface InterfaceA {

    default void print() {
        System.out.println("print A");
    }

    void method();

    static void staticMethod() {
        System.out.println("static method A");
    }
}
