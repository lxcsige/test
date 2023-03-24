package design.pattern.singleton;

/**
 * 线程唯一单例
 *
 * @author liuxucheng
 * @since 2022/12/22
 */
public class ThreadLocalSingleton {

    private static final ThreadLocal<ThreadLocalSingleton> INSTANCE_HOLDER = ThreadLocal.withInitial(ThreadLocalSingleton::new);

    private ThreadLocalSingleton() {

    }

    public static ThreadLocalSingleton getInstance() {
        return INSTANCE_HOLDER.get();
    }
}
