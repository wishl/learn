package com.gmy.leetcode.week.contest.treenineone;

/**
 给你一个
 二进制数组
 nums 。
 如果一个
 子数组
 中 不存在 两个 相邻 元素的值 相同 的情况，我们称这样的子数组为 交替子数组 。

 返回数组 nums 中交替子数组的数量。



 示例 1：
 输入： nums = [0,1,1,1]
 输出： 5
 解释：

 以下子数组是交替子数组：[0] 、[1] 、[1] 、[1] 以及 [0,1] 。

 示例 2：
 输入： nums = [1,0,1,0]
 输出： 10
 解释：
 数组的每个子数组都是交替子数组。可以统计在内的子数组共有 10 个。
 *
 * https://leetcode.cn/problems/count-alternating-subarrays/description/
 */
public class CountAlternatingSubarrays {

    public long countAlternatingSubarrays(int[] nums) {
        int start = 0, end = 0;
        long result = 0;
        while (end < nums.length) {
            while (end != start && nums[end] == nums[end - 1]) {
                start++;
            }
            if (end == start || nums[end] != nums[end - 1] ) {
                result += end - start + 1;
            }
            end++;
        }
        return result;
    }

    /**
     * 前缀法
     * @param nums
     * @return
     */
    public long countAlternatingSubarrays1(int[] nums) {
        long result = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = i > 0 && nums[i] != nums[i - 1] ? count + 1 : 1;
            result += count;
        }
        return result;
    }

    public static void main(String[] args) {
        CountAlternatingSubarrays countAlternatingSubarrays = new CountAlternatingSubarrays();
        long result = countAlternatingSubarrays.countAlternatingSubarrays(new int[]{1,0,1,0});
        long result1 = countAlternatingSubarrays.countAlternatingSubarrays1(new int[]{1,0,1,0});
        System.out.println(result);
        System.out.println(result1);
    }

}
