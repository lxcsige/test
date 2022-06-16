package base.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author xucheng.liu
 * @since 2022/3/28
 */
public class PhantomReferenceTest {

    public static void main(String[] args) {
        Object counter = new Object();
        ReferenceQueue refQueue = new ReferenceQueue<>();
        PhantomReference p = new PhantomReference<>(counter, refQueue);
        counter = null;
        System.gc();
        try {
            Thread.sleep(10000);
            // Remove是一个阻塞方法，可以指定timeout，或者选择一直阻塞
            Reference ref = refQueue.remove(1000L);
            if (ref != null) {
                System.out.println("referenceQueue");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
