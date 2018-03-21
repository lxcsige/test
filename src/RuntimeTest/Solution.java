package RuntimeTest;

/**
 * Created by lxcfour on 2017/9/27.
 */
public class Solution {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Max mem is: " + runtime.maxMemory());
        System.out.println("Total mem is: " + runtime.totalMemory());
        System.out.println("Initial free mem is: " + runtime.freeMemory());
        runtime.gc();
        long mem1 = runtime.freeMemory();
        System.out.println("Free mem after gc is: " + mem1);

        Integer[] intArr = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            intArr[i] = i;
        }
        long mem2 = runtime.freeMemory();
        System.out.println("Free mem after allocation is: " + mem2);
        System.out.println("intArr allocation mem is: " + (mem1 - mem2));

        for (int i = 0; i < 1000; i++) {
            intArr[i] = null;
        }
        runtime.gc();
        System.out.println("Free memory after collecting integers is: " + runtime.freeMemory());
    }
}
