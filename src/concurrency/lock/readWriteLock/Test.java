package concurrency.lock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xucheng.liu
 * @since 2022/4/29
 */
public class Test {

    public static void main(String[] args) {
        ReentrantReadWriteLock rrwLock = new ReentrantReadWriteLock();
        Thread t1 = new Thread(new Reader(rrwLock), "rt1");
        Thread t2 = new Thread(new Reader(rrwLock), "rt2");
//        Thread t3 = new Thread(new Writer(rrwLock), "wt1");
        Thread t4 = new Thread(new Downgrade(rrwLock), "downgrade");
        t1.start();
        t2.start();
//        t3.start();
        t4.start();
    }
}
