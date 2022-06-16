package HashMapMemoryTest;

import java.util.HashMap;

/**
 * @author xucheng.liu
 * @date 2020/9/22
 */
public class Solution {

    public static void main(String[] args) {
        double start = 0;
        double end = 0;
        System.gc();
        start = Runtime.getRuntime().freeMemory();
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            hashMap.put(i, 128);
            if(i % 10000 == 0) {
                end = Runtime.getRuntime().freeMemory();
                System.out.println("start: " + start);
                System.out.println("end: " + end);
                System.out.println("HashMap对象占内存：" + (end - start) + " byte");
                System.out.println("HashMap对象占内存：" + (end - start) / (1024 * 1024) + " M");
            }
        }
        end = Runtime.getRuntime().freeMemory();
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println("HashMap对象占内存：" + (end - start) + " byte");
        System.out.println("HashMap对象占内存：" + (end - start) / (1024 * 1024) + " M");
        System.out.println("----------清除了没有对象引用的对象");
        System.gc();

        end = Runtime.getRuntime().freeMemory();
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println("HashMap对象占内存：" + (end - start) + " byte");
        System.out.println("HashMap对象占内存：" + (end - start) / (1024 * 1024) + " M");
    }

}
