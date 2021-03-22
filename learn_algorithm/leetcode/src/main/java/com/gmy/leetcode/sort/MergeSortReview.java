package com.gmy.leetcode.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSortReview {

    public void sort(int[] arr) {
        int[] tmp = new int[arr.length];
        sort(arr, tmp, 0, arr.length - 1);
    }

    public void sort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, temp, left, mid);
            sort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    public void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= mid) {
            temp[k++] = arr[j++];
        }
        k = 0;
        while (left <= right) {
            arr[left++] = temp[k++];
        }
    }

    public static void main(String []args){
        MergeSortReview mergeSortReview = new MergeSortReview();
        int[] arr = {9,8,7,6,5,4,3,2,1};
        mergeSortReview.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
