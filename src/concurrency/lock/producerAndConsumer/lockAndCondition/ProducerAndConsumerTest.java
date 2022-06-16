package concurrency.lock.producerAndConsumer.lockAndCondition;

/**
 * @author xucheng.liu
 * @since 2022/4/27
 */
public class ProducerAndConsumerTest {

    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer boundedBuffer = new BoundedBuffer();

        // 生产者线程
        Thread t1 = new Thread(new Producer(boundedBuffer));
        Thread t2 = new Thread(new Producer(boundedBuffer));
        Thread t3 = new Thread(new Producer(boundedBuffer));
        t1.start();
        t2.start();
        t3.start();

        // 消费者线程
        Thread t4 = new Thread(new Consumer(boundedBuffer));
        Thread t5 = new Thread(new Consumer(boundedBuffer));
        t4.start();
        t5.start();

        Thread.sleep(10000);
        // 86
        System.out.println(boundedBuffer.counter);
    }
}
