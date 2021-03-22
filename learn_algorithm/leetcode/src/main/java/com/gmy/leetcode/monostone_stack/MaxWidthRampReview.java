package com.gmy.leetcode.monostone_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxWidthRampReview {

    /**
     * 首先 从lastIndex往前找 满足条件的无需重复计算 因为即使 lastIndex - 1 和 该值也满足需求
     * 长度必定也比最后一个index要短 只需再往前找更小的即可
     * @param arr
     * @return
     */
    public int maxWidthRamp(int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        int result = 0;
        // 先维护单调递减队列
        for (int i = 0; i < arr.length; i++) {
            if (deque.isEmpty() || arr[deque.peek()] > arr[i]) {
                deque.push(i);
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && arr[deque.peek()] <= arr[i]) {
                Integer j = deque.pop();
                result = Math.max(result, i - j);
            }
        }
        return result;
    }

    /**
     * 另一种方式 可以先根据大小做id升序 再顺序寻找
     * @param arr
     * @return
     */
    public int maxWidthRamp1(int[] arr) {
        int result = 0;
        Integer[] indexes = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (i, j) -> ((Integer) arr[i]).compareTo(arr[j]));
        int j = arr.length;
        for (Integer i : indexes) {
            result = Math.max(result, i - j);
            j = Math.min(j, i);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxWidthRampReview maxWidthRamp = new MaxWidthRampReview();
        int i = maxWidthRamp.maxWidthRamp1(new int[]{9,8,1,0,1,9,4,0,4,1});
        System.out.println(i);
    }
}
