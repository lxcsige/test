package LRUTest;

import java.util.HashMap;

/**
 * Created by liuxucheng on 2018/3/1.
 */
public class LRUCache2<K, V> {

    private int cacheSize;

    private HashMap<K, CacheNode> caches;

    private CacheNode head;

    public LRUCache2(int cacheSize) {
        this.cacheSize = cacheSize;
        this.caches = new HashMap<>((int) Math.ceil(cacheSize / 0.75f) + 1); // 防止扩容
        this.head = new CacheNode(null, null);
        head.before = head.after = head;
    }

    public V get(K key) {
        CacheNode node = caches.get(key);
        if (node == null) {
            return null;
        } else {
            node.remove();
            node.addBefore(head);
            return node.value;
        }
    }

    public void put(K key, V value) {
        CacheNode node = caches.get(key);

        if (node == null) { //不存在
            if (caches.size() >= cacheSize) { //淘汰
                remove(head.after.key);
            }
            node = new CacheNode(key, value);
        } else {
            node.remove(); // 删除前后指针
        }

        node.addBefore(head);
        caches.put(key, node);
    }

    public V remove(K key) {
        CacheNode node = caches.remove(key);

        if (node == null) {
            return null;
        } else {
            node.remove();
        }

        return node.value;
    }

    public void clear() {
        caches.clear();
        head = null;
    }

    private class CacheNode {

        private K key;

        private V value;

        private CacheNode before;

        private CacheNode after;

        public CacheNode() {

        }

        private CacheNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private void addBefore(CacheNode node) {
            before = node.before;
            after = node;
            before.after = this;
            after.before = this;
        }

        private void remove() {
            before.after = after;
            after.before = before;
        }
    }

    public static void main(String[] args) {
        LRUCache2<String, Integer> lruCache = new LRUCache2<>(3);
        lruCache.put("1", 1);
        lruCache.put("2", 2);
        lruCache.put("3", 3);
        lruCache.get("1");
        lruCache.put("2", 5);
        lruCache.put("4", 4);
        System.out.println(lruCache);
    }
}
