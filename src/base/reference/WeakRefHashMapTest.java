package base.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xucheng.liu
 * @since 2022/3/28
 */
public class WeakRefHashMapTest {

    private static ReferenceQueue<byte[]> rq = new ReferenceQueue<>();

    private static int _1M = 1024*1024;

    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        Object value = new Object();

        byte[] bytes = new byte[_1M];
        WeakReference<byte[]> weakReference = new WeakReference<>(bytes, rq);
        map.put(weakReference, value);

        System.gc();

        System.out.println(map.get(weakReference));
    }
}
