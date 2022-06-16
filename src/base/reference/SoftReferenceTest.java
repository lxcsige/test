package base.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author xucheng.liu
 * @since 2022/3/28
 */
public class SoftReferenceTest {

    public static void main(String[] args) {
        Object counter = new Object();
        ReferenceQueue refQueue = new ReferenceQueue<>();
        SoftReference p = new SoftReference<>(counter, refQueue);
        counter = null;
        System.gc();
        try {
            // object实例对象未被gc
            Reference ref = refQueue.remove(10000L);
            if (ref != null) {
                System.out.println("referenceQueue");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
