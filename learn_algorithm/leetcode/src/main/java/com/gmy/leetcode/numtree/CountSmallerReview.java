package com.gmy.leetcode.numtree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 使用归并解法
 */
public class CountSmallerReview {

    public List<Integer> countSmaller(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        sort(nums, 0, nums.length - 1, countMap);
        List<Integer> collect = Arrays.stream(nums).map(num -> countMap.getOrDefault(num, 0))
                .boxed().collect(Collectors.toList());
        return collect;
    }

    private void sort(int[] nums, int left, int right, Map<Integer, Integer> countMap) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, countMap);
            sort(nums, mid + 1, right, countMap);
            mergeAndCount(nums, left, mid, right, countMap);
        }
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, Map<Integer, Integer> countMap) {
        int[] tmp = new int[nums.length];
        int i = left, j = mid + 1, t = 0;
        int count = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tmp[t++] = nums[i++];
            } else {
                tmp[t++] = nums[j++];
                countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            }
        }
        while (i <= mid) {
            tmp[t++] = nums[i++];
        }
        while (j <= right) {
            tmp[t++] = nums[j++];
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        t = 0;
        while (left <= right) {
            nums[left++] = tmp[t++];
        }
        return count;
    }

    public static void main(String[] args) {
        CountSmallerReview countSmaller = new CountSmallerReview();
        List<Integer> list = countSmaller.countSmaller(new int[]{5,2,6,1});
        System.out.println(list);
    }

}
