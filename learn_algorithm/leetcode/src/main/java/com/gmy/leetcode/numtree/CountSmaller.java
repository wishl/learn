package com.gmy.leetcode.numtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountSmaller {

    private int[] nums;

    public List<Integer> countSmaller(int[] nums) {
        // 防止数据过大，离散化
        Map<Integer, Integer> dispersed = dispersed(nums);
        this.nums = new int[nums.length + 1];
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            Integer index = dispersed.get(nums[i]);
            add(index);
            result.add(sum(index - 1));
        }
        Collections.reverse(result);
        return result;
    }

    private Map<Integer, Integer> dispersed(int[] nums) {
        Map<Integer, Integer> result = new HashMap<>();
        List<Integer> list = Arrays.stream(nums).distinct().sorted().boxed().collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
           result.putIfAbsent(list.get(i), i + 1);
        }
        return result;
    }

    private void add(int index) {
        for (int i = index; i < nums.length; i += lowBit(i)) {
            nums[i] += 1;
        }
    }

    private int sum(int index) {
        int result = 0;
        for (int i = index; i > 0; i -= lowBit(i)) {
            result += nums[i];
        }
        return result;
    }

    private int lowBit(int x) {
        return x & -x;
    }

    public static void main(String[] args) {
        CountSmaller countSmaller = new CountSmaller();
        List<Integer> list = countSmaller.countSmaller(new int[]{-1, -1});
        System.out.println(list);
    }

}
