package ExceptionTest;

/**
 * Created by liuxucheng on 2018/5/20.
 */
public class FinallyTest5 {

    public static void main(String[] args) {

        System.out.println(test5());
    }

    public static int test5() {
        int b = 20;

        try {
            System.out.println("try block");

            b = b / 0;

            return b += 80;
        } catch (Exception e) {

            System.out.println("catch block");
            return b += 15;
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            return 50;
        }
    }
}
