package concurrency.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CLH锁
 *
 * @author liuxucheng
 * @since 2023/2/15
 */
public class ClhLock {

    private final AtomicReference<Node> tail = new AtomicReference<>(new Node());

    private final ThreadLocal<Node> cur = ThreadLocal.withInitial(Node::new);

    static final class Node {

        /**
         * 前驱节点
         */
        Node prev;

        /**
         * 锁状态，true-正在等锁或已经抢到锁，false-已经释放锁
         * 修改之后需要立即对后继节点可见
         */
        volatile boolean locked;
    }

    /**
     * 加锁，未抢到锁则自旋等待
     */
    public void lock() {
        Node node = cur.get();
        // 表示当前线程正在抢锁或已经抢到锁
        node.locked = true;
        node.prev = tail.getAndSet(node);
        // 自旋等待
        while (node.prev.locked) {
            System.out.println("线程" + Thread.currentThread().getName() + "正在等待");
        }
        System.out.println("线程" + Thread.currentThread().getName() + "抢到了锁");
    }

    /**
     * 解锁
     */
    public void unlock() {
        Node node = cur.get();
        node.locked = false;
        System.out.println("线程" + Thread.currentThread().getName() + "释放了锁");
        cur.remove();
        // 当前节点解锁之后不需要再关注前驱节点的状态
        // help gc
        node.prev = null;
    }
}
