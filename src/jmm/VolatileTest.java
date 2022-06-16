package jmm;

/**
 * @author xucheng.liu
 * @since 2022/4/16
 */
public class VolatileTest {

    int a, b;

    volatile int v, u;

    void f() {
        int i, j;
        i = a;
        j = b;
        i = v;
        j = u;
    }

    public static void main(String[] args) {
        new VolatileTest().f();
    }
}
