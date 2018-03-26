package HashMapTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * User: lxcfour
 * Date: 2018/3/25
 * Time: 下午4:01
 */
public class SynchronizedMapTest {

    public static void main(String[] args) {
        Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<Integer, Integer>());
    }
}
