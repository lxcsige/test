package concurrency;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuxucheng
 * @since 2022/12/14
 */
public class ThreadLocalTest {

    private static final List<Connection> connections = new ArrayList<>();

    private static final ThreadLocal<Connection> connectionLocal = ThreadLocal.withInitial(Connection::new);

    private static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    /**
     * 匿名内部类
     */
    private static final ThreadLocal<String> context = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "";
        }
    };

    public static void main(String[] args) throws InterruptedException {
//        connections.add(connectionLocal.get());
//        Thread thread = new Thread(() -> {
//            connections.add(connectionLocal.get());
//        });
//        thread.start();
//        while(connections.size() < 2) {
//            Thread.sleep(1000);
//        }
//        // 不同线程中的connection是不一样的，即一个线程一个实例
//        System.out.println(connections.get(0) == connections.get(1));
//
//        AtomicInteger hashCode = new AtomicInteger(Integer.MAX_VALUE);
//        System.out.println("next hashCode = " + hashCode.addAndGet(0x61c88647));

        ThreadLocal<Integer> t1 = new ThreadLocal<>();
        ThreadLocal<Integer> t2 = new ThreadLocal<>();
        ThreadLocal<Integer> t3 = new ThreadLocal<>();
        ThreadLocal<Integer> t4 = new ThreadLocal<>();
        ThreadLocal<Integer> t5 = new ThreadLocal<>();
        ThreadLocal<Integer> t6 = new ThreadLocal<>();
        ThreadLocal<Integer> t7 = new ThreadLocal<>();
        ThreadLocal<Integer> t8 = new ThreadLocal<>();
        ThreadLocal<String> t9 = new ThreadLocal<>();
        ThreadLocal<String> t10 = new ThreadLocal<>();

        t1.get();
        t2.get();
        t3.get();
        t4.get();
        t5.get();
        t6.get();
        t7.get();
        t8.get();
        t9.get();
        t10.get();
    }
}
