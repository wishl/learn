package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * 1 2 3
 * 0 1 2
 *
 */
public class _0373_KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>(k); // 预分配空间
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < Math.min(nums1.length, k); i++) { // 至多 k 个
            pq.add(new int[]{nums1[i] + nums2[0], i, 0});
        }
        while (ans.size() < k) {
            int[] p = pq.poll();
            int i = p[1];
            int j = p[2];
//            ans.add(List.of(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return ans;
    }

    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>(k); // 预分配空间
        int left = 0, right = 0;
        while (ans.size() <= k) {
            List<Integer> list = new ArrayList<>();
            list.add(nums1[left]);
            list.add(nums2[right]);
            ans.add(list);
            if (left < nums1.length - 1 && right < nums2.length - 1
                && nums1[left] + nums2[right + 1] < nums1[left + 1] + nums2[right + 1]) {
                right++;
            } else if (left < nums1.length - 1 && right < nums2.length - 1
                && nums1[left] + nums2[right + 1] >= nums1[left + 1] + nums2[right + 1]) {
                left++;
            } else if (left < nums1.length - 1) {
                right++;
                left = 0;
            }
        }
        return null;
    }

        public static void main(String[] args) {
        _0373_KSmallestPairs kSmallestPairs = new _0373_KSmallestPairs();
        List<List<Integer>> result = kSmallestPairs.kSmallestPairs(new int[]{1, 7, 20}, new int[]{2, 8, 100}, 9);
        System.out.println(result);
    }

}
