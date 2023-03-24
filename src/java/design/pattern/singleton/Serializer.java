package design.pattern.singleton;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public interface Serializer {

    /**
     * 序列化
     *
     * @param object
     * @return
     */
    String serialize(Object object);

    /**
     * 反序列化
     *
     * @param string
     * @return
     */
    Object deserialize(String string);
}
