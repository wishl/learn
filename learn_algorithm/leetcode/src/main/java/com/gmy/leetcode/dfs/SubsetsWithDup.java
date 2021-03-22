package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubsetsWithDup {

    private List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0, Integer.MAX_VALUE);
        return result;
    }

    private void dfs(int nums[], List<Integer> result, int index, int last) {
        if (index == nums.length) {
            this.result.add(new ArrayList<>(result));
            return;
        }
        // 选择当前
        result.add(nums[index]);
        dfs(nums, result, index + 1, nums[index]);
        result.remove(result.size() - 1);
        // 选择下一个 （如果有重复 则保留前面不保留后面）
        if (last != nums[index]) {
            dfs(nums, result, index + 1, last);
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup subsets = new SubsetsWithDup();
        int[] nums = new int[] {1, 2, 2, 3};
        List<List<Integer>> lists = subsets.subsetsWithDup(nums);
        System.out.println(lists);
    }

}
