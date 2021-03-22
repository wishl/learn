package com.gmy.leetcode.dp.memery.simple;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 * https://leetcode.cn/problems/delete-and-earn/description/
 */
public class DeleteAndEarn {

    int[] count;

    /**
     * dfs + 记忆化搜索
     * @param nums
     * @return
     */
    public int deleteAndEarn2(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        this.count = new int[nums[length - 1] + 1];
        for (int num : nums) {
            count[num]++;
        }
        int[] cache = new int[count.length];
        Arrays.fill(cache, -1);
        return dfs(count.length - 1, cache);
    }

    private int dfs(int n, int[] cache) {
        if (n <= 0) {
            return 0;
        }
        if (cache[n] != -1) {
            return cache[n];
        }
        // 不选当前 用 n - 1 的结果 否则 用 n - 2 的结果 + count[n]
        int result = Math.max(dfs(n - 1, cache), dfs(n - 2, cache) + n * count[n]);
        cache[n] = result;
        return result;
    }

    /**
     * 递推法
     * @param nums
     * @return
     */
    public int deleteAndEarn1(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        this.count = new int[nums[length - 1] + 1];
        for (int num : nums) {
            count[num]++;
        }
        int[] cache = new int[count.length + 2];
        for (int n = 1; n <= nums[length - 1]; n++) {
            cache[n + 2] = Math.max(cache[n + 1], cache[n] + n * count[n]);
        }
        return cache[count.length + 1];
    }

    /**
     * 递推法 空间复杂度优化
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        this.count = new int[nums[length - 1] + 1];
        for (int num : nums) {
            count[num]++;
        }
        int value = 0, v1 = 0, v2 = 0;
        for (int n = 1; n <= nums[length - 1]; n++) {
            value = Math.max(v1, v2 + n * count[n]);
            v2 = v1;
            v1 = value;
        }
        return v1;
    }

    public static void main(String[] args) {
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        int result = deleteAndEarn.deleteAndEarn(new int[]{3,4,2});
        int result1 = deleteAndEarn.deleteAndEarn1(new int[]{3,4,2});
        System.out.println(result);
        System.out.println(result1);
    }

}
