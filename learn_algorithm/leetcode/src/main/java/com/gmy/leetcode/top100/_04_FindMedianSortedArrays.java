package com.gmy.leetcode.top100;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 */
public class _04_FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalCount = nums1.length + nums2.length;
        int mid = totalCount / 2;
        int[] copy = new int[mid + 1];
        merge(nums1, nums2, copy, mid);
        if (totalCount % 2 == 0) {
            return (copy[mid] + copy[mid - 1]) / 2.0;
        } else {
            return copy[mid];
        }
    }

    private void merge(int[] nums1, int[] nums2, int[] copy, int index) {
        int i = 0, j = 0, tmp = 0;
        while (index >= 0 && j < nums2.length && i < nums1.length) {
            if (nums1[i] < nums2[j]) {
                copy[tmp++] = nums1[i++];
            } else {
                copy[tmp++] = nums2[j++];
            }
            index--;
        }
        while (index >= 0 && i < nums1.length) {
            copy[tmp++] = nums1[i++];
            index--;
        }
        while (index >= 0 && j < nums2.length) {
            copy[tmp++] = nums2[j++];
            index--;
        }
    }

    public static void main(String[] args) {
        _04_FindMedianSortedArrays findMedianSortedArrays = new _04_FindMedianSortedArrays();
        double result = findMedianSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(result);
    }

}
