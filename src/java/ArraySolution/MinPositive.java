package ArraySolution;

/**
 * User: lxcfour
 * Date: 2018/5/23
 * Time: 下午9:26
 */
public class MinPositive {
    public static void main(String[] args) {

    }

    /**
     * 给定一个数组，长度为n，某几个位置的元素满足 a[x] < 0 或者 a[x] > n，余下的元素都满足a[i] == i,找出不在此数组中的最小正整数
     * @param arr
     * @return
     */
    public int missingMinNum1(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] != i) {
                return i;
            }
        }

        return arr[0] == n ? n + 1 : n;
    }

    /**
     * 给定一个无序的整数数组，找到不在此数组的最小正整数
     * @param arr
     * @return
     */
    public int missingMinNum2(int[] arr) {
        int p = 0, q = arr.length;
        while (p < q) {
            if (arr[p] == p + 1) {
                p++;
            } else if (arr[p] <= p || arr[p] > q || arr[arr[p] - 1] == arr[p]) {
                arr[p] = arr[--q];
            } else {
                int temp = arr[p];
                arr[p] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        return p + 1;
    }
}
