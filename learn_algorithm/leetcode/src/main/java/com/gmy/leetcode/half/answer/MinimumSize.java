package com.gmy.leetcode.half.answer;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，其中 nums[i] 表示第 i 个袋子里球的数目。同时给你一个整数 maxOperations 。
 * 你可以进行如下操作至多 maxOperations 次：
 * 选择任意一个袋子，并将袋子里的球分到 2 个新的袋子中，每个袋子里都有 正整数 个球。
 * 比方说，一个袋子里有 5 个球，你可以把它们分到两个新袋子里，分别有 1 个和 4 个球，或者分别有 2 个和 3 个球。
 * 你的开销是单个袋子里球数目的 最大值 ，你想要 最小化 开销。
 * 请你返回进行上述操作后的最小开销。
 *
 * https://leetcode.cn/problems/minimum-limit-of-balls-in-a-bag/description/
 * 示例 1：
 *
 * 输入：nums = [9], maxOperations = 2
 * 输出：3
 * 解释：
 * - 将装有 9 个球的袋子分成装有 6 个和 3 个球的袋子。[9] -> [6,3] 。
 * - 将装有 6 个球的袋子分成装有 3 个和 3 个球的袋子。[6,3] -> [3,3,3] 。
 * 装有最多球的袋子里装有 3 个球，所以开销为 3 并返回 3 。
 *
 * 示例 2：
 *
 * 输入：nums = [2,4,8,2], maxOperations = 4
 * 输出：2
 * 解释：
 * - 将装有 8 个球的袋子分成装有 4 个和 4 个球的袋子。[2,4,8,2] -> [2,4,4,4,2] 。
 * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,4,4,4,2] -> [2,2,2,4,4,2] 。
 * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,4,4,2] -> [2,2,2,2,2,4,2] 。
 * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2] 。
 * 装有最多球的袋子里装有 2 个球，所以开销为 2 并返回 2 。
 *
 * 示例 3：
 *
 * 输入：nums = [7,17], maxOperations = 2
 * [7,7,10]
 * [7,7,5,5]
 * 输出：7
 *
 * 50
 * [1, 100]
 * [1, 25, 25, 50]
 */
public class MinimumSize {


    /**
     * 重要的的是判断单调关系
     *
     * 总操作次数 和 最大值有单调关系
     *
     * @param nums
     * @param maxOperations
     * @return
     */
    public long minimumSize(int[] nums, int maxOperations) {
        int max = Arrays.stream(nums).max().getAsInt();
        int left = 1, right = max, result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int optCount = 0;
            for (int num : nums) {
                // 一分为二 需要一次操作
                optCount += (num - 1) / mid;
            }
            // 操作次数大于等于 总次数 说明mid大了 尝试增大mid
            if (optCount <= maxOperations) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumSize minimumSize = new MinimumSize();
        long result = minimumSize.minimumSize(new int[]{9}, 2);
        System.out.println(result);
    }
}
