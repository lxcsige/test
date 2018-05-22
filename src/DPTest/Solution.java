package DPTest;

/**
 * User: lxcfour
 * Date: 2018/5/8
 * Time: 下午3:01
 */
public class Solution {

    public int maxSquare(int[][] arr) {
        if (arr.length == 0 || arr[1].length == 0) {
            return 0;
        }

        int m = arr.length;
        int n = arr[0].length;
        int maxLen = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] != 0) {
                    arr[i][j] = Math.min(Math.min(arr[i-1][j], arr[i][j-1]), arr[i-1][j-1]) + 1;
                    maxLen = Math.max(maxLen, arr[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }

    public int maxSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m + 1][n + 1];
        int maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    res[i][j] = Math.min(Math.min(res[i - 1][j], res[i][j - 1]), res[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, res[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
}
