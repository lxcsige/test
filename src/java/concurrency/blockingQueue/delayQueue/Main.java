package concurrency.blockingQueue.delayQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuxucheng
 * @since 2023/3/8
 */
public class Main {

    private static final BlockingQueue<DelayedTask> queue = new DelayQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            DelayedTask delayedTask = new DelayedTask("task-" + i, 1000);
            queue.offer(delayedTask);
        }

//        ExecutorService screenPool = Executors.newFixedThreadPool(100);
//        for (int i = 0; i < 100; i++) {
//            screenPool.submit(new Screener());
//        }

        ExecutorService takePool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            takePool.submit(new Consumer());
        }
        Thread.sleep(10000);
        takePool.shutdownNow();
//        screenPool.shutdownNow();
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    DelayedTask task = queue.take();
                    System.out.println("Thread: " + Thread.currentThread().getName()
                            + ", currentTime: " + System.currentTimeMillis() + ", " + task);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private static class Screener implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                queue.peek();
            }
        }
    }
}
