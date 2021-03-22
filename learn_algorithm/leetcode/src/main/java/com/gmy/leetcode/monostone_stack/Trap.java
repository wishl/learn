package com.gmy.leetcode.monostone_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * https://leetcode.cn/problems/trapping-rain-water/
 */
public class Trap {

    /**
     * 把当前当做最大的，如果后面有比自己小则弹出
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!deque.isEmpty() && height[i] > height[deque.peek()]) {
                Integer index = deque.pop();
                int right = i;
                if (!deque.isEmpty()) {
                    int left = deque.peek();
                    int high = Math.min(height[left], height[right]) - height[index];
                    sum += ((right - left - 1) * high);
                }
            }
            deque.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
//        int result = trap.trap(new int[]{4,2,0,3,2,5});
        int result = trap.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(result);
    }

}
