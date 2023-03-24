package concurrency.lock.cyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liuxucheng
 * @since 2023/3/6
 */
public class Solver {

    final int N;

    final float[][] data;

    final CyclicBarrier barrier;

    class Worker implements Runnable {
        int myRow;

        Worker(int row) {
            myRow = row;
        }

        @Override
        public void run() {
            while (!done()) {
                processRow(myRow);
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException ex) {
                    return;
                }
            }
        }
    }

    public Solver(float[][] matrix) throws InterruptedException {
        data = matrix;
        N = matrix.length;
        barrier = new CyclicBarrier(N, this::mergeRows);

        List<Thread> threads = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            Thread thread = new Thread(new Worker(i));
            threads.add(thread);
            thread.start();
        }

        // wait until done
        for (Thread thread : threads) {
            thread.join();
        }
    }

    /**
     * 处理单行
     *
     * @param rowId
     */
    private void processRow(int rowId) {

    }

    /**
     * 合并结果
     */
    private void mergeRows() {

    }

    /**
     * 是否处理完成
     *
     * @return
     */
    private boolean done() {
        return true;
    }
}
