package ReferenceTest;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by liuxucheng on 2018/2/25.
 */
public class Test {

    public static void main(String[] args) {
        WeakReference<String> wr = new WeakReference<String>("hello");
        System.out.println(wr.get());
        SoftReference<String> sr = new SoftReference<String>("world");
        System.gc();
        System.out.println(sr.get());
    }
}
