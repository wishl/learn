package com.gmy.leetcode.review.window;

/**
 * 交换 定义为选中一个数组中的两个 互不相同 的位置并交换二者的值。
 * 环形 数组是一个数组，可以认为 第一个 元素和 最后一个 元素 相邻 。
 * 给你一个 二进制环形 数组 nums ，返回在 任意位置 将数组中的所有 1 聚集在一起需要的最少交换次数。
 *
 * https://leetcode.cn/problems/minimum-swaps-to-group-all-1s-together-ii/
 */
public class MinSwaps {

    /**
     * 固定窗口长度为1的数量 然后滑动窗口
     * @param nums
     * @return
     */
    public int minSwaps(int[] nums) {
        int start = 0, end = 0, i = 0, length = nums.length;
        // 有几个1
        int oneTimes = 0, changCount = 0, result = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 1) {
                oneTimes++;
            }
        }
        if (oneTimes == 0) {
            return 0;
        }
        while (start < nums.length) {
            if (nums[end] == 0) {
                changCount++;
            }
            // 窗口长度 == oneTimes 时
            while (i - start + 1 == oneTimes) {
                result = Math.min(changCount, result);
                if (nums[start++] == 0) {
                    changCount--;
                }
            }
            i++;
            end = i % length;
        }
        return result;
    }

    public static void main(String[] args) {
        MinSwaps minSwaps = new MinSwaps();
        int result = minSwaps.minSwaps(new int[]{0, 0, 0});
        System.out.println(result);
    }


}
