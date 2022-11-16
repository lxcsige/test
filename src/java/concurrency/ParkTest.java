package concurrency;

import java.util.concurrent.locks.LockSupport;

/**
 * @author liuxucheng
 * @since 2022/8/18
 */
public class ParkTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1");
            System.out.println("park");
            LockSupport.park();
            System.out.println("unpark");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t1.getState());
            LockSupport.unpark(t1);
        });
        t1.start();
        t2.start();
    }
}
