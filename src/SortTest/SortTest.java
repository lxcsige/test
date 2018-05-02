package SortTest;

import java.util.Stack;

/**
 * Created by liuxucheng on 2018/4/5.
 * description: 八大排序，冒泡&直接插入&归f并稳定，其他均不稳定
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 5, 4};
        SortTest s = new SortTest();
//        s.insertSort(arr);
//        s.shellSort(arr);
//        s.selectionSort(arr);
//        s.selectionSort2(arr);
//        s.heapSort(arr);
//        s.bubbleSort2(arr);
//        s.quickSort(arr, 0, 4);
        s.nonRecursiveQuickSort(arr);
//        s.mergeSort(arr, new int[arr.length], 0, 4);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 直接插入排序，时间复杂度O(n^2)，稳定
     *
     * @param arr
     */
    private void insertSort(int[] arr) {
        int i, j;
        for (i = 1; i < arr.length; i++) {
            int insertNum = arr[i]; // 哨兵
            j = i - 1;
            while (j >= 0 && arr[j] > insertNum) { // 大于插入值就将该值后移一位
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = insertNum; // 否则赋值
        }
    }

    /**
     * 希尔排序，增量序列，将一个数组分割成若干个子序列，分别进行直接插入排序，直到增量为1
     * 直接插入排序的改进，时间复杂度跟增量序列有关
     *
     * @param arr
     */
    private void shellSort(int[] arr) {
        int i, j, gap, insertNum;
        for (gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (i = gap; i < arr.length; i++) {
                insertNum = arr[i]; // 哨兵
                j = i - gap;
                while (j >= 0 && arr[j] > insertNum) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = insertNum;
            }
        }
    }

    /**
     * 选择排序，选出剩下元素里最大/最小的元素，时间复杂度O(n^2)
     * 不稳定
     *
     * @param arr
     */
    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 二元选择排序，一次找出剩下元素里的最大值和最小值，循环减少一半
     * 注意第一个数是最大值的情况，先交换最小值，会导致最大值被覆盖
     * 不稳定排序
     * @param arr
     */
    private void selectionSort2(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int minIndex = i;
            int maxIndex = i;
            for (int j = i + 1; j <= arr.length - i - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    continue;
                }
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp;
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            if (maxIndex == i) {
                temp = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = arr[minIndex];
                arr[minIndex] = temp;
            } else {
                temp = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }

    /**
     * 堆排序，时间复杂度O(nlogn)，不稳定排序
     * 建堆 --> 堆顶与最后一个元素交换 --> 调整堆
     * @param arr
     */
    private void heapSort(int[] arr) {
        // 建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 交换堆顶和末尾元素，调整堆
        for (int i = arr.length - 1; i > 0; i--) {
            // 交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆，i和length限定需要调整的堆在数组中的位置
     *
     * @param arr
     * @param i
     * @param length
     */
    private void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        int k = 2 * i + 1;
        while (k < length) {
            if (k + 1 < length && arr[k] < arr[k + 1]) { // 左节点小于右节点
                k++;
            }
            if (temp < arr[k]) { // 注意，这里没有作交换，只是将子节点的值赋给父节点
                arr[i] = arr[k]; // 子节点赋值给父节点
                i = k;
                k = k * 2 + 1;
            } else {
                break;
            }
        }
        arr[i] = temp; // 给最后一个赋值给父节点的子节点赋值
    }

    /**
     * 冒泡排序，时间复杂度O(n^2)，稳定
     * 相邻元素两两交换，大的下沉，小的上浮，一次排序可以确定最大/最小值
     *
     * @param arr
     */
    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序改进1，设置exchange变量标记本次排序是否有交换，没有则理解返回
     *
     * @param arr
     */
    private void bubbleSort1(int[] arr) {
        boolean exchange = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    exchange = true;
                }
            }

            if (!exchange) {
                break;
            }
        }
    }

    /**
     * 冒泡排序改进2，设置pos变量记录一趟排序过程中发生交互的最后一个位置，该位置之后有序
     *
     * @param arr
     */
    private void bubbleSort2(int[] arr) {
        int i = arr.length - 1;
        while (i > 0) {
            int pos = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    pos = j;
                }
            }
            i = pos;
        }
    }

    /**
     * 冒泡改进3，双向冒泡
     * 就循环次数而言，似乎没有减少
     *
     * @param arr
     */
    private void bubbleSort4(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            for (int i = low; i < high; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            high--;

            for (int i = high; i > low; i--) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                }
            }
            low++;
        }
    }

    /**
     * 快速排序，递归分治，O(nlogn)
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) { // 递归
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private void nonRecursiveQuickSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int pivot;
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while(!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            pivot = partition(arr, left, right);
            if (left < pivot - 1) {
                stack.push(left);
                stack.push(pivot);
            }
            if (right > pivot + 1) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }

    private int partition(int[] arr, int low, int high) {
        dealPivot(arr, low, high);
        int partitionKey = arr[ high - 1];
        int i = low;
        int j = high - 1;
        while (i < j) {
            while (i < j && arr[i] <= partitionKey) {
                i++;
            }
//            swap(arr, low, high); // 与基准值作交换
            if (i < j) {
                arr[j--] = arr[i];
            }

            while (i < j && arr[j] >= partitionKey) {
                j--;
            }
//            swap(arr, low, high); // 与基准值作交换
            if (i < j) {
                arr[i++] = arr[j];
            }
        }
        arr[i] = partitionKey;
        return i;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 三位取中，避免快排的最坏情况
     */
    private void dealPivot(int[] arr, int low, int high) {
        // 找到中间数
        int mid = (low + high) / 2;
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[high] < arr[mid]) {
            swap(arr, high, mid);
        }
        swap(arr, high - 1, mid);
    }

    /**
     * 二路归并排序，O(nlogn)，稳定
     * @param arr
     */
    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int rightIndex = mid + 1;
        int leftIndex = left;
        int tempIndex = left;
        int num = right - left + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[tempIndex++] = arr[leftIndex++];
            } else {
                temp[tempIndex++] = arr[rightIndex++];
            }
        }
        while(leftIndex <= mid) {
            temp[tempIndex++] = arr[leftIndex++];
        }
        while(rightIndex <= right) {
            temp[tempIndex++] = arr[rightIndex++];
        }
        for (int i = 0; i < num; i++) {
            arr[right] = temp[right];
            right--;
        }
    }
}
