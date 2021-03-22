package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * https://leetcode-cn.com/problems/increasing-subsequences/
 * 解题：https://leetcode-cn.com/problems/increasing-subsequences/solution/cong-ben-zhi-dai-ni-li-jie-ru-he-qu-zhong-by-shiji/
 */
public class FindSubsequences {

    private List<List<Integer>> result;

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        // 选择当前
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        // 选择下一个
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }

    public static void main(String[] args) {
        FindSubsequences findSubsequences = new FindSubsequences();
        int[] ints = new int[] {4,6,7,7};
        List<List<Integer>> result = findSubsequences.findSubsequences(ints);
        System.out.println(result);
    }

    // [[4, 6, 7, 7], [4, 6, 7], [4, 6], [4, 7, 7], [4, 7], [6, 7, 7], [6, 7], [7, 7]]
    // [[7, 7], [4, 6, 7], [4, 6], [4, 7], [6, 7]]


}
