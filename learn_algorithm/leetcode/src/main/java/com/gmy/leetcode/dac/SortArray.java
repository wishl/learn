package com.gmy.leetcode.dac;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * https://leetcode-cn.com/problems/sort-an-array/
 */
public class SortArray {

    /**
     * 堆排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        int length = nums.length;
        for (int i = (length - 1) / 2; i >= 0; i--) {
            adjustHeap(nums, i, length);
        }
        for (int i = length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
        return nums;
    }

    /**
     * 调整大顶堆
     * @param nums
     * @param index
     */
    private void adjustHeap(int[] nums, int index, int length) {
        int tmp = nums[index];
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            if (i + 1 < length && nums[i] < nums[i + 1]) {
                i++;
            }
            if (tmp < nums[i]) {
                nums[index] = nums[i];
                index = i;
            } else {
                break;
            }
        }
        nums[index] = tmp;
    }

    /**
     * 归并排序
     * @param nums
     * @return
     */
    public int[] sortArray2(int[] nums) {
        int[] tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, tmp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, tmp);
            mergeSort(nums, mid + 1, right, tmp);
            merge(nums, tmp, left, right, mid);
        }
    }

    private void merge(int[] nums, int[] temp, int left, int right, int mid) {
        int i = left, t = 0, j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        t = 0;
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }

    public int[] sortArray1(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快速排序
     * @param nums
     * @param left
     * @param right
     */
    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int prov = left, index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[prov] > nums[i]) {
                swap(nums, i, index++);
            }
        }
        swap(nums, prov, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        SortArray sortArray = new SortArray();
        int[] nums = new int[] {5,1,1,2,0,0};
        int[] ints = sortArray.sortArray(nums);
        System.out.println(Arrays.toString(ints));
    }
}
