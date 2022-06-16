package jmm;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CPU cache line伪共享问题测试
 * 测试结果：未填充-26780072958ms，填充-5302667300m，耗时大概只有未填充的1/5
 *
 * @author xucheng.liu
 * @since 2022/4/13
 */
public class FalseSharingTest {

    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final static int ARRAY_INDEX = 5;
    private final static VolatileLong3[] LONGS = new VolatileLong3[ARRAY_INDEX];

    public static void main(final String[] args) {
        // 初始化变量数组
        for (int i = 0; i < LONGS.length; i++) {
            LONGS[i] = new VolatileLong3();
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        long start = System.nanoTime();
        // ARRAY_INDEX个线程，每个线程对数组某一个index中的value反复进行赋值
        for (int i = 0; i < ARRAY_INDEX; i++) {
            int finalI = i;
            threadPoolExecutor.submit(() -> {
                long i1 = ITERATIONS + 1;
                while (0 != --i1) {
                    LONGS[finalI].value = i1;
                }
            });
        }
        // 判断线程池任务是否完毕
        do {
            threadPoolExecutor.shutdown();
        } while (!threadPoolExecutor.isTerminated());
        System.out.println("duration = " + (System.nanoTime() - start));
    }

    /**
     * 未填充
     */
    public final static class VolatileLong {
        public volatile long value = 0L;
    }

    /**
     * 填充
     */
    public final static class VolatileLong2 {
        //以及基本类型的long占用8个字节
        volatile long p0, p1, p2, p3, p4, p5, p6;
        public volatile long value = 0L;
    }

    /**
     * jdk8中的注解
     * 添加vm options参数  -XX:-RestrictContended
     */
    @sun.misc.Contended
    public final static class VolatileLong3 {
        public volatile long value = 0L;
    }
}
