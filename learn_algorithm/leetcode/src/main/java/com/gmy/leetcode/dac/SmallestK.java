package com.gmy.leetcode.dac;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.Arrays;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class SmallestK {

    /**
     * 堆排序思维
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        int[] result = new int[k];
        int N = arr.length;
        for (int i = N / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, N);
        }
        for (int i = N - 1, j = 0; i >= 0 && j < k; i--, j++) {
            swap(arr, 0, i);
            result[j] = arr[i];
            adjustHeap(arr, 0, i - 1);
        }
        return result;
    }

    /**
     * 维护一个小顶堆
     * @param arr
     * @param topIndex
     * @param length
     */
    private void adjustHeap(int[] arr, int topIndex, int length) {
        int tmp = arr[topIndex];
        for (int i = 2 * topIndex + 1; i < length; i = 2 * topIndex + 1) {
            if (i + 1 < length && arr[i] > arr[i + 1]) {
                i++;
            }
            if (tmp > arr[i]) {
                arr[topIndex] = arr[i];
                topIndex = i;
            } else {
                break;
            }
        }
        arr[topIndex] = tmp;
    }

    /**
     * 快排思维
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK1(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        find(arr, k - 1, 0, arr.length - 1);
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private void find(int[] arr, int k, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            if (partition > k) {
                find(arr, k, left, partition - 1);
            } else if (partition < k) {
                find(arr, k, partition + 1, right);
            } else {
                return;
            }
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left, index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index++);
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] is = new int[] {1,3,5,7,2,4,6,8};
        SmallestK smallestK = new SmallestK();
        int[] ints = smallestK.smallestK(is, 4);
        System.out.println(Arrays.toString(is));
        System.out.println(Arrays.toString(ints));
    }

}
