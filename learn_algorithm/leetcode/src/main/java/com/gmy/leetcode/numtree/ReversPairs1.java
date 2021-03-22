package com.gmy.leetcode.numtree;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class ReversPairs1 {

    /**
     * 使用树状数组
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        Map<Integer, Integer> disMap = dis(nums);
        NumTree numTree = new NumTree(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer index = disMap.get(nums[i]);
            numTree.add(index, 1);
            result += numTree.sum(index);
        }
        return result;
    }

    private Map<Integer, Integer> dis(int[] nums) {
        List<Integer> descList = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < descList.size(); i++) {
            result.put(descList.get(i), i + 1);
        }
        return result;
    }

    static class NumTree {

        private int[] nums;

        public NumTree(int[] nums) {
            this.nums = new int[nums.length + 1];
        }

        private int lowBit(int x) {
            return x & -x;
        }
        
        public int sum(int index) {
            int result = 0;
            for (int i = index; i > 0; i -= lowBit(i)) {
                result += nums[i];
            }
            return result;
        }

        private void add(int index, int num) {
            for (int i = index + 1; i < nums.length; i += lowBit(i)) {
                nums[i] += num;
            }
        }
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int i = reversePairs.reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(i);
        ReversPairs1 reversPairs1 = new ReversPairs1();
        i = reversPairs1.reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(i);
    }

}
