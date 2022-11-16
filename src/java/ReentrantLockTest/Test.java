package ReentrantLockTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: lxcfour
 * Date: 2018/5/15
 * Time: 下午2:41
 */
public class Test {

    public void test() throws Exception
    {
        final Lock lock = new ReentrantLock();
        lock.lock();


        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().isInterrupted());
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }
        },"child thread -1");

        t1.start();
        Thread.sleep(1000);

        t1.interrupt();

        Thread.sleep(10000);
        lock.unlock();
    }

    public static void main(String[] args) throws Exception
    {
        new Test().test();

        CountDownLatch latch = new CountDownLatch(2);
        CyclicBarrier barrier = new CyclicBarrier(2);
        Semaphore semaphore = new Semaphore(2);
    }
}
