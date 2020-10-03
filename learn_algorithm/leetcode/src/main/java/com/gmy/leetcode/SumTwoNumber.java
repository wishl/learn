package com.gmy.leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumTwoNumber {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int i1 = nums[i];
            for (int j = nums.length - 1; j > i ; j--) {
                int j1 = nums[j];
                if (i1 + j1 == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 7, 11, 15};
        int[] ints1 = twoSum(ints, 9);
        System.out.println(Arrays.toString(ints1));
    }


}
