package ExceptionTest;

/**
 * User: lxcfour
 * Date: 2018/5/11
 * Time: 下午3:59
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.test1());
    }

    public int test() throws MyException {
        int i = 0;
        try {
            i = 1/0;
        } catch(ArithmeticException e) {
            throw new MyException("算术异常");
        } finally {
            return i;
        }
    }

    public int test1() {
        int i = 0;
        try {
            i = 1/0;
        } catch(ArithmeticException e) {
            return 1;
        } finally {
            return 2;
        }
    }
}
