package com.gmy.leetcode.review.window;

import lombok.experimental.var;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
 * 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
 * 子数组 是原数组中一段连续 非空 的元素序列。
 */
public class CountGood {

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public long countGood(int[] nums, int k) {
        // 存储每个数量有多少个
        Map<Integer, Integer> countMap = new HashMap<>();
        int start = 0, group = 0;
        long result = 0;
        for (int num : nums) {
            // 重复的次数 + 1 group 的数量 + n - 1 n = 加一之前的重复的次数
            group += countMap.getOrDefault(num, 0);
            countMap.merge(num, 1, Integer::sum);
            while (group - countMap.get(nums[start]) + 1 >= k) {
                // 重复次数 -1 group 数量 - n n = 减一后的重复次数
                group -= countMap.merge(nums[start++], -1, Integer::sum);
            }
            if (group >= k) {
                // start端点前的每个数字都可以当做起始节点 start也可以 所以是 start + 1
                // 后缀节点的计算 是后续 end++后 满足条件再加进来
                result += start + 1;
            }
        }
        return result;
    }

    public long countGood1(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        long ans = 0;
        int left = 0, pairs = 0;
        for (int x : nums) {
            pairs += cnt.getOrDefault(x, 0);
            cnt.merge(x, 1, Integer::sum); // 移入右端点
            while (pairs - cnt.get(nums[left]) + 1 >= k)
                pairs -= cnt.merge(nums[left++], -1, Integer::sum); // 移出左端点
            if (pairs >= k) ans += left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountGood countGood = new CountGood();
        // 1,3,4,3,2,2,4
        // 1,3,4,3,2,2
        // 3,4,3,2,2

        // 3,4,3,2,2,4
        // 4,3,2,2,4

        long result = countGood.countGood1(new int[]{3,1,4,3,2,2,4}, 2);
        long result1 = countGood.countGood(new int[]{3,1,4,3,2,2,4}, 2);
        System.out.println(result);
        System.out.println(result1);
    }

}
