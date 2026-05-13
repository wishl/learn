package com.gmy.leetcode.test;

public class FindMax {

    /**
     * 数组先升后降（单峰），二分查找最大值及其连续重复个数。
     *
     * @param arr 先严格递增后严格递减的数组，相邻元素可能相等
     * @return [最大值, 最大值的连续出现次数]
     */
    public static int[] findMax(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 跳过左边连续重复值，找到第一个不同的值
            int left = mid - 1;
            while (left >= 0 && arr[left] == arr[mid]) left--;
            // 跳过右边连续重复值，找到第一个不同的值
            int right = mid + 1;
            while (right < n && arr[right] == arr[mid]) right++;
            // 计算如果一个数 大于左边的第一个不同 并且 小于右边第一个不同的 则说明这个数是最大的
            // 防止整个数组都是相同的数 需要判断边界，如果 left 或 right 越界 说明 整个数组都是一样的 直接返回即可
            if (left < 0 || arr[left] < arr[mid]) {
                if (right >= n || arr[right] < arr[mid]) {
                    l = mid;
                    break;
                } else { // 还在上升，去右边找
                    l = right;
                }
            } else { // 处于下降段，峰值在左边
                r = left;
            }
        }

        int resultIndex = l;
        int maxVal = arr[resultIndex];

        // 向两边扩散，统计最大值的连续出现次数
        int count = 1;
        int i = resultIndex - 1;
        while (i >= 0 && arr[i] == maxVal) { count++; i--; }
        i = resultIndex + 1;
        while (i < n && arr[i] == maxVal) { count++; i++; }

        return new int[]{maxVal, count};
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 3, 4, 5, 6, 7, 8, 8, 8, 8, 9, 10, 10, 11, 11,
                     12, 23, 33, 33, 10, 2, 2, 2, 2, 2, 2, 1, 1, 1};
        int[] res = findMax(arr);
        System.out.println("最大值: " + res[0] + ", 个数: " + res[1]);
    }
}
