package com.gmy.leetcode.divide;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int targetIndex = length / 2;
        if (length % 2 != 0) {
            return find(nums1, nums2, targetIndex);
        } else {
            int i = find(nums1, nums2, targetIndex);
            int j = find(nums1, nums2, targetIndex - 1);
            return (i + j) / 2.0;
        }
    }

    public int find(int[] nums1, int[] nums2, int targetIndex) {
        int tmp = 0, i1 = 0, i2 = 0;
        int result = 0;
        while (tmp <= targetIndex && nums1.length > i1 && nums2.length > i2) {
            if (nums1[i1] < nums2[i2]) {
                result = nums1[i1++];
            } else {
                result = nums2[i2++];
            }
            tmp++;
        }
        while (tmp <= targetIndex && nums1.length > i1) {
            result = nums1[i1++];
            tmp++;
        }
        while (tmp <= targetIndex && nums2.length > i2) {
            result = nums2[i2++];
            tmp++;
        }
        return result;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        double medianSortedArrays = findMedianSortedArrays.findMedianSortedArrays(new int[]{2}, new int[]{});
        System.out.println(medianSortedArrays);
    }



}
