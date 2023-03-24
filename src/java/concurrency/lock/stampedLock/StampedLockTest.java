package concurrency.lock.stampedLock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * @author liuxucheng
 * @since 2023/3/1
 */
public class StampedLockTest {

    private static final StampedLock sl = new StampedLock();

    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread() {
//            @Override
//            public void run() {
//                sl.writeLock();
//            }
//        };
//        Thread t2 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                sl.readLock();
//            }
//        };
//        t1.start();
//        t2.start();

//        long stamp = sl.readLock();
//        Thread t3 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println(sl.readLock());
//            }
//        };
//        t3.start();
//        Thread.sleep(1000);
//        sl.unlockRead(stamp);
//        long res = sl.tryConvertToWriteLock(stamp);
//        System.out.println(res);

        final StampedLock lock = new StampedLock();
//        Thread t1 = new Thread(() -> {
//            // 获取写锁
//            lock.writeLock();
//            // 模拟程序阻塞等待其他资源
//            LockSupport.park();
//        });
//        t1.start();
//        // 保证t1获取写锁
//        Thread.sleep(100);
//        Thread t2 = new Thread(() -> {
//            // 阻塞在悲观读锁
//            lock.readLock();
//        });
//        t2.start();
//        // 保证t2阻塞在读锁
//        Thread.sleep(100);
//        // 中断线程t2,会导致线程t2所在CPU飙升
//        t2.interrupt();
//        t2.join();

//        Thread t1 = new Thread() {
//            @Override
//            public void run() {
//                long stamp = lock.writeLock();
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                lock.unlockWrite(stamp);
//            }
//        };
//        Thread t2 = new Thread() {
//            @Override
//            public void run() {
//                long stamp = lock.readLock();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                lock.unlockRead(stamp);
//            }
//        };
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//
//        Thread t3 = new Thread() {
//            @Override
//            public void run() {
//                long stamp = lock.writeLock();
//            }
//        };
//        Thread t4 = new Thread() {
//            @Override
//            public void run() {
//                long stamp = lock.readLock();
//            }
//        };
//        t3.start();
//        t4.start();
//        t3.join();
//        t4.join();
    }
}
