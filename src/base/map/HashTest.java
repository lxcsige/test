package base.map;

/**
 * @author xucheng.liu
 * @since 2022/3/24
 */
public class HashTest {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        String key = "Hello World, Test";
        int hashCode = key.hashCode();
        System.out.println(hashCode);
        System.out.println(Integer.toBinaryString(hashCode));
        System.out.println(Integer.toBinaryString(hashCode >>> 16));
        int hash = hash(key);
        System.out.println(Integer.toBinaryString(hash));

        System.out.println(tableSizeFor(15));
    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
