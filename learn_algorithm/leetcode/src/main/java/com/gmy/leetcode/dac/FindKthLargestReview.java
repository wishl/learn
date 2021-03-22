package com.gmy.leetcode.dac;

import java.util.Arrays;

public class FindKthLargestReview {

    public int findKthLargest(int[] nums, int k) {
        return findNum(nums, 0, nums.length - 1, k - 1);
    }

    private int findNum(int[] nums, int left, int right, int k) {
        int partition = partition(nums, left, right);
        if (partition > k) {
            return findNum(nums, left, partition - 1, k);
        } else if (partition < k) {
            return findNum(nums, partition + 1, right, k);
        } else {
            return nums[partition];
        }
    }

    private int partition(int[] nums, int left, int right) {
        int prov = left, j = prov + 1;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[prov]) {
                swap(nums, j++, i);
            }
        }
        swap(nums, left, j - 1);
        return j - 1;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public int findKthLargest2(int[] nums, int k) {
        int N = nums.length;
        for (int i = (N / 2) - 1; i >= 0; i--) {
            adjustHeap(nums, i, N);
        }
        for (int i = N - 1; i > 0 && k > 1; i--, k--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i - 1);
        }
        return nums[0];
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


    public void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k = (2 * i) + 1; k < length; k = (2 * k) + 1) {
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                k++;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            }
        }
        nums[i] = temp;
    }

    public static void main(String[] args) {
        FindKthLargestReview findKthLargest = new FindKthLargestReview();
        int kthLargest = findKthLargest.findKthLargest(new int[]{3,2,1,5,6,4}, 2);
        System.out.println(kthLargest);
        kthLargest = findKthLargest.findKthLargest1(new int[]{3,2,1,5,6,4}, 2);
        System.out.println(kthLargest);
        kthLargest = findKthLargest.findKthLargest2(new int[]{3,2,1,5,6,4}, 2);
        System.out.println(kthLargest);
    }

}
