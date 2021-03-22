package com.gmy.leetcode.top100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。返回 滑动窗口中的最大值 。
 */
public class _0239_MaxSlidingWindowReview {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (deque.peek() + k <= i) {
                deque.pop();
            }
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _0239_MaxSlidingWindowReview maxSlidingWindow = new _0239_MaxSlidingWindowReview();
        int[] result = maxSlidingWindow.maxSlidingWindow(new int[]{9, 10, 11, 2, 3, 4}, 3);
        System.out.println(Arrays.toString(result));
    }

}
