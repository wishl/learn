package com.gmy.leetcode.lingcha.window.change;

import com.gmy.leetcode.link.MergeInBetween;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个 非负 整数 k 。
 *
 * 在一步操作中，你可以执行下述指令：
 *
 * 在范围 [0, nums.length - 1] 中选择一个 此前没有选过 的下标 i 。
 * 将 nums[i] 替换为范围 [nums[i] - k, nums[i] + k] 内的任一整数。
 * 数组的 美丽值 定义为数组中由相等元素组成的最长子序列的长度。
 *
 * 对数组 nums 执行上述操作任意次后，返回数组可能取得的 最大 美丽值。
 *
 * 注意：你 只 能对每个下标执行 一次 此操作。
 *
 * 数组的 子序列 定义是：经由原数组删除一些元素（也可能不删除）得到的一个新数组，且在此过程中剩余元素的顺序不发生改变。
 *
 * https://leetcode.cn/problems/maximum-beauty-of-an-array-after-applying-operation/description/
 */
public class MaximumBeauty {

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        // minThreadsHold 能连上的最小的阈值 如果后续的数比这个大 则说明不是一个漂亮数
        int left = 0, result = 1, minThreadsHold = nums[0] + 2 * k;
        for (int right = 1; right < nums.length; right++) {
            while (nums[right] > minThreadsHold) {
                left++;
                minThreadsHold = nums[left] + 2 * k;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumBeauty max = new MaximumBeauty();
        int result = max.maximumBeauty(new int[]{10,59,86}, 23);
        System.out.println(result);
    }

}
