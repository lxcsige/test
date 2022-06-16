package concurrency.lock.producerAndConsumer.lockAndCondition;

/**
 * @author xucheng.liu
 * @since 2022/4/27
 */
public class Producer implements Runnable {

    private BoundedBuffer boundedBuffer;

    public Producer(BoundedBuffer boundedBuffer) {
        this.boundedBuffer = boundedBuffer;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boundedBuffer.put(new Object());
        }
    }
}
