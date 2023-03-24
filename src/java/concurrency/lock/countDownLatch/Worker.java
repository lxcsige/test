package concurrency.lock.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuxucheng
 * @since 2023/3/6
 */
public class Worker implements Runnable {

    private final CountDownLatch startSignal;

    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            // 等待driver的start
            startSignal.await();
            // worker逻辑执行
            doWork();
        } catch (InterruptedException ex) {

        } finally {
            // worker执行完成，尚未完成的任务数-1
            doneSignal.countDown();
        }
    }

    void doWork() {
        // do something
    }
}
