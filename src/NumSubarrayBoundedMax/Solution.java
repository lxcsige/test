package NumSubarrayBoundedMax;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xucheng.liu
 * @date 2020/4/15
 */
public class Solution {

    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        // 子数组起始index
        int startIndex = 0;
        int count = 0;
        // 结果子数组数量
        int res = 0;
        // 结果子数组列表
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            // A[i]满足条件
            if (A[i] >= L && A[i] <= R) {
                // A[startIndex...i-1]的子数组 + A[i]均满足条件
                res += i - startIndex + 1;
                // 从startIndex开始，尾元素满足>=L && <=R的子数组长度
                count = i - startIndex + 1;

                for (int tmp = startIndex; tmp <= i; tmp++) {
                    List<Integer> indices = new ArrayList<>();
                    indices.add(tmp);
                    indices.add(i);
                    result.add(indices);
                }
            } else if (A[i] < L) {

                res += count;

                for (int tmp = 0; tmp < result.size(); tmp++) {
                    List<Integer> tmpIndices = result.get(tmp);
                    if (tmpIndices.get(1) == i - 1) {
                        List<Integer> indices = new ArrayList<>();
                        indices.add(tmpIndices.get(0));
                        indices.add(i);
                        result.add(indices);
                    }
                }
            } else {
                startIndex = i + 1;
                count = 0;
            }
        }

        System.out.println(result.size());
        System.out.println(result.toString());

        return res;
    }

    public static void main(String[] args) {
        int[] A = {73,55,36,5,55,14,9,7,72,52};
        int L = 32, R = 69;
        System.out.println(numSubarrayBoundedMax(A, L, R));
    }
}
