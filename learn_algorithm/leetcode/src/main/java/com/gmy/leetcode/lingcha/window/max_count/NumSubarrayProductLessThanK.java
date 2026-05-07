package com.gmy.leetcode.lingcha.window.max_count;

/**
 * @Author Guanmengyuan
 * @Date Created in 19:57 2026/5/6
 */
public class NumSubarrayProductLessThanK {

    /**
     * 通过滑动窗口计算子数组的数量 其实就是 枚举 left left + 1 .... right 这么长 所以每次都多 (right - left  + 1) 个数量就行
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0, multi = 1, left = 0;
        for (int right = 0; right < nums.length; right++) {
            multi *= nums[right];
            while (multi >= k) {
                multi /= nums[left++];
            }
            result += (right - left + 1);
        }
        return result;
    }

}
