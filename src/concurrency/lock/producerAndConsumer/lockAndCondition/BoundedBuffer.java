package concurrency.lock.producerAndConsumer.lockAndCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 环形buffer
 *
 * @author xucheng.liu
 * @since 2022/4/27
 */
public class BoundedBuffer {

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[10];

    /**
     * 读指针
     */
    private int putPtr;

    /**
     * 写指针
     */
    private int takePtr;

    /**
     * 数组中尚未消费过的元素数量
     */
    private int count;

    public int counter;

    public void put(Object x) {
        lock.lock();
        try {
            // 当数组元素已满，生产者线程进入notFull条件队列，释放锁
            while (count == items.length) {
                System.out.println("buffer is full, " + Thread.currentThread().getName() + " will wait");
                notFull.awaitUninterruptibly();
            }
            items[putPtr] = x;
            System.out.println(Thread.currentThread().getName() + " put at " + putPtr);
            if (++putPtr == items.length) {
                putPtr = 0;
            }
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() {
        lock.lock();
        try {
            // 当数组元素已空，消费者线程进入notEmpty条件队列，释放锁
            while (count == 0) {
                System.out.println("buffer is empty, " + Thread.currentThread().getName() + " will wait");
                notEmpty.awaitUninterruptibly();
            }
            Object x = items[takePtr];
            System.out.println(Thread.currentThread().getName() + " take at " + takePtr);
            if (++takePtr == items.length) {
                takePtr = 0;
            }
            count--;
            counter++;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
