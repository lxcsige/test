package ProducerAndConsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liuxucheng on 2018/3/10.
 */
public class Test {

    private static final int CAPACITY = 16;

    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(new Producer(), "producer-thread");
        producer.start();
        Thread notify = new Thread(new Consumer(), "consumer-thread");
        notify.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            while(true) {
                synchronized (queue) {
                    while (queue.size() == CAPACITY) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    queue.offer(1);
                    System.out.println("produce 1");
                    queue.notify();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    queue.poll();
                    System.out.println("consume 1");
                    queue.notify();
                }
            }
        }
    }
}
