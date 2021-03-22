package com.gmy.leetcode.doublepoint;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColors {

    public void sortColors(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int tmp = 0, i = left, j = mid + 1;
        int[] tmpArray = new int[nums.length];
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tmpArray[tmp++] = nums[i++];
            } else {
                tmpArray[tmp++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmpArray[tmp++] = nums[i++];
        }
        while (j <= right) {
            tmpArray[tmp++] = nums[j++];
        }
        tmp = 0;
        for (int k = left; k <= right; k++) {
            nums[k] = tmpArray[tmp++];
        }
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int standardsIndex = left + 1, standard = nums[left];
        for (int i = standardsIndex; i <= right; i++) {
            if (standard > nums[i]) {
                swap(nums, standardsIndex++, i);
            }
        }
        swap(nums, standardsIndex - 1, left);
        return standardsIndex - 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
