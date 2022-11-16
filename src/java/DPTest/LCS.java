package DPTest;

/**
 * User: lxcfour
 * Date: 2018/5/8
 * Time: 下午6:51
 */
public class LCS {
    public int lcs(int[] x, int[] y) {
        if (x.length == 0 || y.length == 0) {
            return 0;
        }

        int[][] c = new int[x.length][y.length];
        // 1 - 左上，2 - 上，3 - 左
        int[][] direction = new int[x.length][y.length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                if (i == 0 || j == 0) {
                    if (x[i] == y[i]) {
                        c[i][j] = 1;
                        direction[i][j] = 1;
                    } else {
                        if (i > 0) {
                            c[i][j] = c[i - 1][j] + 1;
                            direction[i][j] = 2;
                        }
                        if (j > 0) {
                            c[i][j] = c[i][j - 1];
                            direction[i][j] = 3;
                        }
                    }
                }else {
                    if (x[i] == y[i]) {
                        c[i][j] = c[i - 1][j - 1] + 1;
                        direction[i][j] = 1;
                    } else if (c[i - 1][j] > c[i][j - 1]) {
                        c[i][j] = c[i - 1][j] + 1;
                        direction[i][j] = 2;
                    } else {
                        c[i][j] = c[i][j - 1] + 1;
                        direction[i][j] = 3;
                    }
                }
            }
        }

        // print最长公共子序列
        print(direction, x, y, x.length - 1, y.length - 1);

        return c[x.length - 1][y.length - 1];
    }

    private void print(int[][] direction, int[] x, int[] y, int row, int col) {
        if (row < 0 || col < 0) {
            return;
        }

        if (direction[row][col] == 1) {
            if (row > 0 && col > 0) {
                print(direction, x, y, row - 1, col - 1);
            }
            System.out.println(x[row]);
        } else if (direction[row][col] == 2) {
            print(direction, x, y, row - 1, col);
        } else if (direction[row][col] == 3) {
            print(direction, x, y, row, col - 1);
        }
    }
}
