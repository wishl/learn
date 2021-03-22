package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum3 {

    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.result = new ArrayList<>();
        dfs(k, n, new ArrayList<>(), 1);
        return this.result;
    }

    private void dfs(int k, int n, List<Integer> result, int index) {
        if (result.size() == k) {
            if (n == 0) {
                this.result.add(new ArrayList<>(result));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (n - i >= 0) {
                result.add(i);
                dfs(k, n - i, result ,i + 1);
                result.remove(result.size() - 1);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        List<List<Integer>> lists = combinationSum3.combinationSum3(3, 9);
        System.out.println(lists);
    }

}
