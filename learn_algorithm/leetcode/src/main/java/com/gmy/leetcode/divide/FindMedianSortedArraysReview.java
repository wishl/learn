package com.gmy.leetcode.divide;

/**
 * 优化 FindMedianSortedArrays 解法
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 */
public class FindMedianSortedArraysReview {

    /**
     * 转化为查找第k大的元素
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 1) {
            // 奇数

        } else {

        }
        return -1;
    }

    public int findK(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = (end1 - start1 + 1);
        int len2 = (end2 - start2 + 1);
        if (len1 == 0) {
            return nums1[start1 + k - 1];
        }
        if (len2 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return nums1[start1 + 1] > nums2[start2 + 1] ? nums1[start1 + 1] : nums2[start2 + 1];
        }
        int i = start1 + Math.min(len1, k / 2);
        int j = start2 + Math.min(len2, k / 2);
        if (nums1[i] <= nums2[j]) {
            return findK(nums1, i, end1, nums2, start2, end2, k - (i - start1 + 1));
        } else {
            return findK(nums2, j, end1, nums2, start2, end2, k - (j - start2 + 1));
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArraysReview review = new FindMedianSortedArraysReview();
        double medianSortedArrays = review.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        System.out.println(medianSortedArrays);

    }

}
