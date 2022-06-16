package base.reflect;

/**
 * @author xucheng.liu
 * @since 2022/3/29
 */
public class Test {

    public static int count;

    static {
        count = 1;
        System.out.println("static");
    }

    public Test() {

    }

    public void print() {
        System.out.println("print");
    }
}
