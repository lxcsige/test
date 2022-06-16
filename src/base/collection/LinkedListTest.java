package base.collection;

import java.util.LinkedList;

/**
 * @author xucheng.liu
 * @since 2022/3/24
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}
