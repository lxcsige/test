package ConcurrentTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: lxcfour
 * Date: 2018/2/26
 * Time: 下午7:55
 */
public class Test {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>(17);
//        map = new HashMap<>();
        new Thread("thread-1") {
            @Override
            public void run() {
                map.put(1, 1);
            }
        }.start();

        new Thread("thread-1") {
            @Override
            public void run() {
                map.put(1, 2);
            }
        }.start();
    }
}
