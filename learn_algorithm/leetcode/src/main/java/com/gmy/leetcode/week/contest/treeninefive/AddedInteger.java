package com.gmy.leetcode.week.contest.treeninefive;

import java.util.Arrays;

/**
 * 给你两个长度相等的数组 nums1 和 nums2。
 * 数组 nums1 中的每个元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
 * 在与 x 相加后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
 * 返回整数 x 。
 *
 * https://leetcode.cn/problems/find-the-integer-added-to-array-i/description/
 *
 * 输入：nums1 = [2,6,4], nums2 = [9,7,5]
 * 输出：3
 * 解释：
 *
 * 与 3 相加后，nums1 和 nums2 相等。
 */
public class AddedInteger {

    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }

    public static void main(String[] args) {
        AddedInteger addedInteger = new AddedInteger();
        int result = addedInteger.addedInteger(new int[]{2, 6, 4}, new int[]{9, 7, 5});
        System.out.println(result);
    }
}
