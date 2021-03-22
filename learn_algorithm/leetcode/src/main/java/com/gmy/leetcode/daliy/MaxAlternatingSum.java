package com.gmy.leetcode.daliy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 一个下标从 0开始的数组的 交替和定义为 偶数下标处元素之 和减去 奇数下标处元素之 和。
 *
 * 比方说，数组[4,2,5,3]的交替和为(4 + 5) - (2 + 3) = 4。
 * 给你一个数组nums，请你返回nums中任意子序列的最大交替和（子序列的下标 重新从 0 开始编号）。
 *
 * 一个数组的 子序列是从原数组中删除一些元素后（也可能一个也不删除）剩余元素不改变顺序组成的数组。
 * 比方说，[2,7,4]是[4,2,3,7,2,1,4]的一个子序列（加粗元素），但是[2,4,2] 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-alternating-subsequence-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [4,2,5,3]
 * 输出：7
 * 解释：最优子序列为 [4,2,5] ，交替和为 (4 + 5) - 2 = 7 。
 *
 * 输入：nums = [6,2,1,2,4,5]
 * 输出：10
 * 解释：最优子序列为 [6,1,5] ，交替和为 (6 + 5) - 1 = 10 。
 *
 * 5,6,7,8
 */
public class MaxAlternatingSum {

    /**
     *
     * @param nums
     * @return
     */
    public long maxAlternatingSum(int[] nums) {
        long even = nums[0], odd = 0;
        for (int i = 1; i < nums.length; i++) {
            even = Math.max(even, odd + nums[i]);
            odd = Math.max(odd, even - nums[i]);
        }
        return even;
    }

    public static void main(String[] args) {
        MaxAlternatingSum maxAlternatingSum = new MaxAlternatingSum();
        long result = maxAlternatingSum.maxAlternatingSum(new int[]{5,6,7,8});
        System.out.println(result);
    }
}
