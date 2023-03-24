package concurrency.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author liuxucheng
 * @since 2023/3/2
 */
public class LockSupportTest {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.park();
                System.out.println("t1");
            }
        };
        t1. start();
        LockSupport.unpark(t1);
    }
}
