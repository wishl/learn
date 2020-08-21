package com.gmy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Divide {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        getResult(result, new ArrayList<Integer>(), 0, candidates, target, 0);
        return new ArrayList<>(result);
    }

    public static void getResult(Set<List<Integer>> result, List<Integer> init, int num,
                          int[] candidates, int target, int index) {
        if (num > target) {
            return;
        }
        if (num == target) {
            List<Integer> copy = new ArrayList<>(init);
            result.add(copy);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            init.add(candidate);
            getResult(result, init, num + candidate, candidates, target, i + 1);
            init.remove(init.indexOf(candidate));
        }
    }

    public static void main(String[] args) {
        int[] ints = {2,5,2,1,2};
        List<List<Integer>> lists = combinationSum2(ints, 5);
        System.out.println(lists);
    }


}
