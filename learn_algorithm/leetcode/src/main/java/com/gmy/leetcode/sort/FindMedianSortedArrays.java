package com.gmy.leetcode.sort;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class FindMedianSortedArrays {

    /**
     * 先merge 再找
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
        return findMid(arr);
    }

    private double findMid(int[] arr) {
        int length = arr.length;
        int index = length / 2;
        if (length % 2 != 0) {
            return arr[find(arr, 0, arr.length - 1, index)];
        } else {
            int mid = find(arr, 0, arr.length - 1, index);
            int mid1 = find(arr, 0, arr.length - 1, index - 1);
            return (arr[mid] + arr[mid1]) / 2.0;
        }
    }

    private int find(int[] arr, int left, int right, int index) {
        int partition = partition(arr, left, right);
        if (partition == index) {
            return partition;
        } else if (partition > index) {
            return find(arr, left, partition - 1, index);
        } else {
            return find(arr, partition + 1, right, index);
        }
    }

    /**
     * 查询后面比自己小的值 并交换位置
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        int prov = left + 1;
        for (int i = prov; i <= right; i++) {
            if (arr[left] > arr[i]) {
                swap(arr, prov++, i);
            }
        }
        swap(arr, prov - 1, left);
        return prov - 1;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        double result = findMedianSortedArrays.findMedianSortedArrays(new int[]{1, 2, 3, 4, 5}, new int[]{6});
        System.out.println(result);
    }
}
