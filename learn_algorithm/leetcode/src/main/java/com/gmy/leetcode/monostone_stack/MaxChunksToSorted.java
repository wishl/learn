package com.gmy.leetcode.monostone_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 * 返回数组能分成的最多块数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-chunks-to-make-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxChunksToSorted {

    /**
     * 找到比当前index大的第一个数，再这个数之前切一刀即可
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);
        for (int i = 1; i < arr.length; i++) {
            Integer lastIndex = stack.peekLast();
            if (arr[lastIndex] < arr[i]) {
                stack.addLast(i);
                continue;
            }
            int max = stack.peekLast();
            while (!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) {
                stack.removeLast();
            }
            stack.addLast(max);
        }
        return stack.size();
    }

    public static void main(String[] args) {
        MaxChunksToSorted maxChunksToSorted = new MaxChunksToSorted();
//        int result = maxChunksToSorted.maxChunksToSorted(new int[]{1, 2, 0, 3});
//        int result = maxChunksToSorted.maxChunksToSorted(new int[]{2, 0, 1});
        int result = maxChunksToSorted.maxChunksToSorted(new int[]{1,0,2,3,4});
        System.out.println(result);
    }

}
