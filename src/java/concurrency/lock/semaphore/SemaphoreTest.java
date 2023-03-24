package concurrency.lock.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author liuxucheng
 * @since 2023/3/5
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                // 直接增加1个令牌，当前令牌数可以超过初始令牌数
                semaphore.release();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 可以获取到3个令牌
                semaphore.acquireUninterruptibly(3);
                System.out.println("t2");
            }
        };
        t1.start();
        t2.start();
    }
}
