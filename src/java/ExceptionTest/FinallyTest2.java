package ExceptionTest;

/**
 * Created by liuxucheng on 2018/5/20.
 */
public class FinallyTest2 {

    public static void main(String[] args) {

        System.out.println(test2());
    }

    public static int test2() {
        int b = 20;

        try {
            System.out.println("try block");

            return b += 80;
        } catch (Exception e) {

            System.out.println("catch block");
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            return 200;
        }

        // return b;
    }
}
