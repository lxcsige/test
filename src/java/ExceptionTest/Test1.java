package ExceptionTest;

/**
 * Created by liuxucheng on 2018/5/20.
 */
public class Test1 {

    public static void main(String[] args) {
        int a = 1;
        add(a);
        System.out.println(a);
    }

    public static void add(int a) {
        a++;
    }
}
