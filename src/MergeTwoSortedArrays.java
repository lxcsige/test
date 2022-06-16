/**
 * @author xucheng.liu
 * @date 2020/8/19
 */
public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6, 8, 10};
        int[] res = merge(nums1, nums2);
        System.out.println(res);
    }

    public static int[] merge(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int length1 = nums1.length, length2 = nums2.length;
        int[] res = new int[length1 + length2];
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while (i < length1) {
            res[k++] = nums1[i++];
        }
        while (j < length2) {
            res[k++] = nums2[j++];
        }

        return res;
    }
}
