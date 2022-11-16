package CacheTest;

/**
 * Created by lxcfour on 2017/11/1.
 */
public class Solution {

    public static void main(String[] args) {
        int[][] array = new int[1024 * 16][1024 * 16];
        for (int i = 0; i < 1024 * 16; i++) {
            for (int j = 0; j < 1024 * 16; j++) {
                array[j][i]++;
            }
        }
    }
}
