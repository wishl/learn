package com.gmy.leetcode.dac;

import com.gmy.leetcode.numtree.ReversPairs1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class ReversePairs {

    /**
     * 整体思路，先对数组排序 并记录下index
     * 每次计算当前index之前还有多少数则有多少个逆序对
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        Map<Integer, Integer> dispersed = dispersed(nums);
        ArrayTree arrayTree = new ArrayTree(nums);
        int search = 0;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            Integer index = dispersed.get(nums[i]);
            arrayTree.add(index, 1);
            search += arrayTree.search(index);
        }
        return search;
    }

    private Map<Integer, Integer> dispersed(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> sorted = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());
        for (int i = 0; i < sorted.size(); i++) {
            map.put(sorted.get(i), i + 1);
        }
        return map;
    }

    class ArrayTree {

        private int[] nums;

        public ArrayTree(int[] nums) {
            this.nums = new int[nums.length + 1];
        }

        public int lowBit(int x) {
            return x & -x;
        }

        public void add(int index, int num) {
            for (int i = index; i < nums.length; i += lowBit(i)) {
                nums[i] += num;
            }
        }

        public int search(int index) {
            int result = 0;
            // 不包含自己
            for (int i = index - 1; i > 0; i -= lowBit(i)) {
                result += nums[i];
            }
            return result;
        }

    }

    public static void main(String[] args) {
        ReversePairs reversPairs = new ReversePairs();
        int i = reversPairs.reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(i);
    }


}
