package Test;

/**
 * Created by liuxucheng on 2018/4/19.
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 3, 3, 1, 3};
        Solution solution = new Solution();
        System.out.println(solution.handle(arr));
    }

    private int handle(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }

        int count = 0;

        // 寻找波峰，并记录在原数组中的索引
        int[] peakArr = new int[arr.length];
        int index = 0;
        if (arr[0] >= arr[1]) {
            peakArr[index++] = 0;
        }
        for (int i = 1; i < arr.length - 2; i++) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1] && !(arr[i] == arr[i - 1] && arr[i] ==  arr[i + 1])) {
                peakArr[index++] = i;
            }
        }
        if (arr[arr.length - 2] <= arr[arr.length - 1]) {
            peakArr[index++] = arr.length - 1;
        }

        if (index <= 1) {
            return 0;
        }

        for (int i = 1; i < index; i++) {
            if (peakArr[i] != peakArr[i - 1]) { // 不相邻
                count += calculate(arr, peakArr[i - 1], peakArr[i]);
            }
        }

        return count;
    }

    private int calculate (int[] arr, int low, int high) {
        int count = 0;
        int lowBound = arr[low] > arr[high] ? arr[high] : arr[low];
        for (int i = low + 1; i < high; i++) {
            count += (lowBound - arr[i]);
        }

        return count;
    }
}
