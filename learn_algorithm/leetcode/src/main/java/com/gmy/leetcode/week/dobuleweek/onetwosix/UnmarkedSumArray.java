package com.gmy.leetcode.week.dobuleweek.onetwosix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个长度为 n 下标从 0 开始的正整数数组 nums 。
 * 同时给你一个长度为 m 的二维操作数组 queries ，其中 queries[i] = [indexi, ki] 。
 * 一开始，数组中的所有元素都 未标记 。
 * 你需要依次对数组执行 m 次操作，第 i 次操作中，你需要执行：
 * 如果下标 indexi 对应的元素还没标记，那么标记这个元素。
 * 然后标记 ki 个数组中还没有标记的 最小 元素。如果有元素的值相等，那么优先标记它们中下标较小的。
 * 如果少于 ki 个未标记元素存在，那么将它们全部标记。
 * 请你返回一个长度为 m 的数组 answer ，其中 answer[i]是第 i 次操作后数组中还没标记元素的 和 。
 *
 * https://leetcode.cn/problems/mark-elements-on-array-by-performing-queries/description/
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,1,2,3,1], queries = [[1,2],[3,3],[4,2]]
 * 输出：[8,3,0]
 * 解释：
 * 我们依次对数组做以下操作：
 * 标记下标为 1 的元素，同时标记 2 个未标记的最小元素。标记完后数组为 nums = [1,2,2,1,2,3,1] 。未标记元素的和为 2 + 2 + 3 + 1 = 8 。
 * 标记下标为 3 的元素，由于它已经被标记过了，所以我们忽略这次标记，同时标记最靠前的 3 个未标记的最小元素。标记完后数组为 nums = [1,2,2,1,2,3,1] 。未标记元素的和为 3 。
 * 标记下标为 4 的元素，由于它已经被标记过了，所以我们忽略这次标记，同时标记最靠前的 2 个未标记的最小元素。标记完后数组为 nums = [1,2,2,1,2,3,1] 。未标记元素的和为 0
 */
public class UnmarkedSumArray {


    /**
     * todo 看解题
     * @param nums
     * @param queries
     * @return
     */
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int[] cache = new int[nums.length];
        long[] result = new long[queries.length];
        long sum = 0;
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1] != 0 ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new int[] {i, nums[i]});
            sum += nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int indexi = queries[i][0];
            int ki = queries[i][1];
            // 标记 indexi
            if (cache[indexi] == 0) {
                cache[indexi] = 1;
                sum -= nums[indexi];
            }
            // 标记ki
            while (ki > 0 && !queue.isEmpty()) {
                int[] poll = queue.poll();
                // 没标记才ki-- 否则说明被 indexi标记过 直接删除再找下一个
                if (cache[poll[0]] == 0) {
                    ki--;
                    sum -= poll[1];
                    cache[poll[0]] = 1;
                }
            }
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        UnmarkedSumArray unmarkedSumArray = new UnmarkedSumArray();
        long[] result = unmarkedSumArray.unmarkedSumArray(new int[]{1,12,12,4,14,1,12,1}, new int[][]{{1,2},{5,4},{4,0},{0,1},{0,3}});
        System.out.println(Arrays.toString(result));
    }
}
