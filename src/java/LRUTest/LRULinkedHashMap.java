package LRUTest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: lxcfour
 * Date: 2018/2/28
 * Time: 下午9:51
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int maxCapacity;

    private static final float LOAD_FACTOR = 0.75F;

    public LRULinkedHashMap(int maxCapacity) {
        super(maxCapacity, LOAD_FACTOR, true);
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
