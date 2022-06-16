package concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁中断测试
 *
 * @author xucheng.liu
 * @since 2022/4/18
 */
public class LockInterruptTest {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();

        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                System.out.println("t1 get lock");
            } catch (InterruptedException e) {
                System.out.println("interruptedException");
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        t1.start();

        t1.interrupt();

        lock.unlock();
    }
}
