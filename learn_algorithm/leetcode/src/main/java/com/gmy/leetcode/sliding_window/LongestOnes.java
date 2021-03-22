package com.gmy.leetcode.sliding_window;

/**
 * 给定一个二进制数组nums和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,0,0,0,0,1,1,1,1], K = 3
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestOnes {

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, max = 0, j = k;
        while (right < nums.length) {
            if (nums[right] == 1 || j > 0) {
                if (nums[right] != 1) {
                    j--;
                }
                right++;
            } else {
                if (nums[left] != 1 && k > 0) {
                    j++;
                }
                left++;
            }
            max = Math.max(max, right - left);
            if (right < left) {
                right = left;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestOnes longestOnes = new LongestOnes();
        int i = longestOnes.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
        System.out.println(i);
    }
}
