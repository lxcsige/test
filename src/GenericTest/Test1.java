package GenericTest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/**
 * User: lxcfour
 * Date: 2018/3/14
 * Time: 下午7:34
 */
public class Test1 {

    public static void main(String[] args) {
        List<?> list = new ArrayList<>();
        test(list);
    }

    public static void test(List<?> list) {
        final List list1 = list;
        list1.add(1);
        int len = list.size();
    }

    public static void reverse(List<?> list) {
        int size = list.size();
        if (size < 18 || list instanceof RandomAccess) {
            for (int i=0, mid=size>>1, j=size-1; i<mid; i++, j--)
                swap(list, i, j);
        } else {
            ListIterator fwd = list.listIterator();
            ListIterator rev = list.listIterator(size);
            for (int i=0, mid=list.size()>>1; i<mid; i++) {
                Object tmp = fwd.next();
                fwd.set(rev.previous());
                rev.set(tmp);
            }
        }
    }

    public static void swap(List<?> list, int i, int j) {
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
//        list.set(i, list.set(j, list.get(i)));
    }
}
