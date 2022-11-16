package SetTest;

import java.util.*;

/**
 * User: lxcfour
 * Date: 2018/5/13
 * Time: 下午2:34
 */
public class Test {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(5);
//        Iterator<Integer> it = set.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        Thread readThread = new Thread(){
            @Override
            public void run() {
                System.out.println("read start");
                for (Integer i : list) {
                    System.out.println(i);
                }
                System.out.println("read end");
            }
        };

        Thread writeThread = new Thread() {
            @Override
            public void run() {
                System.out.println("write start");
                for (int i = 99; i > 0; i--) {
                    list.remove(i);
                }
                System.out.println("write end");
            }
        };

        readThread.start();
        writeThread.start();
    }
}
