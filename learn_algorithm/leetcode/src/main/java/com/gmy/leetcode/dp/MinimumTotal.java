package com.gmy.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于
 * 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * https://leetcode.cn/problems/triangle/description/
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<Integer>() {{add(0);}});
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> innerList = triangle.get(i);
            List<Integer> innerDp = new ArrayList<>();
            for (int j = 0; j < innerList.size(); j++) {
                if (j == 0) {

                }
            }
        }
        return 0;
    }

}
