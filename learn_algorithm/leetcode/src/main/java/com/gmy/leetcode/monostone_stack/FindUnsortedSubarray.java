package com.gmy.leetcode.monostone_stack;

import java.util.Deque;
import java.util.LinkedList;

public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE - 1;
        deque.push(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[deque.peek()] <= nums[i]) {
                deque.push(i);
                continue;
            }
            int max = i;
            while (!deque.isEmpty() && nums[deque.peek()] > nums[i]) {
                Integer pop = deque.pop();
                left = Math.min(left, pop);
                max = nums[max] > nums[pop] ? max : pop;
                right = i;
            }
            // 存储最大值
            deque.push(max);
        }
        return (right - left) + 1;
    }

    public static void main(String[] args) {
//        int[] ints = new int[] {1,3,3,3,2};
        int[] ints = new int[] {1,3,5,2,4};
        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        int unsortedSubarray = findUnsortedSubarray.findUnsortedSubarray(ints);
        System.out.println(unsortedSubarray);
    }

}
