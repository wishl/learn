package com.gmy.leetcode.sort;

/**
 * 给一个无序数组，找到中位数
 */
public class QuickSortMid {

    public double getMid(int[] arr) {
        int length = arr.length;
        if (length % 2 == 0) {
            int midIndex1 = length / 2;
            int midIndex2 = (length / 2) - 1;
            int num1 = getNum(arr, midIndex1);
            int num2 = getNum(arr, midIndex2);
            return (num1 + num2) / 2.0;
        } else {
            int midIndex = length / 2;
            int num = getNum(arr, midIndex);
            return num;
        }
    }

    private int getNum(int[] arr, int index) {
        return getNum(arr, 0, arr.length - 1, index);
    }

    private int getNum(int[] arr, int left, int right, int index) {
        if (left < right) {
            int partition = partition(arr, left, right);
            if (partition > index) {
                return getNum(arr, left, partition, index);
            } else if (partition < index) {
                return getNum(arr, partition + 1, right, index);
            } else {
                return arr[index];
            }
        }
        throw new RuntimeException();
    }

    private int partition(int[] arr, int left, int right) {
        int standard = left, index = standard + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[standard]) {
                swap(i, index++, arr);
            }
        }
        swap(standard, index - 1, arr);
        return index - 1;
    }

    private void swap(int left, int right, int[] arr) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] is = {6, 7, 2, 3, 1, 0, 4, 9, 5, 8};
        QuickSortMid quick = new QuickSortMid();
        System.out.println(quick.getMid(is));
    }

}
