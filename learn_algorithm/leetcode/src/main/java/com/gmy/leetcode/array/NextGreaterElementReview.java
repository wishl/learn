package com.gmy.leetcode.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * nums1中数字x的 下一个更大元素 是指x在nums2 中对应位置 右侧 的 第一个 比x大的元素。
 * 给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，其中nums1是nums2的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreaterElementReview {

    /**
     * 单调栈 右至左
     * @return
     */
    public int[] nextGreaterElementReview(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        int[] result = new int[nums1.length];
        Deque<Integer> deque = new LinkedList<>();
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums2[i] > deque.peek()) {
                deque.pop();
            }
            valueMap.put(nums2[i], deque.peek() == null ? -1 : deque.peek());
            deque.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = valueMap.get(nums1[i]);
        }
        return result;
    }

    public int[] nextGreaterElementReview1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        int[] result = new int[nums1.length];
        Deque<Integer> deque = new LinkedList<>();
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            while (!deque.isEmpty() && nums2[i] > deque.peek()) {
                valueMap.put(deque.pop(), nums2[i]);
            }
            deque.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = valueMap.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementReview nextGreaterElement = new NextGreaterElementReview();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 0, 3, 4, 2};
        int[] ints = nextGreaterElement.nextGreaterElementReview(nums1, nums2);
        int[] ints1 = nextGreaterElement.nextGreaterElementReview1(nums1, nums2);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
    }
}