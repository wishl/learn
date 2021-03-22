package com.gmy.leetcode.numtree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        // 后缀
        int[] post = new int[nums.length];
        post[nums.length - 1] = 1;
        for (int i =  nums.length - 2; i >= 0; i--) {
            post[i] = nums[i] <= nums[i + 1] ? post[i + 1] + 1 : 1;
        }
        System.out.println(Arrays.toString(post));
        return 0;
    }

    private Map<Integer, Integer> dispersed(int[] nums) {
        List<Integer> sortList = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortList.size(); i++) {
            map.put(sortList.get(i), i + 1);
        }
        return map;
    }

    static class NumTree {

        private int[] nums;

        public NumTree(int[] nums) {
            this.nums = new int[nums.length + 1];
        }

        private int lowBit(int x) {
            return x & -x;
        }

        public void add(int num, int index) {
            for (int i = index; i < nums.length; i += lowBit(i)) {
                nums[i] += num;
            }
        }

        public int sum(int index) {
            int result = 0;
            for (int i = index; i > 0; i -= lowBit(i)) {
                result += nums[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,5,4,7};
        FindNumberOfLIS findNumberOfLIS = new FindNumberOfLIS();
        int numberOfLIS = findNumberOfLIS.findNumberOfLIS(nums);
        System.out.println(numberOfLIS);
    }

}
