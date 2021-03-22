package com.gmy.leetcode.sort;

/**
 * 寻找乱序数组的中位数
 */
public class QuickSortMidReview {

    public double findMid(int[] arr) {
        int length = arr.length;
        if (length % 2 != 0) {
            return find(arr, 0, length - 1, length / 2);
        } else {
            int result = find(arr, 0, length - 1, length / 2);
            result += find(arr, 0, length - 1, (length / 2) - 1);
            return result / 2D;
        }
    }

    private int find(int[] arr, int left, int right, int index) {
        int partition = partition(arr, left, right);
        if (partition == index) {
            return arr[partition];
        } else if (partition > index) {
            return find(arr, left, partition - 1, index);
        } else {
            return find(arr, partition + 1, right, index);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int prov = left + 1, point = prov;
        for (int i = point; i <= right; i++) {
            if (arr[left] > arr[i]) {
                swap(arr, prov++, i);
            }
        }
        swap(arr, prov - 1, left);
        return prov - 1;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] is = {1, 2, 3};
        QuickSortMidReview quickSort = new QuickSortMidReview();
        double mid = quickSort.findMid(is);
        System.out.println(mid);
    }

}
