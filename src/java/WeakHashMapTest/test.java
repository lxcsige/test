package WeakHashMapTest;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by lxcfour on 16/7/25.
 */
public class test {
    private static Map<String, byte[]> caches = new WeakHashMap<>();

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 100000; i++) {
//            caches.put(i + "", new byte[1024 * 1024 * 10]);
//            System.out.println("put num: " + i + "， caches size:" + caches.size());
//        }

        Person p = new Person();
        ReferenceQueue<Person> referenceQueue = new ReferenceQueue<>();
        WeakReference<Person> q = new WeakReference<>(p, referenceQueue);
        p = null;
        System.gc();
        TimeUnit.SECONDS.sleep(10);
        Object a = referenceQueue.poll();
        System.out.println(a instanceof WeakReference);
    }
}
