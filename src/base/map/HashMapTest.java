package base.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author xucheng.liu
 * @since 2022/6/12
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
    }
}
