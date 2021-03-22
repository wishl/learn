package com.gmy.leetcode.monostone_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个循环数组nums（nums[nums.length - 1]的下一个元素是nums[0]），返回nums中每个元素的 下一个更大元素 。
 *
 * 数字 x的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreaterElementsII {

    public int[] nextGreaterElementsII(int[] nums) {
        int length = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[length];
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * nums.length - 1; i++) {
            while (!deque.isEmpty() && nums[i % length] > nums[deque.peek() % i]) {
                result[deque.pop() % i] = nums[i % length];
            }
            deque.push(i % length);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementsII nextGreaterElementsII = new NextGreaterElementsII();
        int[] ints = nextGreaterElementsII.nextGreaterElementsII(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(ints));
    }
}
