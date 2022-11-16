package LRUTest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: lxcfour
 * Date: 2018/2/28
 * Time: 下午6:02
 */
public class Test {

    protected static int MAX_CAPACITY = 5;

    protected static float LOAD_FACTOR = 0.75F;

    public static void main(String[] args) {
        Map<String, String> cacheMap = new LinkedHashMap<>(MAX_CAPACITY, LOAD_FACTOR, true);
    }
}
