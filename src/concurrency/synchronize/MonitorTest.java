package concurrency.synchronize;

/**
 * synchronized重量级锁测试
 *
 * @author xucheng.liu
 * @since 2022/4/5
 */
public class MonitorTest {

    private final Object lock = new Object();

    public static void main(String[] args) {
        // 默认策略下，在A释放锁后一定是C线程先获得锁
        // 因为在获取锁时，是将当前线程插入到cxq的头部
        // 释放锁时，默认策略是：如果EntryList为空，则将cxq中的元素按原有顺序插入到到EntryList，并唤醒第一个线程。
        // 也就是当EntryList为空时，是后来的线程先获取锁。
        MonitorTest monitorTest = new MonitorTest();
        monitorTest.startThreadA();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitorTest.startThreadB();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitorTest.startThreadC();
    }

    public void startThreadA() {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("A get lock");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A release lock");
            }
        }, "thread-A").start();
    }

    public void startThreadB() {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("B get lock");
            }
        }, "thread-B").start();
    }

    public void startThreadC() {
        new Thread(() -> {
            synchronized (lock) {

                System.out.println("C get lock");
            }
        }, "thread-C").start();
    }
}
