package com.gmy.leetcode.prefix;

import java.util.Arrays;

/**
 * 定义一个数组 arr的 转换数组conver为：
 *
 * conver[i] = arr[i] + max(arr[0..i])，其中max(arr[0..i])是满足 0 <= j <= i的所有arr[j]中的最大值。
 * 定义一个数组 arr的 分数为 arr转换数组中所有元素的和。
 *
 * 给你一个下标从 0开始长度为 n的整数数组nums，请你返回一个长度为 n的数组ans，其中ans[i]是前缀nums[0..i]的分数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-score-of-all-prefixes-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [2,3,7,5,10]
 * 输出：[4,10,24,36,56]
 * 解释：
 * 对于前缀 [2] ，转换数组为 [4] ，所以分数为 4 。
 * 对于前缀 [2, 3] ，转换数组为 [4, 6] ，所以分数为 10 。
 * 对于前缀 [2, 3, 7] ，转换数组为 [4, 6, 14] ，所以分数为 24 。
 * 对于前缀 [2, 3, 7, 5] ，转换数组为 [4, 6, 14, 12] ，所以分数为 36 。
 * 对于前缀 [2, 3, 7, 5, 10] ，转换数组为 [4, 6, 14, 12, 20] ，所以分数为 56
 *
 *
 * 输入：nums = [1,1,2,4,8,16]
 * 输出：[2,4,8,16,32,64]
 * 解释：
 * 对于前缀 [1] ，转换数组为 [2] ，所以分数为 2 。
 * 对于前缀 [1, 1]，转换数组为 [2, 2] ，所以分数为 4 。
 * 对于前缀 [1, 1, 2]，转换数组为 [2, 2, 4] ，所以分数为 8 。
 * 对于前缀 [1, 1, 2, 4]，转换数组为 [2, 2, 4, 8] ，所以分数为 16 。
 * 对于前缀 [1, 1, 2, 4, 8]，转换数组为 [2, 2, 4, 8, 16] ，所以分数为 32 。
 * 对于前缀 [1, 1, 2, 4, 8, 16]，转换数组为 [2, 2, 4, 8, 16, 32] ，所以分数为 64 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-score-of-all-prefixes-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-score-of-all-prefixes-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPrefixScore {

    public long[] findPrefixScore(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new long[0];
        }
        int maxPrefix = nums[0];
        long[] result = new long[nums.length];
        long resultPrefix = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPrefix = Math.max(maxPrefix, nums[i]);
            long convert = nums[i] + maxPrefix;
            resultPrefix += convert;
            result[i] = resultPrefix;
        }
        return result;
    }

    public static void main(String[] args) {
        FindPrefixScore findPrefixScore = new FindPrefixScore();
        long[] prefixScore = findPrefixScore.findPrefixScore(new int[]{1,1,2,4,8,16});
        System.out.println(Arrays.toString(prefixScore));
    }
}
