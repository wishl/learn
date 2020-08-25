package com.gmy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * https://leetcode-cn.com/problems/increasing-subsequences/
 */
public class FindSubsequences {

    static List<Integer> temp = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();


    public static List<List<Integer>> findSubsequences(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        getResult(nums, new ArrayList<Integer>(), result, 0, Integer.MIN_VALUE);
//        dfs(0, Integer.MIN_VALUE, nums);
        return result;
//        return ans;
    }

    private static void getResult(int[] nums, List<Integer> inner, List<List<Integer>> result, int index, int num) {
        if (index == nums.length) {
            if (inner.size() >= 2) {
                List<Integer> list = new ArrayList<>(inner);
                result.add(list);
            }
            return;
        }
        if (num <= nums[index]) {
            inner.add(nums[index]);
            getResult(nums, inner, result, index + 1, nums[index]);
            inner.remove(inner.size() - 1);
        }
        if (nums[index] != num) {
            getResult(nums, inner, result, index + 1, num);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> result = findSubsequences(nums);
        System.out.println(result);
    }

}
