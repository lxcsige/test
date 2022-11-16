package SortTest;

import java.util.Stack;

/**
 * Created by liuxucheng on 2018/4/5.
 * description: 八大排序，冒泡&直接插入&归并稳定，其他均不稳定
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        SortTest s = new SortTest();
//        s.insertSort(arr);
//        s.shellSort(arr);
//        s.selectionSort(arr);
        s.heapSort(arr);
//        s.bubbleSort2(arr);
//        s.quickSort(arr, 0, 4);
//        s.nonRecursiveQuickSort(arr);
//        s.mergeSort(arr, new int[arr.length], 0, 7);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 直接插入排序，时间复杂度O(n^2)，in-place，稳定
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
     * 时间复杂度小于O(n^2)，不稳定
     *
     * @param arr
     */
    private void shellSort(int[] arr) {
        int i, j, gap, insertNum;
        for (gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (i = gap; i < arr.length; i++) {
                insertNum = arr[i];
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
     * {(7), 2, 5, 9, 3, 4, [7], 1}，不稳定的例子
     * 交换排序
     *
     * @param arr
     */
    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // 无序子序列的左边界，如果只剩下一个元素则不需要进行比较
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
     * 堆排序，时间复杂度O(nlogn)，不稳定排序
     * 建堆 --> 堆顶与最后一个元素交换 --> 调整堆
     * @param arr
     */
    private void heapSort(int[] arr) {
        // 建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            siftDown(arr, 0, i);
        }
    }

    private void siftDown(int[] arr, int i, int length) {
        int temp = arr[i];
        // 取左子节点
        int k = 2 * i + 1;
        while (k < length) {
            if (k + 1 < length && arr[k + 1] > arr[k]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
                k = 2 * k + 1;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    /**
     * 冒泡排序，时间复杂度O(n^2)，稳定，空间复杂度O(1)
     * 相邻元素两两交换，大的下沉，小的上浮，一次排序可以确定最大/最小值
     * 最好情况：完全有序，时间复杂度O(n)，最坏情况：完全逆序
     * 交换排序
     *
     * @param arr
     */
    private void bubbleSort(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) { // 数组遍历次数，一次确定一个元素的顺序，需要length - 1次
            for (int j = 0; j < arr.length - i; j++) { // 第i次遍历，已经确定了i-1个元素的顺序，只需要针对剩下的length - i + 1个元素进行排序，其右边界index为length -i
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        arr = new int[]{5, 4, 3, 2, 1};
        for (int i = arr.length - 1; i > 0; i--) { // 需要排序的元素的右边界
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序改进1，设置exchange变量标记本次排序是否有交换，没有则直接返回
     *
     * @param arr
     */
    private void bubbleSort1(int[] arr) {
        for (int i = arr.length - 1; i > 0; i++) {
            boolean exchange = false;
            for (int j = 0; j < i; j++) {
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
     * 需要排序的元素个数并非递减，因此可以将for循环变成while
     * 适用于局部有序
     *
     * @param arr
     */
    private void bubbleSort2(int[] arr) {
        int i = arr.length - 1;
        while (i > 0) {
            int index = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    index = j;
                }
            }
            i = index;
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
        // 递归
        if (low < high) {
            // 划分
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private void nonRecursiveQuickSort(int[] arr) {
        int left = 0, right = arr.length - 1, pivot;
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
        int pivot = arr[high];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && arr[i] <= pivot) {
                i++;
            }
<<<<<<< HEAD:src/java/SortTest/SortTest.java
            arr[j] = arr[i];
=======
            if (i < j) {
                arr[j--] = arr[i];
            }
>>>>>>> 35a72397d68189e2a9243f4b427c029e34c0f68a:src/SortTest/SortTest.java

            while (i < j && arr[j] >= pivot) {
                j--;
            }
<<<<<<< HEAD:src/java/SortTest/SortTest.java
            arr[i] = arr[j];
=======
            if (i < j) {
                arr[i++] = arr[j];
            }
>>>>>>> 35a72397d68189e2a9243f4b427c029e34c0f68a:src/SortTest/SortTest.java
        }
        arr[i] = pivot;

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
        System.out.println("left = " + left + ", right = " + right);
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
        int tempIndex = 0;
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

        for (int i = 0; i < tempIndex; i++) {
            arr[left+i] = temp[i];
        }
    }
}
