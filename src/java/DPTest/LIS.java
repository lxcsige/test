package DPTest;

/**
 * User: lxcfour
 * Date: 2018/5/14
 * Time: 下午5:15
 */
public class LIS {

    public int lis(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int res = 1;
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (res < dp[i]) {
                res = dp[i];
            }
        }

        return res;
    }
}
