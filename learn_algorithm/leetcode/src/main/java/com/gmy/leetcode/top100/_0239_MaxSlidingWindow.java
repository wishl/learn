package com.gmy.leetcode.top100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。返回 滑动窗口中的最大值 。
 *
 * todo review 单调栈
 */
public class _0239_MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>(); // 双端队列
        for (int i = 0; i < n; i++) {
            // 1. 入
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast(); // 维护 q 的单调性
            }
            q.addLast(i); // 入队
            // 2. 出
            if (i - q.getFirst() >= k) { // 队首已经离开窗口了
                q.removeFirst();
            }
            // 3. 记录答案
            if (i >= k - 1) {
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                ans[i - k + 1] = nums[q.getFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _0239_MaxSlidingWindow maxSlidingWindow = new _0239_MaxSlidingWindow();
        int[] result = maxSlidingWindow.maxSlidingWindow(new int[]{9, 10, 11, 2, 3, 4}, 3);
        System.out.println(Arrays.toString(result));
    }

}
