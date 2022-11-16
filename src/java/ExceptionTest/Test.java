package ExceptionTest;

/**
 * Created by liuxucheng on 2018/5/20.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        int a = 0;
        int b = 3;
        try {
            b = b / a;
            return b;
        } catch (RuntimeException e1) {
            b = a - b;
        } catch (Exception e2) {
            b = a * b;
        } finally {
            b = 1;
        }

        return b;
    }
}
