package MemoryTest;

/**
 * @author xucheng.liu
 * @date 2020/9/22
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("free: " + Runtime.getRuntime().freeMemory() / 1024 / 1024);
        System.out.println("total: " + Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println("max: " + Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println("=============");
        try {
            Thread.sleep(3000);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        String[] strings = new String[2000000];
        System.gc();
        System.out.println("free: " + Runtime.getRuntime().freeMemory() / 1024 / 1024);
        System.out.println("total: " + Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println("max: " + Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println("=============");
        try {
            Thread.sleep(3000);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        for (int i = 0; i < 2000000; i++) {
            strings[i] = new String("aaa");
        }
        System.out.println("free: " + Runtime.getRuntime().freeMemory() / 1024 / 1024);
        System.out.println("total: " + Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println("max: " + Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println("=============");
    }
}
