package jvm;

import java.lang.ref.*;

/**
 * @author liuxucheng
 * @since 2022/8/29
 */
public class ReferenceTest {

    public static void main(String[] args) {
        ReferenceQueue<Object> rq = new ReferenceQueue<>();
//        WeakReference<Object> weakReference = new WeakReference<>(new Object(), rq);
//
//        System.gc();
//
//        System.out.println(weakReference.get());
//        Reference<?> reference;
//        for (int i = 0; ; i++) {
//            reference = rq.poll();
//            System.out.println(i);
//            System.out.println(reference);
//            if (reference != null) {
//                System.out.println(reference == weakReference);
//                System.out.println(reference.get());
//                break;
//            }
//        }

        PhantomReference<Object> phantomReference = new PhantomReference<>(new Object(), rq);
        System.gc();
        for (int i = 0; ; i++) {
            Reference<?> reference = rq.poll();
//            System.out.println(i);
//            System.out.println(reference);
            if (reference != null) {
                System.out.println("poll");
                break;
            }
        }
    }
}
