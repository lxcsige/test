package ExceptionTest;

/**
 * Created by liuxucheng on 2018/5/20.
 */
public class Test {

    public static void main(String[] args) {
<<<<<<< HEAD
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void test() throws Exception {
        Connection connection = null;
        try {
            connection = new Connection();
            connection.sendData();
        }
        finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public int test1() throws MyException {
        int i = 0;
=======
        System.out.println(test());
    }

    public static int test() {
        int a = 0;
        int b = 3;
>>>>>>> e2365a1662e430baf02863f7cbcc3be2736b8959
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

<<<<<<< HEAD
    public int test2() {
        int i = 0;
        int res = 3;
        try {
            i = 1/0;
        } catch(ArithmeticException e) {
            return --res;
        } finally {
            --res;
        }

        return 0;
=======
        return b;
>>>>>>> e2365a1662e430baf02863f7cbcc3be2736b8959
    }
}
