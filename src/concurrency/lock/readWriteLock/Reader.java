package concurrency.lock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xucheng.liu
 * @since 2022/4/29
 */
public class Reader implements Runnable {

    private ReentrantReadWriteLock rrwLock;

    public Reader(ReentrantReadWriteLock rrwLock) {
        this.rrwLock = rrwLock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " trying to lock");
        try {
            Thread.sleep(1000);

            rrwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " lock successfully");

            if ("rt1".equals(Thread.currentThread().getName())) {
                Thread.sleep(3000);
            } else {
                Thread.sleep(60000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rrwLock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock successfully");
        }
    }
}
