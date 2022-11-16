package HashMapTest;

import java.util.HashMap;
import java.util.Map;

/**
 * User: lxcfour
 * Date: 2018/3/23
 * Time: 下午2:21
 * description: 多线程写hashMap，导致扩容时环链的例子
 */
public class ResizeTest {

    private static  Map<Integer, Integer> map = new HashMap<>(2, 0.75f);

    public static void main(String[] args) {
        map.put(5, 55);

        new Thread("Thread1") {
            @Override
            public void run() {
                map.put(7, 77);
                System.out.println(map);
            }
        }.start();

        new Thread("Thread2") {
            @Override
            public void run() {
                map.put(3, 33);
                System.out.println(map);
            }
        }.start();
    }
}
