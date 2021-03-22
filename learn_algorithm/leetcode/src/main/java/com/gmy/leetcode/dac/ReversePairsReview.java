package com.gmy.leetcode.dac;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @See com.gmy.leetcode.dac.ReversePairs
 */
public class ReversePairsReview {

    public int reversePairs(int[] nums) {
        Map<Integer, Integer> dispersed = dispersed(nums);
        ArrayTree arrayTree = new ArrayTree(nums);
        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = dispersed.get(nums[i]);
            arrayTree.add(index, 1);
            result += arrayTree.sum(index);
        }
        return result;
    }

    /**
     * 防止数字太大 使用index作为key
     * @return
     */
    private Map<Integer, Integer> dispersed(int[] nums) {
        List<Integer> sorted = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numIndexMap.put(sorted.get(i), i + 1);
        }
        return numIndexMap;
    }

    static class ArrayTree {

        private int[] nums;

        public ArrayTree(int[] nums) {
            this.nums = new int[nums.length + 1];
        }

        private int lowBit(int x) {
            return x & -x;
        }

        private void add(int index, int num) {
            for (int i = index; i < nums.length; i += lowBit(i)) {
                nums[i] += num;
            }
        }

        private int sum(int index) {
            int sum = 0;
            // 不包含自己
            for (int i = index - 1; i > 0; i -= lowBit(i)) {
                sum += nums[i];
            }
            return sum;
        }

    }

    public static void main(String[] args) {
        ReversePairsReview reversPairs = new ReversePairsReview();
        int i = reversPairs.reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(i);
    }
}
