package com.gmy.leetcode.monostone_stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * 一个数组的 最小乘积定义为这个数组中 最小值乘以数组的 和。
 *
 * 比方说，数组[3,2,5]（最小值是2）的最小乘积为2 * (3+2+5) = 2 * 10 = 20。
 * 给你一个正整数数组nums，请你返回nums任意非空子数组的最小乘积的最大值。由于答案可能很大，请你返回答案对109 + 7取余的结果。
 * 请注意，最小乘积的最大值考虑的是取余操作 之前的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数保存。
 * 子数组定义为一个数组的 连续部分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray-min-product
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [1,2,3,2]
 * 输出：14
 * 解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
 * 2 * (2+3+2) = 2 * 7 = 14 。
 * 示例 2：
 *
 * 输入：nums = [2,3,3,1,2]
 * 输出：18
 * 解释：最小乘积的最大值由子数组 [3,3] （最小值是 3）得到。
 * 3 * (3+3) = 3 * 6 = 18 。
 * 示例 3：
 *
 * 输入：nums = [3,1,5,6,4,2]
 * 输出：60
 * 解释：最小乘积的最大值由子数组 [5,6,4] （最小值是 4）得到。
 * 4 * (5+6+4) = 4 * 15 = 60 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray-min-product
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSumMinProductReview {

    /**
     * 计算每个点当做最小值时的结果，进行对比 通过前缀数组减少计算量 通过哨兵减少判断
     * @param nums
     * @return
     */
    public int maxSumMinProduct(int[] nums) {
        int[] copy = new int[nums.length + 2];
        System.arraycopy(nums, 0, copy, 1, nums.length);
        long[] preSum = new long[copy.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        long result = 0;
        for (int i = 1; i < copy.length; i++) {
            preSum[i] = preSum[i - 1] + copy[i];
            while (copy[i] < copy[deque.peek()]) {
                Integer high = copy[deque.pop()];
                int right = i - 1;
                int left = deque.peek();
                result = Math.max(result, (preSum[right] - preSum[left]) * high);
            }
            deque.push(i);
        }
        return (int) (result % 1000000007);
    }

    public static void main(String[] args) {
        MaxSumMinProductReview maxSumMinProductReview = new MaxSumMinProductReview();
//        int result = maxSumMinProductReview.maxSumMinProduct(new int[]{2,3,3,1,2});
        int result = maxSumMinProductReview.maxSumMinProduct(new int[]{1,2,3,2});
        System.out.println(result);
    }

}
