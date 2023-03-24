package concurrency.lock.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 同步driver主线程和一组worker线程
 *
 * @author liuxucheng
 * @since 2023/3/6
 */
public class Driver {

    private static final int N = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        // create and start threads
        for (int i = 0; i < N; ++i) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        // driver初始化操作
        // let all worker threads proceed
        startSignal.countDown();
        // do something else
        // wait for all to finish
        doneSignal.await();
    }
}