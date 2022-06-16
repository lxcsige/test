package concurrency.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author xucheng.liu
 * @since 2022/4/24
 */
public class CLHLock {

    /**
     * CLH锁节点
     */
    private static class CLHNode {
        // 锁状态：默认为false，表示线程没有获取到锁；true表示线程获取到锁或正在等待
        // 为了保证locked状态是线程间可见的，因此用volatile关键字修饰
        volatile boolean locked = false;
    }

    /**
     * 尾结点，总是指向最后一个CLHNode节点
     */
    private final AtomicReference<CLHNode> tailNode;

    /**
     * 前驱节点
     */
    private final ThreadLocal<CLHNode> predNode;

    /**
     * 后继节点
     */
    private final ThreadLocal<CLHNode> curNode;

    public CLHLock() {
        // 初始化时尾结点指向一个空的CLH节点
        tailNode = new AtomicReference<>(new CLHNode());
        // 初始化当前的CLH节点
        curNode = ThreadLocal.withInitial(CLHNode::new);
        // 初始化前继节点，注意此时前继节点没有存储CLHNode对象，存储的是null
        predNode = new ThreadLocal<>();
    }

    /**
     * 获取锁
     */
    public void lock() {
        // 取出当前线程ThreadLocal存储的当前节点，初始化值总是一个新建的CLHNode，locked状态为false
        CLHNode currNode = curNode.get();
        // 此时把lock状态置为true，表示获取到了锁或正在等待锁的状态
        currNode.locked = true;
        // 将尾结点取出来赋值给当前线程的前继节点，再把当前线程的当前节点赋值给尾节点
        // AtomicReference可以防止并发问题
        CLHNode preNode = tailNode.getAndSet(currNode);
        predNode.set(preNode);
        // 【1】若前继节点的locked状态为false，则表示获取到了锁，不用自旋等待
        // 【2】若前继节点的locked状态为true，则表示前一线程获取到了锁或者正在等待，自旋等待
        while (preNode.locked) {
            System.out.println("线程 " + Thread.currentThread().getName() + " 没能获取到锁，进行自旋等待。。。");
            Thread.yield();
        }
        // 能执行到这里，说明当前线程获取到了锁
        System.out.println("线程 " + Thread.currentThread().getName() + " 获取到了锁！！！");
    }

    /**
     * 释放锁
     */
    public void unLock() {
        // 获取当前线程的当前节点
        CLHNode node = curNode.get();
        // 进行解锁，将locked至为false，此时执行了lock方法正在自旋等待的后继节点将会获取到锁
        node.locked = false;
        System.out.println("线程 " + Thread.currentThread().getName() + " 释放了锁！！！");

        // 必不可少
        curNode.set(predNode.get());
    }
}
