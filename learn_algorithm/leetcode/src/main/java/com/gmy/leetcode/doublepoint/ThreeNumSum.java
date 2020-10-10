package com.gmy.leetcode.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeNumSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int result = nums[i];
            int start = i + 1, end = n - 1;
            while (end > start) {
                // 大于左指针++
                if ((result + nums[start] + nums[end]) == 0) {
                    initResult(list, result, nums[start], nums[end], set);
                    start++;
                    end--;
                }
                if ((result + nums[start] + nums[end]) > 0) {
                    end--;
                } else if ((result + nums[start] + nums[end]) < 0) {
                    start++;
                }
            }
        }
        return list;
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

    private static void initResult(List<List<Integer>> list, int num, int num2, int num3, Set<List<Integer>> set) {
        List<Integer> inner = new ArrayList<>();
        inner.add(num);
        inner.add(num2);
        inner.add(num3);
        if (!set.contains(inner)) {
            list.add(inner);
        }
        set.add(inner);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

}
