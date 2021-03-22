package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * https://leetcode.cn/problems/combination-sum-iii/description/
 *
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 */
public class _0216_CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int sum, int k, int index) {
        if (sum == 0 && k == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum <= 0 || path.size() > k) {
            return;
        }
        for (int i = index; i < 10; i++) {
            path.add(i);
            dfs(result, path, sum - i, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        _0216_CombinationSum3 combinationSum3 = new _0216_CombinationSum3();
        List<List<Integer>> result = combinationSum3.combinationSum3(3, 9);
        System.out.println(result);
    }
}
