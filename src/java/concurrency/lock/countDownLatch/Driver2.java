package concurrency.lock.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程分治
 *
 * @author liuxucheng
 * @since 2023/3/6
 */
public class Driver2 {

    private static final int N = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(N);
        ExecutorService executorService = Executors.newFixedThreadPool(N);

        // create and start threads
        for (int i = 0; i < N; ++i) {
            executorService.submit(new WorkerRunnable(doneSignal, i));
        }
        // wait for all to finish
        doneSignal.await();
        // merge
    }
}
