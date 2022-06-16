package concurrency.thread;

/**
 * Thread.join测试
 *
 * @author xucheng.liu
 * @since 2022/4/18
 */
public class ThreadJoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        Thread t1 = new Thread(() -> System.out.println("t1"));
        // 顺序测试
        t1.join();
        t1.start();
        System.out.println("main");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            main.interrupt();
        });
        t2.start();
        t2.join();
    }
}
