package com.gmy.leetcode.doublepoint;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        int gap = Integer.MAX_VALUE;
        // 如果最大的比target小则最接近的是最大的三个的和
        int max = nums[n - 1] + nums[n - 2] + nums[n - 3];
        if (max <= target) {
            return max;
        }
        // 如果最小的比target大则最接近的是最小的三个的和
        int min = nums[0] + nums[1] + nums[2];
        if (min >= target) {
            return min;
        }
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int count = nums[start] + nums[i] + nums[end];
                if (count == target) {
                    return target;
                }
                if (Math.abs(target - count) < gap) {
                    result = count;
                    gap = Math.abs(target - count);
                }
                if (count < target) {
                    start++;
                }
                if (count > target) {
                    end--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] is = {-1, 2, 1, -4};
        int result = threeSumClosest(is, 1);
        System.out.println(result);
    }
}
