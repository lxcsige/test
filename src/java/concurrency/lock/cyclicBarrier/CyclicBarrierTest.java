package concurrency.lock.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liuxucheng
 * @since 2023/3/6
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2,
                () -> System.out.println("barrierAction executed, thread is " + Thread.currentThread().getName()));
        Runnable r = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " before await");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " after await");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i <= 6; i++) {
            new Thread(r).start();
        }
    }
}
