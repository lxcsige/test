package ExceptionTest;

/**
 * User: lxcfour
 * Date: 2018/5/11
 * Time: 下午3:59
 */
public class Test {

    public static void main(String[] args) {
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
        try {
            i = 1/0;
        } catch(ArithmeticException e) {
            throw new MyException("算术异常");
        } finally {
            return i;
        }
    }

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
    }
}
