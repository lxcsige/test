package concurrency.lock.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuxucheng
 * @since 2023/3/5
 */
public class CountDownLatchTest {

    private static final CountDownLatch countDownLatch = new CountDownLatch(2);

    public static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " doing something");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finish");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        t1.start();
        t2.start();
        System.out.println("Waiting for t1 thread and t2 thread to finish");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " continue");
    }
}
