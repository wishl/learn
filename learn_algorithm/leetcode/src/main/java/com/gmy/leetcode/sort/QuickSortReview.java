package com.gmy.leetcode.sort;

import java.util.Arrays;

/**
 * 快速排序review
 */
public class QuickSortReview {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    
    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            sort(arr, left, partition - 1);
            sort(arr, partition + 1, right);
        }
    }


    private int partition(int[] arr, int left, int right) {
        int prev = arr[left], j = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < prev) {
                swap(arr, i, j++);
            }
        }
        swap(arr, j - 1, left);
        return j - 1;
    }

    private void swap(int[] arr, int left, int right) {
        int tem = arr[left];
        arr[left] = arr[right];
        arr[right] = tem;
    }

    public static void main(String[] args) {
        int[] is = {6, 7, 2, 3, 1, 4, 9, 5, 8};
        QuickSortReview quickSort = new QuickSortReview();
        quickSort.sort(is);
        System.out.println(Arrays.toString(is));
    }
}
