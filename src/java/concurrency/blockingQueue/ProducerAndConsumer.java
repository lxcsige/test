package concurrency.blockingQueue;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuxucheng
 * @since 2023/3/8
 */
public class ProducerAndConsumer {

    private static final AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Item> queue = new LinkedBlockingQueue<>(5);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Producer("producer" + i, queue));
            executorService.submit(new Consumer("consumer" + i, queue));
        }
        Thread.sleep(1000);
        executorService.shutdownNow();
        System.out.println("size of queue = " + queue.size());
        System.out.println("count of operation = " + count.get());
    }

    public static class Producer implements Runnable {

        private String name;

        private BlockingQueue<Item> queue;

        public Producer(String name, BlockingQueue<Item> queue) {
            this.name = name;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    queue.put(new Item());
                    System.out.println("Thread " + name + " produce an item");
                    count.incrementAndGet();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("thread " + name + " stopped");
        }
    }

    public static class Consumer implements Runnable {

        private String name;

        private BlockingQueue<Item> queue;

        public Consumer(String name, BlockingQueue<Item> queue) {
            this.name = name;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    queue.take();
                    System.out.println("Thread " + name + " consume an item");
                    count.incrementAndGet();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("thread " + name + " stopped");
        }
    }

    public static class Item {

        private int id;

        private String name;
    }
}
