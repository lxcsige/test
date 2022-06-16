package concurrency.lock.producerAndConsumer.waitAndNotify;

/**
 * @author xucheng.liu
 * @since 2022/4/27
 */
public class BoundedBuffer {

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

    public void put(Object x) throws InterruptedException {
        synchronized (items) {
            while (count == items.length) {
                System.out.println("buffer is full, " + Thread.currentThread().getName() + " will wait");
                items.wait();
            }
            items[putPtr] = x;
            System.out.println(Thread.currentThread().getName() + " put at " + putPtr);
            if (++putPtr == items.length) {
                putPtr = 0;
            }
            count++;
            items.notify();
        }
    }

    public Object take() throws InterruptedException {
        synchronized (items) {
            // 当数组元素已空，消费者线程进入notEmpty条件队列，释放锁
            while (count == 0) {
                System.out.println("buffer is empty, " + Thread.currentThread().getName() + " will wait");
                items.wait();
            }
            Object x = items[takePtr];
            System.out.println(Thread.currentThread().getName() + " take at " + takePtr);
            if (++takePtr == items.length) {
                takePtr = 0;
            }
            count--;
            counter++;
            items.notify();

            return x;
        }
    }
}
