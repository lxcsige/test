package io.nioTest;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author xucheng.liu
 * @since 2022/3/20
 */
public class CleanerTest extends PhantomReference<Object> {

    private static final ReferenceQueue<Object> dummyQueue = new ReferenceQueue<>();

    /**
     * 双向队列头
     */
    private static CleanerTest first = null;

    private CleanerTest next = null;
    private CleanerTest prev = null;

    private final Runnable thunk;

    private CleanerTest(Object referent, Runnable thunk) {
        super(referent, dummyQueue);
        this.thunk = thunk;
    }

    /**
     * 将cleaner对象加入到队列头
     *
     * @param cleaner
     * @return
     */
    public static synchronized CleanerTest add(CleanerTest cleaner) {
        if (first != null) {
            cleaner.next = first;
            first.prev = cleaner;
        }

        first = cleaner;
        return cleaner;
    }

    /**
     * 将cleaner对象移出队列
     *
     * @param cleaner
     * @return
     */
    public static synchronized boolean remove(CleanerTest cleaner) {
        if (cleaner.next == cleaner) {
            return false;
        }

        // 需要删除的节点是头节点，需要更新first指针
        if (first == cleaner) {
            if (cleaner.next != null) {
                first = cleaner.next;
            } else {
                // 感觉没必要进行这步判断
                first = cleaner.prev;
            }
        }

        // 当需要删除的节点是头节点，这步相当于把更新后的first节点的prev置为null
        if (cleaner.next != null) {
            cleaner.next.prev = cleaner.prev;
        }
        if (cleaner.prev != null) {
            cleaner.prev.next = cleaner.next;
        }

        // 将cleaner的next和prev都指向自己，下次再remove直接返回false，因此remove方法是幂等的
        cleaner.next = cleaner;
        cleaner.prev = cleaner;

        return true;
    }

    /**
     * 静态构造方法
     *
     * @param referent
     * @param thunk
     * @return
     */
    public static CleanerTest create(Object referent, Runnable thunk) {
        return thunk == null ? null : add(new CleanerTest(referent, thunk));
    }

    /**
     * 执行清理动作
     */
    public void clean() {
        if (remove(this)) {
            try {
                this.thunk.run();
            } catch (Throwable e) {
                AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
                    if (System.err != null) {
                        (new Error("Cleaner terminated abnormally", e)).printStackTrace();
                    }

                    System.exit(1);
                    return null;
                });
            }
        }
    }
}
