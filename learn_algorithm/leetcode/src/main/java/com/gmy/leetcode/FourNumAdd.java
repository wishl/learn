package com.gmy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourNumAdd {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Map<List<Integer>, Object> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                int target1 = target - nums[i] - nums[i1];
                int j = 0, k = nums.length - 1;
                while (j < nums.length) {
                    List<Integer> list = new ArrayList<>();
                    if (j == i || j == i1) {
                        j++;
                        continue;
                    }
                    if (k == i || k == i1) {
                        k--;
                        continue;
                    }
                    if (nums[j] + nums[k] == target1) {
                        list.add(nums[i]);
                        list.add(nums[i1]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        if (!map.containsKey(list)) {
                            map.put(list, "");
                            result.add(list);
                            break;
                        }
                    }
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = fourSum(ints, 0);
        System.out.println(lists);
    }


}
