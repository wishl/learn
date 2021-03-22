package com.gmy.leetcode.review;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 *
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 */
public class LongestOnes {

    /**
     * 先维护最大的窗口 在右移
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int maxCount = 0, start = 0, end = 0;
        int[] cache = new int[1];
        while (end < nums.length) {
            if (nums[end++] == 1) {
                cache[0]++;
            }
            maxCount = Math.max(cache[0], maxCount);
            if (end - start > maxCount + k) {
                if (nums[start++] == 1) {
                    cache[0]--;
                }
            }
        }
        return end - start;
    }

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes1(int[] nums, int k) {
        int start = 0, end = 0, result = 0;
        while (end < nums.length) {
            if (nums[end] == 0 && k >= 0) {
                k--;
            }
            while (k < 0) {
                if (nums[start++] == 0) {
                    k++;
                }
            }
            result = Math.max(end - start + 1, result);
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestOnes longestOnes = new LongestOnes();
//        int result = longestOnes.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        int result1 = longestOnes.longestOnes1(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
//        System.out.println(result);
        System.out.println(result1);
    }

}
