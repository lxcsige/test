package defaultMethodTest;

/**
 * @author xucheng.liu
 * @since 2022/3/11
 */
public interface InterfaceD {

    default void print() {
        System.out.println("print D");
    }

    static void staticMethod() {
        System.out.println("static method D");
    }
}
