package design.pattern.singleton;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public class DefaultStorage implements SharedObjectStorage {

    @Override
    public void save(Class<?> clazz, String serialized) {

    }

    @Override
    public String load(Class<?> clazz) {
        return null;
    }
}
