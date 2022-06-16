package jmm;

/**
 * @author xucheng.liu
 * @since 2022/4/14
 */
public class VisibilityTest {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();

        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 flag = " + threadDemo.flag);
        });
        thread1.start();

        Thread thread2 = new Thread(threadDemo);
        thread2.start();
    }
}
