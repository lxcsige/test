package concurrency.synchronize;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @author xucheng.liu
 * @since 2022/4/18
 */
public class ProducerAndConsumer {

    private static BlockingQueue<Object> queue = new LinkedBlockingQueue<>(100);

    public static void main(String[] args) throws InterruptedException {
        Thread consumer = new Thread(() -> {
            synchronized (queue) {
                int i = 0;
                while (queue.isEmpty()) {
                    i++;
                    System.out.println("queue is empty, i = " + i);
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("interruptedException, i = " + i);
                    }
                }
                try {
                    System.out.println("consume: " + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        consumer.start();

        Thread.sleep(5000);

        Thread producer = new Thread(() -> {
            synchronized (queue) {
                System.out.println("producer get lock");
                while(true) {
                    // 拿到锁后自旋
                }
            }
        });
        producer.start();

        Thread.sleep(5000);

        Object blocker = LockSupport.getBlocker(consumer);

        consumer.interrupt();
    }
}
