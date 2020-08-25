package com.gmy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getResult(candidates, target, result, new ArrayList<Integer>(), 0, 0);
//        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private static void getResult(int[] candidates, int target,
                                  List<List<Integer>> result, List<Integer> inner, int num, int index) {
        if (num > target) {
            return;
        }
        if (num == target) {
            result.add(new ArrayList<>(inner));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            inner.add(candidates[i]);
            getResult(candidates, target, result, inner, num + candidates[i], i);
            inner.remove(inner.size() - 1);
        }
    }

    private static void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i])
                continue;
            //选择当前节点，类似于从当前节点开始往下遍历
            cur.add(candidates[i]);
            getResult(result, cur, candidates, target - candidates[i], i);
            //回到当前节点的时候我们把当前节点给移除,
            // 然后通过循环走同一层的其他节点。
            //举个例子，比如上面图中，最开始的时候
            // 我们先选择2，然后沿着这个分支走下去，
            //当回到当前分支的时候我们把2给移除，然后
            // 选择同一层的下一个3，沿着这个节点
            //分支走下去……
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] is = {2, 3, 5};
        List<List<Integer>> lists = combinationSum(is, 8);
        System.out.println(lists);
    }

}
