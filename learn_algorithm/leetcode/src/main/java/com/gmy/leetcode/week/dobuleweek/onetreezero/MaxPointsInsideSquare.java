package com.gmy.leetcode.week.dobuleweek.onetreezero;

import org.checkerframework.checker.units.qual.min;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个二维数组 points 和一个字符串 s ，其中 points[i] 表示第 i 个点的坐标，s[i] 表示第 i 个点的 标签 。
 * 如果一个正方形的中心在 (0, 0) ，所有边都平行于坐标轴，且正方形内 不 存在标签相同的两个点，那么我们称这个正方形是 合法 的。
 * 请你返回 合法 正方形中可以包含的 最多 点数。
 * 注意：
 * 如果一个点位于正方形的边上或者在边以内，则认为该点位于正方形内。正方形的边长可以为零。
 *
 * https://leetcode.cn/problems/maximum-points-inside-the-square/description/
 */
public class MaxPointsInsideSquare {

    /**
     * 第一步 计算重复的字母同时计算最小的边长
     * 第二步 便利points 计算是否被包涵
     * @param points
     * @param s
     * @return
     */
    public int maxPointsInsideSquare(int[][] points, String s) {
        int[] minD = new int[26];
        Arrays.fill(minD, Integer.MAX_VALUE);
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int d = Math.max(Math.abs(x), Math.abs(y));
            int c = s.charAt(i) - 'a';
            if (d < minD[c]) {
                // d 是目前最小的，那么 minD[c] 是次小的
                min2 = Math.min(min2, minD[c]);
                minD[c] = d;
            } else {
                // d 可能是次小的
                min2 = Math.min(min2, d);
            }
        }
        int ans = 0;
        for (int d : minD) {
            if (d < min2) {
                ans++;
            }
        }
        return ans;
    }

    private int calXy(int lastPointIndex, int pointIndex, int[][] points, Map<Character, Integer> cache, String s, int min) {
        int[] lastPoint = points[lastPointIndex];
        int[] currPoint = points[pointIndex];
        int lastX = Math.abs(lastPoint[0]);
        int currX = Math.abs(currPoint[0]);
        int lastY = Math.abs(lastPoint[1]);
        int currY = Math.abs(currPoint[1]);
        int maxCurr = Math.max(currX, currY);
        int maxLast = Math.max(lastX, lastY);
        // 计算最小长度
        min = Math.min(min, Math.max(maxCurr, maxLast) - 1);
        if (maxCurr > maxLast) {
            min = Math.min(min, maxCurr);
            cache.put(s.charAt(lastPointIndex), pointIndex);
        } else {
            min = Math.min(min, maxLast);
            cache.put(s.charAt(lastPointIndex), lastPointIndex);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{27,3},{16,32},{23,-14}};
        MaxPointsInsideSquare maxPointsInsideSquare = new MaxPointsInsideSquare();
        int result = maxPointsInsideSquare.maxPointsInsideSquare(ints, "aaa");
        System.out.println(result);
    }

}
