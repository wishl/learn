package com.gmy.leetcode.sort;

/**
 * 根据归并排序的原理 获取两个升序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
 */
public class MidNumber {

    /**
     * 方法一：合并两个有序数组，并找出中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n == 0) {
            // 偶数
            return find(nums2);
        }
        if (m == 0) {
            return find(nums1);
        }
        int[] merge = merge(nums1, nums2);
        return find(merge);
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] tmp = new int[n + m];
        int i = 0, j = 0, t = 0;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                tmp[t++] = nums1[i++];
            } else if (nums1[i] >= nums2[j]) {
                tmp[t++] = nums2[j++];
            }
        }
        while (i < n) {
            tmp[t++] = nums1[i++];
        }
        while (j < m) {
            tmp[t++] = nums2[j++];
        }
        return tmp;
    }

    private double find(int[] num) {
        int length = num.length;
        if (length % 2 == 0) {
            return (num[length / 2 - 1] + num[length / 2]) / 2.0;
        } else {
            return num[length / 2];
        }
    }

    public static void main(String[] args) {
        MidNumber midNumber = new MidNumber();
        int[] nums1 = new int[] {1, 2, 3, 4};
        int[] nums2 = new int[] {5, 6, 7, 8};
        double result = midNumber.findMedianSortedArrays1(nums1, nums2);
        System.out.println(result);
    }

    /**
     * 方法二 不用合并查找中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if ((n + m) % 2 == 0) {
            int index1 = (n + m) / 2;
            int index2 = (n + m) / 2 - 1;
            int i = find(nums1, nums2, index1);
            int j = find(nums1, nums2, index2);
            return (i + j) / 2.0;
        } else {
            int i = (n + m) / 2;
            return i;
        }
    }

    private int find(int[] nums1, int[] nums2, int index) {
        int tmp = 0, i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;
        while (i < n && j < m) {
            int num1 = nums1[i];
            int num2 = nums2[j];
            if (tmp == index) {
                return Math.min(num1, num2);
            }
            if (num1 < num2) {
                i++;
            } else {
                j++;
            }
            tmp++;
        }
        while (i < n) {
            if (tmp == index) {
                return nums1[i];
            }
            tmp++;
            i++;
        }
        while (j < n) {
            if (tmp == index) {
                return nums2[j];
            }
            tmp++;
            j++;
        }
        throw new RuntimeException("cannot find index:{}" + index);
    }

    /**
     * 方法三优化方法二为二分查找
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;
        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }


}
