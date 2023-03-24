package concurrency.lock.stampedLock;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock测试
 *
 * @author liuxucheng
 * @since 2023/2/27
 */
public class Point {

    private double x, y;

    private final StampedLock sl = new StampedLock();

    /**
     * 写锁
     *
     * @param deltaX
     * @param deltaY
     */
    public void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    /**
     * 乐观读
     *
     * @return
     */
    public double distanceFromOrigin() {
        long stamp = sl.tryOptimisticRead();
        double currentX = x, currentY = y;
        // 验证stamp
        if (!sl.validate(stamp)) {
            // 有其他线程加了写锁
            // 加悲观读锁
            stamp = sl.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    /**
     * 读锁升级为写锁
     *
     * @param newX
     * @param newY
     */
    void moveIfAtOrigin(double newX, double newY) {
        // Could instead start with optimistic, not read mode
        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                long ws = sl.tryConvertToWriteLock(stamp);
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }
}
