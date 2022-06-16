package base.exception;

/**
 * 测试finally和return的执行顺序
 *
 * @author xucheng.liu
 * @since 2022/3/28
 */
public class FinallyTest {

    public static void main(String[] args) {
        FinallyTest test = new FinallyTest();
        System.out.println(test.inc());
    }

    public int inc() {
        int x;
        try {
            int y = 0/0;
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
