package com.gmy.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * https://leetcode-cn.com/problems/permutations-ii/
 */
// i > depth 证明已经开始回溯，并且i++过，
// !used[i] 证明没有选择过
// 以 1 ，1 ，2为例
// depth == 2 时的循环 中会有 ==》 [2]
// 如果不加，会出现当nums[i - 1] == nums[i]
// 会判断 1 == 1 从而过度枝减
// 为什么是!used[i - 1] 当我们回溯到 [2]的时候
// 以 1,1,2为例
// 当回溯到2时
// 1. [2, 1] == > used[0] = true used[1] = false used[2] = true
// 2. [2, 1, 1] == > used[0] = true used[1] = true used[2] = true
// 3. 开始回溯
// 4. [2, 1] ==> used[0] = true used[1] = false used[2] = true
// 5. i++ ==> i = 2 ==> 因为used[2] == true所以跳过
// 6. 在回溯
// 7.[2] ==> used[0] = false used[1] = false used[2] = true
// 8.i++ ==> i == 1 ==>[2, 1] 此时会有重复的枝[2, 1] 如果加入则 used[0] = false used[1] = true used[2] = true
// 所以判断i的上一个是否被用到过就行
// 总体来说，只需要判断紧挨着的i是否，如果数据重复并且不是紧挨着的则需要枝减
// 其实!used[i - 1] 和 used[i - 1]的判断是一样的，!used[i - 1] 相当于在枝减时选择了最左边的，因为回溯的缘故，一定存在一个循环计算了最左边的数
// used[i - 1] 相当于在枝减时选择了最右边的数
public class PermuteUnique {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (len == 0) {
            return res;
        }
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        boolean[] used = new boolean[nums.length];
        dfs(nums, len, 0, path, res, used);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, List<List<Integer>> res, boolean used[]) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, res, used);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = permuteUnique(new int[]{1, 0,0,9});
        System.out.println(result);
    }

}
