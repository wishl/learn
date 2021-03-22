package com.gmy.leetcode.review;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int[] copy = new int[nums.length * 2];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        System.arraycopy(nums, 0, copy, nums.length, nums.length);
        System.arraycopy(copy, length - k, nums, 0, nums.length);
    }

    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
//        rotate.rotate(ints, 3);
        rotate.rotate1(ints, 3);
        System.out.println(Arrays.toString(ints));
    }
}
