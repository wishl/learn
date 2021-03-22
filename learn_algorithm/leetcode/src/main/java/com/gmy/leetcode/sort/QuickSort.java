package com.gmy.leetcode.sort;

import java.util.Arrays;

/**
 * 快排
 */
public class QuickSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            sort(arr, left, partition - 1);
            sort(arr, partition + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int prov = left, point = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < arr[prov]) {
                swap(arr, point++, i);
            }
        }
        swap(arr, prov, point - 1);
        return point - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] is = {6, 7, 2, 3, 1, 4, 9, 5, 8};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(is);
        System.out.println(Arrays.toString(is));
    }
}
