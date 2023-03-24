package concurrency.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author liuxucheng
 * @since 2023/2/16
 */
public class AqsTest {

    private static final Node node = new Node();

    private static Unsafe unsafe;

    private static long statusOffset;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            statusOffset = unsafe.objectFieldOffset
                    (Node.class.getDeclaredField("status"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static class Node {

        volatile int status;
    }

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                int ws;
                while (true) {
                    if ((ws = node.status) == -1
                            || (ws <= 0 && compareAndSetStatus(node, ws, -1))) {
                        System.out.println("status = " + node.status);
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                node.status = 1;
            }
        };
        t1.start();
        t2.start();
    }

    private static boolean compareAndSetStatus(Node node,
                                               int expect,
                                               int update) {
        return unsafe.compareAndSwapInt(node, statusOffset, expect, update);
    }
}
