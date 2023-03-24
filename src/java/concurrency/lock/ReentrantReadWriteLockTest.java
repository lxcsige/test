package concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liuxucheng
 * @since 2023/2/24
 */
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Lock readLock = lock.readLock();
        Lock writeLock = lock.writeLock();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                writeLock.lock();
                System.out.println("thread" + Thread.currentThread().getName() + "get write lock");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                readLock.lock();
                System.out.println("thread" + Thread.currentThread().getName() + "get read lock");
                readLock.unlock();
                writeLock.unlock();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writeLock.lock();
                System.out.println("thread" + Thread.currentThread().getName() + "get write lock");
                writeLock.unlock();
            }
        };
        t1.start();
        t2.start();
    }
}
