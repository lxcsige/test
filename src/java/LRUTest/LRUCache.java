package LRUTest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by liuxucheng on 2018/2/28.
 */
public class LRUCache<K, V> {

    private final int maxCacheSize;

    private static final float LOAD_FACTOR = 0.75f;

    private LinkedHashMap<K, V> map;

    public LRUCache(int cacheSize) {
        maxCacheSize = cacheSize;
        int initialCapacity = (int) Math.ceil((cacheSize / LOAD_FACTOR) + 1);
        map = new LinkedHashMap<K, V>(initialCapacity, LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return map.size() > maxCacheSize;
            }
        };
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized V remove(K key) {
        return map.remove(key);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int size() {
        return map.size();
    }
}
