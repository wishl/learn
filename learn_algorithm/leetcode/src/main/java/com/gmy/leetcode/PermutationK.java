package com.gmy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * https://leetcode-cn.com/problems/permutation-sequence/
 */
public class PermutationK {

    // 暴力解
    public static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        List<String> result = new ArrayList<>();
        getResult(nums, used, "", result);
        System.out.println(result);
        return result.get(k - 1);
    }

    public static void getResult(int[] num, boolean[] used, String inner, List<String> result) {
        if (inner.length() == num.length) {
            result.add(inner);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            getResult(num, used, inner + num[i], result);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String permutation = getPermutation(3, 3);
        System.out.println(permutation);
    }


}
