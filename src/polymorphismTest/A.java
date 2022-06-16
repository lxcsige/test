package polymorphismTest;

/**
 * @author xucheng.liu
 * @since 2022/3/10
 */
public class A {

    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }

    protected void print() {
        System.out.println("A");
    }

    public final void test() {

    }

    public static void test1() {
        System.out.println("static A");
    }
}
