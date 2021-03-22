package com.gmy.leetcode.week.contest.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 你需要在一个集合里动态记录 ID 的出现频率。给你两个长度都为 n 的整数数组 nums 和 freq ，
 * nums 中每一个元素表示一个 ID ，对应的 freq 中的元素表示这个 ID 在集合中此次操作后需要增加或者减少的数目。
 * 增加 ID 的数目：如果 freq[i] 是正数，那么 freq[i] 个 ID 为 nums[i] 的元素在第 i 步操作后会添加到集合中。
 * 减少 ID 的数目：如果 freq[i] 是负数，那么 -freq[i] 个 ID 为 nums[i] 的元素在第 i 步操作后会从集合中删除。
 * 请你返回一个长度为 n 的数组 ans ，其中 ans[i] 表示第 i 步操作后出现频率最高的 ID 数目 ，
 * 如果在某次操作后集合为空，那么 ans[i] 为 0 。
 *
 * https://leetcode.cn/problems/most-frequent-ids/description/
 */
public class MostFrequentIDs {

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
//        int n = nums.length;
//        long[] ans = new long[n];
//        Map<Integer, Long> cnt = new HashMap<>();
//        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> Long.compare(b.getKey(), a.getKey()));
//        for (int i = 0; i < n; i++) {
//            int x = nums[i];
//            long c = cnt.merge(x, (long) freq[i], Long::sum);
//            pq.add(new Pair<>(c, x));
//            while (!pq.peek().getKey().equals(cnt.get(pq.peek().getValue()))) { // 堆顶保存的数据已经发生变化
//                pq.poll(); // 删除
//            }
//            ans[i] = pq.peek().getKey();
//        }
//        return ans;
        return null;
    }

    public static void main(String[] args) {
        MostFrequentIDs mostFrequentIDs = new MostFrequentIDs();
        int[] nums = new int[] {2,3,2,1};
        int[] freq = new int[] {3,2,-3,1};
        long[] result = mostFrequentIDs.mostFrequentIDs(nums, freq);
        System.out.println(Arrays.toString(result));
    }
}
