package com.gmy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两数之和
 */
public class Sum {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        getResult(result, new ArrayList<Integer>(), 0, candidates, target, 0);
        return new ArrayList<>(result);
    }

    public static void getResult(List<List<Integer>> result, List<Integer> init, int num,
                          int[] candidates, int target, int index) {
        if (num > target) {
            return;
        }
        if (num == target) {
            System.out.println(init);
            List<Integer> copy = new ArrayList<>(init);
            result.add(copy);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            init.add(candidate);
            if (i > index && candidates[i - 1] == candidate) {
                continue;
            }
            getResult(result, init, num + candidate, candidates, target, i + 1);
            init.remove(init.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 6};
        List<List<Integer>> lists = combinationSum2(ints, 8);
        System.out.println(lists);
    }


}
