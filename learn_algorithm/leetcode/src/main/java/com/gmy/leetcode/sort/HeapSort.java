package com.gmy.leetcode.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    /**
     * 首先找出大顶堆，然后跟数组末尾交换，之后再整理
     */
    public void sort(int[] arr) {
        int N = arr.length;
        for (int i = (N / 2) - 1; i >= 0; i--) {
            adjustHeap1(arr, i, N);
        }
        for (int i = N - 1; i > 0 ; i--) {
            swap(arr, 0, i);
            adjustHeap1(arr, 0, i);
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public void adjustHeap(int[] arr,int i,int length) {
        int temp = arr[i];//先取出当前元素i
        for(int k= i * 2 + 1; k<length; k=k*2+1) {//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
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
        int[] is = new int[] {1,3,5,7,2,4,6,8};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(is);
        System.out.println(Arrays.toString(is));
    }
}
