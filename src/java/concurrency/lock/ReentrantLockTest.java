package concurrency.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuxucheng
 * @since 2023/3/8
 */
public class ReentrantLockTest {

    private static final ReentrantLock lock = new ReentrantLock(true);

    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()-> {
            lock.lock();
            try {
                System.out.println("awiat time: " + System.currentTimeMillis());
                condition.await(15, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("unPark time: " + System.currentTimeMillis());
            lock.unlock();
        });
        t1.start();

        ExecutorService executorService = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++) {
            executorService.submit(new Test());
        }

        Thread.sleep(5000);
        executorService.shutdownNow();
    }

    private static class Test implements Runnable {

        @Override
        public void run() {
            lock.lock();
            lock.unlock();
            System.out.println("currentTime: " + System.currentTimeMillis());
        }
    }
}
