package com.gmy.leetcode.week.contest._489;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组 nums。
 * 返回数组中第一个（从左到右扫描）出现频率与众不同 的元素。如果不存在这样的元素，返回 -1。
 *
 * 示例 1：
 * 输入： nums = [20,10,30,30]
 * [20, 20, 30, 30, 30, 40, 40, 40, 50, 50, 60, 60]
 * 输出： 30
 * 解释：
 * 20 出现了 1 次。
 * 10 出现了 1 次。
 * 30 出现了 2 次。
 * 30 的出现频率是唯一的，因为没有其他整数恰好出现 2 次。
 */
public class FirstUniqueFreq {

    /**
     * 先统计出现次数 然后统计出现次数出现的次数 之后出现次数只出现过一次的就是答案
     * @param nums
     * @return
     */
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }

        int[] cc = new int[nums.length + 1];
        for (int c : cnt.values()) {
            cc[c]++;
        }

        for (int x : nums) {
            if (cc[cnt.get(x)] == 1) {
                return x;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
