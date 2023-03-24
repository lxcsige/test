package concurrency.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author liuxucheng
 * @since 2023/2/15
 */
public class UnsafeTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        System.out.println(unsafe.objectFieldOffset(Thread.class.getDeclaredField("parkBlocker")));
    }
}
