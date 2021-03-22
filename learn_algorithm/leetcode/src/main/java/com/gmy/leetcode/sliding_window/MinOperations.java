package com.gmy.leetcode.sliding_window;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，
 * 你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。
 * 请注意，需要 修改 数组以供接下来的操作使用。
 * 如果可以将 x恰好 减到0 ，返回 最小操作数 ；否则，返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 */
public class MinOperations {

    // 计算sum - 中间 = x
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < x) {
            return -1;
        }
        int left = 0, right = 0, sub = 0, min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sub += nums[right];
            while (sub > sum - x) {
                sub -= nums[left];
                left++;
            }
            if (sum - sub == x) {
                min = Math.min(min, nums.length - (right - left + 1));
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        int[] arr = new int[] {5,6,7,8,9};
        int result = minOperations.minOperations(arr, 4);
        System.out.println(result);
    }
}
