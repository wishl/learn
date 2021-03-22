package com.gmy.leetcode.review;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int right = nums.length - 1, i = 0;
        while (i < nums.length) {
            int num = nums[i], left = i + 1;
            right = nums.length - 1;
            if (num == -3) {
                System.out.println(111);
            }
            while (left < right) {
                int numLeft = nums[left];
                int numRight = nums[right];
                if (numLeft + numRight > -num) {
                    right--;
                } else if (numLeft + numRight < -num) {
                    left++;
                } else {
                    List<Integer> res = new ArrayList<>();
                    res.add(num);
                    res.add(numLeft);
                    res.add(numRight);
                    result.add(res);
                    while (left < right && nums[left] == numLeft) {
                        left++;
                    }
                    while (left < right && nums[right] == numRight) {
                        right--;
                    }
                }
            }
            while (i < nums.length && nums[i] == num) {
                i++;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            int right = nums.length - 1, left = i + 1;
            while (left < right) {
                int numLeft = nums[left];
                int numRight = nums[right];
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }
                if (numLeft + numRight > -num) {
                    right--;
                } else if (numLeft + numRight < -num) {
                    left++;
                } else {
                    result.add(Stream.of(num, numLeft, numRight).collect(Collectors.toCollection(ArrayList::new)));
                    while (left < right && nums[left] == numLeft) {
                        left++;
                    }
                    while (left < right && nums[right] == numRight) {
                        right--;
                    }
                }
            }
            while (i < nums.length && nums[i] == num) {
                i++;
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        // -4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4
        int[] ints = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        List<List<Integer>> result = threeSum.threeSum2(new int[]{-4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4});
        System.out.println(result);
    }
}
