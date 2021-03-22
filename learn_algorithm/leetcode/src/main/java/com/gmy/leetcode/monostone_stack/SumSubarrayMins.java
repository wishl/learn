package com.gmy.leetcode.monostone_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-of-subarray-minimums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumSubarrayMins {

    /**
     * [11,81,94,43,3]
     * [11] [81] [94] [43] [3] 232
     * [11, 81] [11, 81, 94] [11, 81,94, 43] [11,81,94,43,3] 36
     * [81, 94] [81, 94, 43] [81, 94, 43, 3] 127
     * [94, 43] [94, 43, 3] 46
     * [43, 3] 3
     *
     * 11 + 81 + 11 + 94 + 11 + 43 + 11 + 3
     *
     *
     * @param arr
     * @return
     */
    public int sumSubarrayMins(int[] arr) {
        long result = -arr[0];
        int min = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        int[] copy = new int[arr.length + 1];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        for (int i = 0; i < copy.length; i++) {
            while (!deque.isEmpty() && copy[deque.peekLast()] >= copy[i]) {
                Integer index = deque.pollLast();
                min = Math.min(arr[index], min);
                result += arr[index];
                result += arr[index] * deque.size();
            }
            deque.push(i);
        }
        result += (min * arr.length - 1);
        return (int) (result % 1000000000);
    }

    /**
     *
     * @param arr
     * @return
     */
    public int sumSubarrayMins1(int[] arr) {
        int result = 0;
        Deque<Integer> deque = new LinkedList<>();
        int N = arr.length - 1;
        for (int i = N; i >= 0 ; i--) {
            result += arr[i];
            int min = i;
            while (!deque.isEmpty() &&  arr[i] > arr[deque.peek()]) {
                min = arr[deque.peek()] < arr[min] ? deque.peek() : min;
                deque.pop();
            }
            result += (arr[min] * (N - i));
            deque.push(min);
        }
        return result;
    }

    public static void main(String[] args) {
        SumSubarrayMins sumSubarrayMins = new SumSubarrayMins();
        int result = sumSubarrayMins.sumSubarrayMins1(new int[]{3,4,2,1});
        System.out.println(result);
    }

}
