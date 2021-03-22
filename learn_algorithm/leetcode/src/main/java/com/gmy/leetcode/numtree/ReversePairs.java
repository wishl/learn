package com.gmy.leetcode.numtree;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class ReversePairs {

    /**
     * 1. 基于归并排序 计算贡献
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        return sortAndCount(nums, 0, nums.length - 1);
    }

    private int sortAndCount(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            int count = sortAndCount(nums, left, mid);
            int count1 = sortAndCount(nums, mid + 1, right);
            int count2 = mergeAndCount(nums, left, mid, right);
            return count1 + count2 + count;
        }
        return 0;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        int[] tmp = new int[nums.length];
        int count = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
                // 需要加上 mid 到 当前值的距离
                count += (mid - i + 1);
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        k = 0;
        while (left <= right) {
            nums[left++] = tmp[k++];
        }
        return count;
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int i = reversePairs.reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(i);
    }
}
