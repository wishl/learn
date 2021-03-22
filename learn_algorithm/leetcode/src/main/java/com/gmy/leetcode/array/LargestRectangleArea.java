package com.gmy.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int shortestIndex = i;
            for (int j = i; j < heights.length; j++) {
                while (!deque.isEmpty() && heights[j] <= heights[deque.peek()]) {
                    shortestIndex = j;
                    deque.pop();
                }
                int area = heights[shortestIndex] * (j - i + 1);
                max = Math.max(max, area);
                deque.push(shortestIndex);
            }
        }
        return max;
    }

    public int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            // 找到第一个比当前小的值后往左遍历
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }

    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
//        int area = largestRectangleArea.largestRectangleArea(new int[]{2, 1, 6, 5, 2, 3});
        int area = largestRectangleArea.largestRectangleArea(new int[]{5, 6, 5});
        int area1 = largestRectangleArea.largestRectangleArea1(new int[]{5, 6, 5});
        System.out.println(area);
        System.out.println(area1);
    }

}
