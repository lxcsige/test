package concurrency.lock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xucheng.liu
 * @since 2022/4/29
 */
public class Downgrade implements Runnable {

    private ReentrantReadWriteLock rrwLock;

    public Downgrade(ReentrantReadWriteLock rrwLock) {
        this.rrwLock = rrwLock;
    }

    @Override
    public void run() {
        rrwLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + " lock write successfully");

        rrwLock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + " lock read successfully");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rrwLock.writeLock().unlock();

            while (!Thread.currentThread().isInterrupted()) {

            }

            rrwLock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock successfully");
        }
    }
}
