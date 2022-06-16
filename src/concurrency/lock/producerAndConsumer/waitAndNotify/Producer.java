package concurrency.lock.producerAndConsumer.waitAndNotify;

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
                boundedBuffer.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
