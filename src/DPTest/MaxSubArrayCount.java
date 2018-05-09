package DPTest;

/**
 * Created by liuxucheng on 2018/4/9.
 * description: 最大连续子序列和，如果所有整数都是负数，则最大子序列和为0
 * 需要注意数组全部为负的情况
 */
public class MaxSubArrayCount {

    public static void main(String[] args) {
        MaxSubArrayCount solution = new MaxSubArrayCount();
        int[] arr= {4, -3, 5, -2, -1, 2, 6, -2};
//        System.out.println(solution.handle1(arr, 0, 7));
        System.out.println(solution.handle2(arr));
    }

    private int handle1(int[] arr, int low, int high) {
        if (low == high) {
            return arr[low] > 0 ? arr[low] : 0;
        }

        int mid = (low + high) / 2;
        int maxLowSum = handle1(arr, low, mid); // 左边最大连续子序列和
        int maxHighSum = handle1(arr, mid + 1, high); // 右边最大连续子序列和

        // 包含左边最右元素和右边最左元素的最大子序列和
        int maxLowBorderSum, lowBorderSum;
        maxLowBorderSum = lowBorderSum = 0;
        for (int i = mid; i >= low; i--) {
            lowBorderSum += arr[i];
            if (lowBorderSum > maxLowBorderSum) {
                maxLowBorderSum = lowBorderSum;
            }
        }

        int maxHighBorderSum, highBorderSum;
        maxHighBorderSum = highBorderSum = 0;
        for (int i = mid + 1; i <= high; i++) {
            highBorderSum += arr[i];
            if (highBorderSum > maxHighBorderSum) {
                maxHighBorderSum = highBorderSum;
            }
        }

        int maxSum = maxLowBorderSum + maxHighBorderSum;
        if (maxLowSum > maxSum ) {
            maxSum = maxLowSum;
        }
        if (maxHighSum > maxSum) {
            maxSum = maxHighSum;
        }

        return maxSum;
    }

    private int handle2(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
