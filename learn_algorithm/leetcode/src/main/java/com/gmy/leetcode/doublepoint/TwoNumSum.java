package com.gmy.leetcode.doublepoint;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class TwoNumSum {

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] result = new int[2];
        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            }else if (numbers[start] + numbers[end] < target) {
                start++;
            }else {
                break;
            }
        }
        result[0] = start + 1;
        result[1] = end + 1;
        return result;
    }

    public static void main(String[] args) {
        int[] is = {2, 7, 11, 15};
        int[] result = twoSum(is, 17);
        System.out.println(Arrays.toString(result));
    }

}
