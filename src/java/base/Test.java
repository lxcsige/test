package base;

/**
 * @author liuxucheng
 * @since 2023/2/9
 */
public class Test {

    public static void main(String[] args) {
        Obj obj = new Obj();
        double c = obj.c;

        Thread t1 = new Thread(() -> {
                int a = obj.a;
                long b = obj.b;
                double d = obj.c;
        });

        t1.start();
    }
}
