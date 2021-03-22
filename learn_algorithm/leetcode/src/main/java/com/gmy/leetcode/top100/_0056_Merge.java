package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class _0056_Merge {

    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int[] interval : intervals) {
            queue.offer(interval);
        }
        List<int[]> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            list.add(poll);
            int index = poll[0];
            while (index <= poll[1] && !queue.isEmpty()) {
                int[] peek = queue.peek();
                if (peek[0] <= index) {
                    int[] poll1 = queue.poll();
                    poll[1] = Math.max(poll1[1], poll[1]);
                } else {
                    index++;
                }
            }
        }
        int[][] result = list.toArray(new int[list.size()][2]);
        return result;
    }

    public static void main(String[] args) {
        _0056_Merge merge = new _0056_Merge();
        int[][] result = merge.merge(new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}});
        System.out.println(Arrays.deepToString(result));
    }

}
