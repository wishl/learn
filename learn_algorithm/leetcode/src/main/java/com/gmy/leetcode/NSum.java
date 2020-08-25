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

    public static void main(String[] args) {
        int[] is = {2, 3, 5};
        List<List<Integer>> lists = combinationSum(is, 8);
        System.out.println(lists);
    }

}
