package concurrency.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author xucheng.liu
 * @since 2022/5/3
 */
public class Driver {

    private static final int N = 10;

    public static void main() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        // don't let run yet
        System.out.println("before run");
        // let all threads proceed
        startSignal.countDown();
        // wait for all to finish
        doneSignal.await();
        System.out.println("all threads done");
    }
}

class Worker implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
            doWork();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            doneSignal.countDown();
        }
    }

    private void doWork() {
        System.out.println(Thread.currentThread().getName() + " work");
    }
}
