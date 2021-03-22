package com.gmy.leetcode.monostone_stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给你一份工作时间表hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-well-performing-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestWPI {

    public int longestWPI(int[] hours) {
        int result = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < hours.length; i++) {
            int right = i;
            if (!deque.isEmpty() && hours[i] < 8) {
                deque.pop();
            }
            if (!deque.isEmpty()) {
                deque.peek();
            }
        }
        return result;
    }

}
