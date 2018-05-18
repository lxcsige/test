package classTest;

/**
 * User: lxcfour
 * Date: 2018/5/17
 * Time: 上午11:39
 */
public class Person {
    static {
        System.out.println("person");
    }

    public static String s = getString();

    private static String getString() {
        System.out.println("给静态变量赋值的静态方法执行：loading line");
        return "ss";
    }
}
