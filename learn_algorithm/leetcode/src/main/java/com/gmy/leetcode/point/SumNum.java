package com.gmy.leetcode.point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个num 数组和一个 target 计算 a + b + c = target 的所有index
 */
public class SumNum {

    public List<List<Integer>> calSumNum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    List<Integer> list = Arrays.asList(indexMap.get(nums[i]),
                            indexMap.get(nums[left]), indexMap.get(nums[right]));
                    result.add(list);
                    break;
                } else if (nums[left] + nums[right] > sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public Map<Integer, List<Set<Integer>>> calPrefix(int[] nums) {
        Map<Integer, List<Set<Integer>>> prefixMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < i; j++) {
                sum += nums[j];
                List<Set<Integer>> indexList = prefixMap.getOrDefault(sum, new ArrayList<>());
                Set<Integer> indexSet = Stream.of(i, j).collect(Collectors.toSet());
                indexList.add(indexSet);
                prefixMap.put(sum, indexList);
                sum -= nums[j];
            }
        }
        return prefixMap;
    }

    public List<List<Integer>> calSumNum1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Set<Integer>>> prefixMap = calPrefix(nums);
        for (int i = 0; i < nums.length; i++) {
            int prefix = target - nums[i];
            if (prefixMap.containsKey(prefix)) {
                calResult(result, prefixMap.get(prefix), i);
            }
        }
        return result;
    }

    private void calResult(List<List<Integer>> result, List<Set<Integer>> list, int index) {
        for (Set<Integer> set : list) {
            if (!set.contains(index)) {
                List<Integer> collect = set.stream().collect(Collectors.toList());
                collect.add(index);
                result.add(collect);
            }
        }
    }


        public static void main(String[] args) {
        SumNum sumNum = new SumNum();                       // 0  1  2   3  4  5  6
        List<List<Integer>> lists = sumNum.calSumNum(new int[]{3, 2, 1, -1, 6, 8, 11}, 6);
//        List<List<Integer>> lists1 = sumNum.calSumNum1(new int[]{1, 2, 3, 3, 4, 5, 2, 1}, 6);
        System.out.println(lists);
//        System.out.println(lists1);
    }

}
