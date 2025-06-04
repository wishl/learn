package com.gmy.leetcode.week.contest._452;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 给你一个整数数组 nums，其中包含的正整数 互不相同 ，另给你一个整数 target。
 * 请判断是否可以将 nums 分成两个 非空、互不相交 的 子集 ，
 * 并且每个元素必须  恰好 属于 一个 子集，使得这两个子集中元素的乘积都等于 target。
 * 如果存在这样的划分，返回 true；否则，返回 false。
 * 子集 是数组中元素的一个选择集合。
 */
public class CheckEqualPartitions {

    public boolean checkEqualPartitions(int[] nums, long target) {
        return check(nums, 0, 1, 1, target);
    }

    private boolean check(int[] nums, int i, long result1, long result2, long target) {
        if (result1 > target || result2 > target) {
            return false;
        }
        if (i >= nums.length) {
            return result1 == result2 && result1 == target;
        }
        return check(nums, i + 1, result1 * nums[i], result2, target)
                || check(nums, i + 1, result1, result2 * nums[i], target);
    }


    public static void main(String[] args) {
        CheckEqualPartitions checkEqualPartitions = new CheckEqualPartitions();
//        boolean result = checkEqualPartitions.checkEqualPartitions(new int[]{40,15,92,65,42,7,80,17,46,68,78,48}, 4098931200L);
        boolean result = checkEqualPartitions.checkEqualPartitions(new int[]{3,1,6,8,4}, 1L);
        System.out.println(result);
    }
}
