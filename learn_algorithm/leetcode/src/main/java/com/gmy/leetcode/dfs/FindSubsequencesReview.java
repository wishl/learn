package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindSubsequencesReview {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, Integer.MIN_VALUE, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int last, int index, List<List<Integer>> result, List<Integer> inner) {
        if (index == nums.length) {
            if (inner.size() >= 2) {
                result.add(new ArrayList<>(inner));
            }
            return;
        }
        if (nums[index] >= last) {
            inner.add(nums[index]);
            dfs(nums, nums[index], index + 1, result, inner);
            inner.remove(inner.size() - 1);
        }
        if (nums[index] != last) {
            dfs(nums, last, index + 1, result, inner);
        }
    }

    public static void main(String[] args) {
        FindSubsequencesReview findSubsequences = new FindSubsequencesReview();
        int[] ints = new int[] {4,6,7,7};
        List<List<Integer>> result = findSubsequences.findSubsequences(ints);
        System.out.println(result);
    }

}
