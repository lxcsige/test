package design.pattern.iterator;

import java.util.*;
import java.util.Iterator;

/**
 * @author liuxucheng
 * @since 2023/1/16
 */
public class Client {

    public static void main(String[] args) {
        // ArrayList
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ListIterator<Integer> it = list.listIterator(list.size());
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }

        // LinkedList
        List<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ListIterator<Integer> it2 = ll.listIterator(ll.size());
        while (it2.hasPrevious()) {
            System.out.println("previous = " + it2.previous());
            it2.add(5);
        }
    }
}
