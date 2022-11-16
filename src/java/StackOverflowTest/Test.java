package StackOverflowTest;

/**
 * User: lxcfour
 * Date: 2018/3/24
 * Time: 下午7:14
 */
public class Test {

    private int stackLength = 1;

    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + test.stackLength);
        }
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
}
