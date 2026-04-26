package com.gmy.leetcode.hot100.array;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class Merge {

    /**
     * 解法1 开一个临时数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = 0, n2 = 0, index = 0;
        int[] num1Copy = new int[m];
        System.arraycopy(nums1, 0, num1Copy, 0, m);
        while (n1 < m && n2 < n) {
            // 不变
            if (num1Copy[n1] < nums2[n2]) {
                nums1[index++] = num1Copy[n1++];
            } else {
                // nums2 赋值给 nums1
                nums1[index++] = nums2[n2++];
            }
        }
        while (n1 < m) {
            nums1[index++] = num1Copy[n1++];
        }
        while (n2 < n) {
            nums1[index++] = nums2[n2++];
        }
    }

    /**
     * 解法2： 从后往前赋值
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1, n2 = n - 1, index = m + n - 1;
        while (n1 >= 0 && n2 >= 0) {
            if (nums1[n1] > nums2[n2]) {
                nums1[index--] = nums1[n1--];
            } else {
                nums1[index--] = nums2[n2--];
            }
        }
        while (n2 >= 0) {
            nums1[index--] = nums2[n2--];
        }
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge.merge1(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

}
