package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子操作测试
 *
 * @author xucheng.liu
 * @since 2022/4/14
 */
public class AtomicTest {

    private static int count;

    private static volatile int countVolatile;

    private static AtomicInteger atom = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        count++;
                        atom.getAndIncrement();
                        countVolatile++;
                    }
                }
            }.start();
        }

        System.out.println("count = " + count);
        System.out.println("atomicCount = " + atom);
        System.out.println("countVolatile = " + countVolatile);
    }
}
