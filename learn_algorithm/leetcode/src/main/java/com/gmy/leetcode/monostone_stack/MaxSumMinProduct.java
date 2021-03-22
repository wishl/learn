package com.gmy.leetcode.monostone_stack;

import java.util.Deque;
import java.util.LinkedList;

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
public class MaxSumMinProduct {

    public int maxSumMinProduct(int[] nums) {
        int[] copy = new int[nums.length + 2];
        System.arraycopy(nums, 0, copy, 1, nums.length);
        // 前缀和
        long[] presum = new long[copy.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        Long res = 0L;
        for (int i = 1; i < copy.length; i++) {
            // 计算前缀和
            presum[i] = presum[i - 1] + copy[i];
            while (copy[i] < copy[deque.peek()]) {
                int high = copy[deque.pop()];
                int right = i - 1;
//                deque.pop();
                int left = deque.peek() + 1;
                res = Math.max(res, (presum[right] - presum[left - 1]) * high);
            }
            deque.push(i);
        }
        return (int) (res % 1000000007);
    }

    /**
     * int maxSumMinProduct(vector<int>& nums) {
     *         nums.insert(nums.begin(), 0);        //以后碰到类似可以用单调栈的题，最前和最后加个值为0的哨兵再说，可以少一些判断
     *         nums.push_back(0);
     *         int sz = nums.size();
     *         vector<long> presum(sz);     //前缀和数组，和里面包括自己
     *         presum[0] = 0;
     *         stack<int> stk;         //单调栈
     *         stk.push(0);
     *         long res = 0;
     *         for (int i = 1; i < sz; i++) {
     *             presum[i] = presum[i - 1] + static_cast<long>(nums[i]);     //计算前缀和数组
     *             while (nums[i] < nums[stk.top()]) {
     *                 //只在出栈的时候求以stk.top()为最小值的乘积
     *                 long cur_min_h = static_cast<long>(nums[stk.top()]);        //stk.top()所在子数组最小值是它自己
     *                 int right = i - 1;      //最右下标，是马上要进栈的那个值的左边一格
     *                 stk.pop();
     *                 int left = stk.top() + 1;   //最左下标，是stk.top()出栈后的栈顶的右边一格
     *                 res = max(res, (presum[right] - presum[left - 1]) * cur_min_h );
     *             }
     *             stk.push(i);
     *         }
     *         return res % 1000000007;
     *     }
     */

    public static void main(String[] args) {
        MaxSumMinProduct maxSumMinProduct = new MaxSumMinProduct();
        int i = maxSumMinProduct.maxSumMinProduct(new int[]{1,2,3,2});
        System.out.println(i);
    }

}
