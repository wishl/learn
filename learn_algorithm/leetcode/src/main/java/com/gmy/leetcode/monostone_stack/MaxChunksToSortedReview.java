package com.gmy.leetcode.monostone_stack;

import java.util.Deque;
import java.util.LinkedList;

public class MaxChunksToSortedReview {

    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            while (!deque.isEmpty() && arr[deque.peek()] > arr[i]) {
                index = arr[deque.peek()] > arr[index] ? deque.peek() : index;
                deque.pop();
            }
            deque.push(index);
        }
        return deque.size();
    }

    public static void main(String[] args) {
        MaxChunksToSortedReview maxChunksToSortedReview = new MaxChunksToSortedReview();
        int i = maxChunksToSortedReview.maxChunksToSorted(new int[]{1,4,0,2,3,5});
        System.out.println(i);
    }

}
