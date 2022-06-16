package concurrency.lock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xucheng.liu
 * @since 2022/4/29
 */
public class Writer implements Runnable {

    private ReentrantReadWriteLock rrwLock;

    public Writer(ReentrantReadWriteLock rrwLock) {
        this.rrwLock = rrwLock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " trying to lock");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            rrwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " lock successfully");
        } finally {
            rrwLock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock successfully");
        }
    }
}
