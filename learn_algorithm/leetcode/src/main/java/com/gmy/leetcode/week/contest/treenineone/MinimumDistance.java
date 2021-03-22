package com.gmy.leetcode.week.contest.treenineone;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。
 * 两点之间的距离定义为它们的 曼哈顿距离。
 *
 * 请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。
 *
 * 示例 1：
 *
 * 输入：points = [
 *                [3,10],
 *                [5,15],
 *                [10,2],
 *                [4,4]
 *                ]
 * 输出：12
 * 解释：移除每个点后的最大距离如下所示：
 * - 移除第 0 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间，为 |5 - 10| + |15 - 2| = 18 。
 * - 移除第 1 个点后，最大距离在点 (3, 10) 和 (10, 2) 之间，为 |3 - 10| + |10 - 2| = 15 。
 * - 移除第 2 个点后，最大距离在点 (5, 15) 和 (4, 4) 之间，为 |5 - 4| + |15 - 4| = 12 。
 * - 移除第 3 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间的，为 |5 - 10| + |15 - 2| = 18 。
 * 在恰好移除一个点后，任意两点之间的最大距离可能的最小值是 12 。
 */
public class MinimumDistance {

    public int minimumDistance(int[][] points) {
        int max = maxDistance(points);
        int left = 1, right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean check = check(points, mid);
            // mid >= 去除一个点后最大的距离 所以需要尝试减小mid
            if (check) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }

    private boolean check(int[][] points, int mid) {
        int max = 0, second = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                if (Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]) >= max) {
                    second = max;
                    max = distance;
                }
            }
        }
        return second <= mid;
    }

    private int maxDistance(int[][] points) {
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                max = Math.max(distance, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MinimumDistance minimumDistance = new MinimumDistance();
        int result = minimumDistance.minimumDistance(new int[][]{{3, 10}, {5, 15}, {10, 2}, {4, 4}});
        System.out.println(result);
    }

}
