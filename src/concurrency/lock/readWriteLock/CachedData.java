package concurrency.lock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xucheng.liu
 * @since 2022/4/29
 */
public class CachedData {

    private Object data;

    private volatile boolean cacheValid;

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void processCachedData() {
        // 加读锁
        rwl.readLock().lock();
        // 缓存过期，加写锁，更新缓存
        if (!cacheValid) {
            // Must release read lock before acquiring write lock
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                // Recheck state because another thread might have
                // acquired write lock and changed state before we did.
                if (!cacheValid) {
                    data = new Object();
                    cacheValid = true;
                }
                // 降级为读锁
                // Downgrade by acquiring read lock before releasing write lock
                rwl.readLock().lock();
            } finally {
                rwl.writeLock().unlock(); // Unlock write, still hold read
            }
        }

        try {
            System.out.println("data = " + data);
        } finally {
            rwl.readLock().unlock();
        }
    }
}
