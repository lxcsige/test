package base.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxucheng
 * @since 2023/1/31
 */
public class IteratorTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("remove: " + list.remove(i));
        }
        // ConcurrentModificationException
        for (Integer integer : list) {
            list.remove(integer);
        }
    }
}
