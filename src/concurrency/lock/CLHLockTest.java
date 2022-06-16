package concurrency.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author xucheng.liu
 * @since 2022/4/24
 */
public class CLHLockTest {

    private static int cnt = 0;

    private static final int COUNT = 10;

    public static void main(String[] args) throws Exception {
        final CLHLock lock = new CLHLock();
        CountDownLatch latch = new CountDownLatch(COUNT);

        for (int i = 0; i < COUNT; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    cnt++;
                } finally {
                    lock.unLock();
                    latch.countDown();
                }
            }).start();
        }

        latch.await();
        System.out.println("cnt----------->>> " + cnt);
    }
}
