package com.gmy.leetcode.half.answer;

import java.util.Arrays;

/**
 *
 * 给你一个下标从 0 开始的数组 nums ，它含有 n 个非负整数。
 * 每一步操作中，你需要：
 * 选择一个满足 1 <= i < n 的整数 i ，且 nums[i] > 0 。
 * 将 nums[i] 减 1 。
 * 将 nums[i - 1] 加 1 。
 * 你可以对数组执行 任意 次上述操作，请你返回可以得到的 nums 数组中 最大值 最小 为多少。
 *
 * 示例 1：
 *
 * 输入：nums = [3,7,1,6]
 * 输出：5
 * 解释：
 * 一串最优操作是：
 * 1. 选择 i = 1 ，nums 变为 [4,6,1,6] 。
 * 2. 选择 i = 3 ，nums 变为 [4,6,2,5] 。
 * 3. 选择 i = 1 ，nums 变为 [5,5,2,5] 。
 *
 * [10, 1]
 *
 * [1, 10]
 *
 * nums 中最大值为 5 。无法得到比 5 更小的最大值。
 * 所以我们返回 5 。
 *
 *
 * [13,13,20,0,8,9,9]
 * [14,12,20,0,8,9,9]
 * [14,13,19,0,8,9,9]
 * [14,14,18]
 * [14,15,17]
 * [15,14,17]
 * [15,15,16]
 *
 * https://leetcode.cn/problems/minimize-maximum-of-array/
 */
public class MinimizeArrayValue {


    /**
     * 分类讨论：
     * 如果nums 只有一个元素 这个元素是最大值
     * 如果nums 有两个元素 则：
     * 如果 nums[0] >= nums[1] 则最大值是 nums[0]
     * 如果 nums[0] < nums[1] 则最大值为 平均数
     * 如果nums 有多个元素 则：
     * 计算前两个元素的值后当做一个元素 再往后进行 中间的最大值就是答案
     * @param nums
     * @return
     */
    public int minimizeArrayValue1(int[] nums) {
        int n1 = nums[0], max = 0;
        for (int i = 1; i < nums.length; i++) {
            int n2 = nums[i];
            if (n1 <= n2) {
                // 向上取整
                n1 = (n1 + n2 + 1) / 2;
            }
            max = Math.max(n1, max);
        }
        return max;
    }

    public int minimizeArrayValue2(int[] nums) {
        long ans = 0;
        long s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            ans = Math.max(ans, (s + i) / (i + 1));
        }
        return (int) ans;
    }


    /**
     * 二分答案方法
     * @param nums
     * @return
     */
    public int minimizeArrayValue(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int left = 0, right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean can = can(nums, mid);
            // 可以满足条件说明mid大了 尝试减小
            if (can) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }


    private boolean check(int[] nums, int limit) {
        long extra = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            extra = Math.max(nums[i] + extra - limit, 0);
        }
        return nums[0] + extra <= limit;
    }

    /**
     * 后面比mid多的数 分给前面的所有元素 可以从后往前遍历 见check方法
     * @param nums
     * @param mid
     * @return
     */
    private boolean can(int[] nums, int mid) {
        if (nums[0] > mid) {
            return false;
        }
        long totalGap = mid - nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 大于mid 则减小为mid
            if (nums[i] - mid > 0) {
                long gap = nums[i] - mid;
                if (gap > totalGap) {
                    return false;
                }
                totalGap -= gap;
            } else {
                totalGap += mid - nums[i];
            }
        }
        return totalGap >= 0;
    }

    public static void main(String[] args) {
        MinimizeArrayValue minimizeArrayValue = new MinimizeArrayValue();
        int result = minimizeArrayValue.minimizeArrayValue(new int[]{7, 10, 8});
        int result1 = minimizeArrayValue.minimizeArrayValue1(new int[]{7, 10, 8});
        System.out.println(result);
        System.out.println(result1);
    }

}
