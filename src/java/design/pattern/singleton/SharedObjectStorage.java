package design.pattern.singleton;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public interface SharedObjectStorage {

    /**
     * 保存对象序列化后的字符串
     *
     * @param clazz
     * @param serialized
     */
    void save(Class<?> clazz, String serialized);

    /**
     * 获取对象序列化后的字符串
     *
     * @param clazz
     * @return
     */
    String load(Class<?> clazz);
}
