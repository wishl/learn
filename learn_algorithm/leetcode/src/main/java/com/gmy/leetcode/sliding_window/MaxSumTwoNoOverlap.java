package com.gmy.leetcode.sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，
 * 长度分别为 firstLen 和 secondLen 。
 * 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。
 * 子数组是数组的一个 连续 部分。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 *
 * 输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
 * 输出：31
 * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maxi0,6,5,2,2,mum-sum-of-two-non-overlapping-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSumTwoNoOverlap {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(help(nums, firstLen, secondLen), help(nums, secondLen, firstLen));
    }

    public int help(int[] nums, int firstLen, int secondLen) {
        int suml = 0;
        for (int i = 0; i < firstLen; ++i) {
            suml += nums[i];
        }
        int maxSumL = suml;
        int sumr = 0;
        for (int i = firstLen; i < firstLen + secondLen; ++i) {
            sumr += nums[i];
        }
        int res = maxSumL + sumr;
        for (int i = firstLen + secondLen, j = firstLen; i < nums.length; ++i, ++j) {
            suml += nums[j] - nums[j - firstLen];
            maxSumL = Math.max(maxSumL, suml);
            sumr += nums[i] - nums[i - secondLen];
            res = Math.max(res, maxSumL + sumr);
        }
        return res;
    }

    public int maxSumTwoNoOverlap1(int[] nums, int firstLen, int secondLen) {
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();
        calSum(nums, firstLen, firstMap);
        calSum(nums, secondLen, secondMap);
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : firstMap.entrySet()) {
            Integer firstIndex = entry.getKey();
            Integer firstValue = entry.getValue();
            int maxRight = secondMap.entrySet().stream()
                    .filter(rightEntry -> rightEntry.getKey() >= firstIndex + firstLen
                                || rightEntry.getKey() <= firstIndex - secondLen)
                    .mapToInt(Map.Entry::getValue).max().orElse(0);
            max = Math.max(max, firstValue + maxRight);
        }
        return max;
    }

    private void calSum(int[] nums, int length, Map<Integer, Integer> map) {
        int left = 0, right = 0, sum = 0;
        while (right < length) {
            sum += nums[right++];
        }
        map.put(left, new Integer(sum));
        while (right < nums.length) {
            sum -= nums[left++];
            sum += nums[right++];
            map.put(left, new Integer(sum));
        }
    }

    public static void main(String[] args) {
        MaxSumTwoNoOverlap maxSumTwoNoOverlap = new MaxSumTwoNoOverlap();
        int[] ints = {73,19,19,55,88,6,34,21,75,5,93,30,4,12,18,98,45,15,8,9,28,56,5,69,55,95,93,46,2,29,
                41,28,74,9,10,14,81, 52,23,57,76,59,18,66,25,87,46,32,96,1};
        int result = maxSumTwoNoOverlap.maxSumTwoNoOverlap(ints, 26, 5);
        System.out.println(result);
    }


}
