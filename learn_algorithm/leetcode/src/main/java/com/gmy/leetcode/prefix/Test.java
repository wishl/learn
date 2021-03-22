package com.gmy.leetcode.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 给一个数组，和一个数字K 确定当前 前缀和 等于 k 的总数
 */
public class Test {

    public int calCount(int[] nums, int k) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            int result = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (result > k) {
                    break;
                }
                result += nums[j];
                if (result == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        Count count = new Count();
        boolean[] isView = new boolean[nums.length];
        dfs(nums, k, 0, 0, count, isView);
        return count.count;
    }

    private void dfs(int[] nums, int k, int index, int sum, Count count, boolean[] isView) {
        if (sum == k) {
            count.count++;
        }
        if (index == nums.length) {
           return;
        }
        if (!isView[index]) {
            isView[index] = true;
            // 把自己当做前缀的开始
            dfs(nums, k, index + 1, nums[index], count, isView);
        }
        if (index > 0) {
            dfs(nums, k, index + 1, sum + nums[index], count, isView);
        }
    }

    static class Count {
        private int count;

    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSumFreq.containsKey(prefixSum - k)) {
                count += prefixSumFreq.get(prefixSum - k);
            }
            prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 2, 1};
        Test test = new Test();
//        int i = test.calCount(nums, 3);
        int i1 = test.subarraySum(nums, 3);
        int i2 = test.subarraySum1(nums, 3);
//        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
    }

}
