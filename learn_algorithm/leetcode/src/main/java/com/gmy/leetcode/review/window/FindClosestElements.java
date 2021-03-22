package com.gmy.leetcode.review.window;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 */
public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int sum = 0, gap = Integer.MAX_VALUE, start = 0, end = 0;
        List<Integer> result = new ArrayList<>();
        while (end < arr.length) {

        }
        return result;
    }

}
