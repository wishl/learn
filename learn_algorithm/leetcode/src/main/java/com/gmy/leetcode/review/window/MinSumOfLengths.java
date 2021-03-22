package com.gmy.leetcode.review.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 arr 和一个整数值 target 。
 * 请你在 arr 中找 两个互不重叠的子数组 且它们的和都等于 target 。可能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。
 * 请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1 。
 *
 * https://leetcode.cn/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/description/
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,2,4,3], target = 3
 * 输出：2
 * 解释：只有两个子数组和为 3 （[3] 和 [3]）。它们的长度和为 2 。
 * 示例 2：
 *
 * 输入：arr = [7,3,4,7], target = 7
 * 输出：2
 * 解释：尽管我们有 3 个互不重叠的子数组和为 7 （[7], [3,4] 和 [7]），但我们会选择第一个和第三个子数组，因为它们的长度和 2 是最小值。
 * 示例 3：
 *
 * 输入：arr = [4,3,2,6,2,3,4], target = 6
 * 输出：-1
 * 解释：我们只有一个和为 6 的子数组。
 * 示例 4：
 *
 * 输入：arr = [5,5,4,4,5], target = 3
 * 输出：-1
 * 解释：我们无法找到和为 3 的子数组。
 * 示例 5：
 *
 * 输入：arr = [3,1,1,1,5,1,2,1], target = 3
 * 输出：3
 * 解释：注意子数组 [1,2] 和 [2,1] 不能成为一个方案因为它们重叠了。
 */
public class MinSumOfLengths {

    /**
     * 相似题目：MaximizeWin
     * @param arr
     * @param target
     * @return
     */
    public int minSumOfLengths(int[] arr, int target) {
        int start = 0, result = 2 * arr.length, sum = 0;
        int[] pre = new int[arr.length + 1];
        pre[0] = arr.length;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum > target) {
                sum -= arr[start++];
            }
            if (sum == target) {
                result = Math.min(result, end - start + 1 + pre[start]);
                pre[end + 1] = Math.min(pre[end], end - start + 1);
            } else {
                pre[end + 1] = pre[end];
            }
        }
        return result > arr.length ? -1 : result;
    }

    public static void main(String[] args) {
        Map<String, Integer> countMap = new HashMap<>();
        countMap.merge("test", 1, Integer::sum);
        MinSumOfLengths minSumOfLengths = new MinSumOfLengths();
        int result = minSumOfLengths.minSumOfLengths(new int[]{1,1,1,1,2,1}, 6);
        System.out.println(result);
    }

}
