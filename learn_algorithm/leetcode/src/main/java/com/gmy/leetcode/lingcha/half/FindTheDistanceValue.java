package com.gmy.leetcode.lingcha.half;

import java.util.Arrays;

/**
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 * https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/description/
 */
public class FindTheDistanceValue {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int i : arr1) {
            int index = find(arr2, i);
            // index == 0 说明没有比 num 小的
            if (index == 0 && Math.abs(arr2[index] - i) > d) {
                count++;
            } else if (index == arr2.length && Math.abs(arr2[index - 1] - i) > d) {
                count++;
            } else if (index != 0 && index != arr2.length && Math.abs(arr2[index - 1] - i) > d && Math.abs(arr2[index] - i) > d) {
                count++;
            }
        }
        return count;
    }

    /**
     * 闭区间计算大于等于num的最小值
     * @return
     */
    private int find(int[] arr2, int num) {
        int left = 0, right = arr2.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr2[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindTheDistanceValue findTheDistanceValue = new FindTheDistanceValue();
        int result = findTheDistanceValue.findTheDistanceValue(new int[]{-8, -7}, new int[]{4, 10, -4, 5, 2}, 55);
        System.out.println(result);
    }

}
