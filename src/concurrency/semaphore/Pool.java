package concurrency.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author xucheng.liu
 * @since 2022/5/3
 */
public class Pool {

    /**
     * 资源数组
     */
    protected Object[] items = new Object[MAX_AVAILABLE];
    /**
     * 资源对应的使用情况，true-已被使用，false-未被使用
     */
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    private static final int MAX_AVAILABLE = 100;
    /**
     * 初始化一个信号量，设置为公平锁模式，总资源数为100个
     */
    private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    /**
     * 获取资源，比如数据库连接
     *
     * @return
     * @throws InterruptedException
     */
    public Object getItem() throws InterruptedException {
        // 首选需要获取信号量，若当前剩余permit等于0，则阻塞线程
        available.acquire();
        // 获取下一个可获取的资源
        return getNextAvailableItem();
    }

    /**
     * 释放资源，比如数据库连接
     *
     * @param x
     */
    public void putItem(Object x) {
        // 将对应的资源标记为未使用状态
        if (markAsUnused(x)) {
            // 同时也需要释放信号量
            available.release();
        }
    }

    /**
     * 可能存在多个线程更新used数组，因此需要加互斥锁保护临界资源
     *
     * @return
     */
    protected synchronized Object getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        // not reached
        return null;
    }

    /**
     * 可能存在多个线程更新used数组，因此需要加互斥锁保护临界资源
     *
     * @return
     */
    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (item == items[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
