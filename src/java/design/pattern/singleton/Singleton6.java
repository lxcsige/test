package design.pattern.singleton;

/**
 * 集群唯一单例
 *
 * @author liuxucheng
 * @since 2022/12/22
 */
public class Singleton6 {

    private static Singleton6 INSTANCE;

    private static final DistributedLock LOCK = new RedisDistributedLock();

    private static final Serializer SERIALIZER = new DefaultSerializer();

    private static final SharedObjectStorage STORAGE = new DefaultStorage();

    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        if (INSTANCE == null) {
            // 加锁，释放实例之前不解锁
            LOCK.lock();
            if (INSTANCE == null) {
                String serialized = STORAGE.load(Singleton6.class);
                if (serialized == null) {
                    INSTANCE = new Singleton6();
                } else {
                    INSTANCE = (Singleton6) SERIALIZER.deserialize(serialized);
                }
            }
        }
        return INSTANCE;
    }

    public static void freeInstance() {
        String serialized = SERIALIZER.serialize(INSTANCE);
        STORAGE.save(Singleton6.class, serialized);
        // 释放对象
        INSTANCE = null;
        // 解锁
        LOCK.unlock();
    }
}
