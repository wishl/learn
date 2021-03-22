package com.gmy.leetcode.half.answer;

/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，
 * citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的
 * （n 篇论文中）至少 有 h 篇论文分别被引用了至少 h 次。
 * 请你设计并实现对数时间复杂度的算法解决此问题。
 */
public class HIndex {

    /**
     * 二分答案法
     * left 和 right 维护的是未知的范围 left左边是满足条件的范围 返回
     * https://leetcode.cn/problems/h-index-ii/solutions/2504326/tu-jie-yi-tu-zhang-wo-er-fen-da-an-si-ch-d15k/
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (citations[mid] > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int hIndex1(int[] citations) {
        // 在区间 (left, right) 内询问
        int n = citations.length;
        int left = 0;
        int right = n + 1;
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // left 的回答一定为「是」
            // right 的回答一定为「否」
            int mid = (left + right) >>> 1;
            // 引用次数最多的 mid 篇论文，引用次数均 >= mid
            if (citations[n - mid] >= mid) {
                left = mid; // 询问范围缩小到 (mid, right)
            } else {
                right = mid; // 询问范围缩小到 (left, mid)
            }
        }
        // 根据循环不变量，left 现在是最大的回答为「是」的数
        return left;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
//        int index = hIndex.hIndex(new int[]{0, 1, 3, 5, 6});
        int index1 = hIndex.hIndex1(new int[]{1});
//        System.out.println(index);
        System.out.println(index1);
    }


}
