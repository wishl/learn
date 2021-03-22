package com.gmy.leetcode.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSortReview {

    public void sort(int[] arr) {
        int length = arr.length;
        for (int i = (length / 2) - 1; i >= 0; i--) {
            adjust(arr, i, length);
        }
        for (int i = length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjust(arr, 0, i);
        }
    }

    private void adjust(int[] arr, int i, int length) {
       int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j += 2 * i + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            }
        }
        arr[i] = temp;
    }

    private void adjustHeap1(int[] nums, int index, int length) {
        int tmp = nums[index];
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            if (i + 1 < length && nums[i] < nums[i + 1]) {
                i++;
            }
            if (tmp < nums[i]) {
                nums[index] = nums[i];
                index = i;
            } else {
                break;
            }
        }
        nums[index] = tmp;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }


    public static void main(String[] args) {
        int[] is = new int[] {6, 7, 2, 3, 1, 0, 4, 9, 5, 8};
        int[] is1 = {3,2,3,1,2,4,5,5,6};
        HeapSortReview heapSort = new HeapSortReview();
        heapSort.sort(is1);
        System.out.println(Arrays.toString(is1));
    }

}
