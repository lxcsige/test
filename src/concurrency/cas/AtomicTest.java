package concurrency.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author xucheng.liu
 * @since 2022/4/19
 */
public class AtomicTest {

    private volatile int count = 0;

    private static Unsafe unsafe;

    private static long stateOffset;

    static {

        try {
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            unsafe = (Unsafe) unsafeField.get(null);

            stateOffset = unsafe.objectFieldOffset(AtomicTest.class.getDeclaredField("count"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
        AtomicTest atomicTest = new AtomicTest();

        new Thread(() -> {
            System.out.println("Thread 1 begin");
            while(true) {
                if (atomicTest.count > 0) {
                    System.out.println("Thread 1 count =" + atomicTest.count);
                    break;
                }
            }
            System.out.println("Thread 1 end");
        }).start();

        new Thread(() -> {
            unsafe.compareAndSwapInt(atomicTest, stateOffset, 0, 10);
            System.out.println("Thread2 count = " + atomicTest.count);
        }).start();
    }
}
