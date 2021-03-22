package com.gmy.leetcode.top100;

import java.util.Arrays;

/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 *
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
 * 并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * todo review 二分法
 */
public class _0274_HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = citations.length - 1, h = 0;
        // 0 1 3 5 6
        // 因为后面至少是等于前面的 所以 > h 就可以算出h
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        _0274_HIndex hindex = new _0274_HIndex();
        int result = hindex.hIndex(new int[]{0, 1, 3, 3, 6});
        System.out.println(result);
    }




}
