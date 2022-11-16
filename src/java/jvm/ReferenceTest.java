package jvm;

import java.lang.ref.*;

/**
 * @author liuxucheng
 * @since 2022/8/29
 */
public class ReferenceTest {

    public static void main(String[] args) {
        ReferenceQueue<Object> rq = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(new Object(), rq);
        System.out.println(weakReference.get());
        System.out.println(rq.poll());
        System.gc();
        System.out.println(weakReference.get());
        System.out.println(rq.poll());

        System.out.println("-------------------");
        PhantomReference<Object> phantomReference = new PhantomReference<>(new Object(), rq);
        System.gc();
        Reference reference = rq.poll();
        // 对于虚引用，gc不会自动清理referent，需要手动clear，或等到虚引用本身不可达
        reference.clear();
    }
}
