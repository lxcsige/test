package base.reference;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author xucheng.liu
 * @since 2022/3/28
 */
public class WeakHashMapTest {

    public static void main(String[] args) throws InterruptedException {
        Map<String, String> map = new WeakHashMap<>();
        String key1 = new String("1");
        String key2 = new String("2");
        String key3 = new String("3");
        String key4 = "4";

        map.put(key1, "1");
        map.put(key2, "2");
        map.put(key3, "3");
        map.put(key4, "4");

        key1 = null;
        key4 = null;
        System.gc();

        Thread.sleep(100);

        System.out.println(map.size());
    }
}
