package com.gmy.leetcode.sliding_window;

/**
 * 给你一个二进制数组nums，你需要从中删掉一个元素。
 *
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 *
 * 如果不存在这样的子数组，请返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubarraylongestSubarray {

    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, deleteIndex = -1, result = 0;
        while (right < nums.length) {
            if (nums[right] != 1 && deleteIndex == -1) {
                deleteIndex = right;
            }
            while (deleteIndex != -1 && deleteIndex != right && nums[right] == 0) {
                // 需要减去被删除的数字
                result = Math.max(result, right - left - 1);
                if (left == deleteIndex) {
                    deleteIndex = -1;
                }
                left++;
            }
            if (nums[right] == 1 || deleteIndex == right) {
                right++;
            }
        }
        result = Math.max(result, right - left - 1);
        return result;
    }

    public static void main(String[] args) {
        LongestSubarraylongestSubarray longestSubarraylongestSubarray = new LongestSubarraylongestSubarray();
        int[] nums = new int[] {0, 0, 0};
        int result = longestSubarraylongestSubarray.longestSubarray(nums);
        System.out.println(result);
    }

}
