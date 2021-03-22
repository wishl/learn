package com.gmy.leetcode.monostone_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈查询比x大的第一个数
 */
public class SimpleGreaterElement {

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i % length] < nums[deque.peek()]) {
                result[deque.pop()] = nums[i];
            }
            deque.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        SimpleGreaterElement nextGreaterElementsII = new SimpleGreaterElement();
        int[] ints = nextGreaterElementsII.nextGreaterElements(new int[]{1, 0, 2, 1});
        System.out.println(Arrays.toString(ints));
    }
}
