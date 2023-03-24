package concurrency.lock.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuxucheng
 * @since 2023/3/6
 */
public class WorkerRunnable implements Runnable{

    private final CountDownLatch doneSignal;

    private final int i;

    WorkerRunnable(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            doWork(i);
        } catch (Exception ex) {

        } finally {
            doneSignal.countDown();
        }
    }

    private void doWork(int index) {

    }
}
