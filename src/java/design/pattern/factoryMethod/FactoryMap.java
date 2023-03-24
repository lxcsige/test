package design.pattern.factoryMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxucheng
 * @since 2022/12/22
 */
public class FactoryMap {

    private static final Map<String, Factory> CACHED_FACTORIES = new HashMap<>();

    static {
        CACHED_FACTORIES.put("productA", new FactoryA());
        CACHED_FACTORIES.put("productB", new FactoryB());
    }

    public static Factory getFactory(String arg) {
        return CACHED_FACTORIES.get(arg);
    }
}
