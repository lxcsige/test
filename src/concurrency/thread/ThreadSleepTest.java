package concurrency.thread;

/**
 * @author xucheng.liu
 * @since 2022/4/6
 */
public class ThreadSleepTest {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(120000);
        System.out.println("sleep end");
    }
}
