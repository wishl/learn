package com.gmy.leetcode.hot100.array;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Rotate {

    /**
     * 翻转数组 先翻转整个数组 然后翻转前K个数组 之后翻转 K - N的数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        Rotate rotate = new Rotate();
        rotate.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

}
