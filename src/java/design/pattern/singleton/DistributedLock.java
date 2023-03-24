package design.pattern.singleton;

/**
 * 分布式锁
 *
 * @author liuxucheng
 * @since 2022/12/22
 */
public interface DistributedLock {

    /**
     * 加锁
     */
    void lock();

    /**
     * 解锁
     */
    void unlock();
}
