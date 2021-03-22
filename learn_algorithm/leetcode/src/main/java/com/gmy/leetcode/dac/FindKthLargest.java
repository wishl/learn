package com.gmy.leetcode.dac;

import java.util.Arrays;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        return find(nums, k - 1, 0, nums.length - 1);
    }

    public int find(int[] nums, int k, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            if (partition > k) {
                find(nums, k, left, partition - 1);
            } else if (partition < k) {
                find(nums, k, partition + 1, right);
            } else {
                return nums[k];
            }
        }
        return -1;
    }

    private int partition(int[] nums, int left, int right) {
        int prov = left, index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] > nums[prov]) {
                swap(nums, i, index++);
            }
        }
        swap(nums, prov,index - 1);
        return index - 1;
    }

    public int findKthLargest1(int[] nums, int k) {
        int N = nums.length;
        for (int i = (N / 2) - 1; i >= 0; i--) {
            adjustHeap(nums, i, N);
        }
        for (int i = N - 1; i > 0 && k > 1; i--, k--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i - 1);
        }
        System.out.println(Arrays.toString(nums));
        return nums[0];
    }

    private void adjustHeap(int[] arr, int i, int length) {
        int tmp = arr[i];
        for (int k = (2 * i) + 1; k < length; k = (2 * k) + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (tmp < arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] is = {3,2,3,1,2,4,5,5,6};
        int kthLargest = findKthLargest.findKthLargest1(is, 4);
        System.out.println(kthLargest);
    }

}
