package TwoDArrayTest;

/**
 * User: lxcfour
 * Date: 2018/3/30
 * Time: 下午8:34
 * Description: 二维数组，每行每列都从小到大排列，判断是否包含某个整数
 */
public class Solution {

    public boolean handle(int[][] arr, int k) {
        if (arr.length == 0 || arr[0].length == 0) {
            return false;
        }

        int height = arr.length;
        int width = arr[0].length;

        int m = width - 1;
        int n = 0;

        while (m >= 0 && n < height) {
            if (k < arr[n][m]) {
                m--;
            } else if (k > arr[n][m]) {
                n++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 2, 8, 9}, {2 ,4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(solution.handle(arr, 20));
    }
}
