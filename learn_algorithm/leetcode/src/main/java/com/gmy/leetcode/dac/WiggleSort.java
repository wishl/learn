package com.gmy.leetcode.dac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 */
public class WiggleSort {

    public  void wiggleSort(int[] nums) {
        int[]bucket=new int[5001];
        for(int num:nums)bucket[num]++;
        int len=nums.length;
        int small,big;//穿插数字时的上界
        //总长度为奇数时，“小 大 小 大 小”边界左右都为较小的数；
        //总长度为偶数时，“小 大 小 大”边界左为较小的数，边界右为较大的数
        if((len&1)==1){
            small=len-1;
            big=len-2;
        }else{
            small=len-2;
            big=len-1;
        }
        int j=5000; //从后往前，将桶中数字穿插到数组中，后界为j
        //桶中大的数字在后面，小的数字在前面，所以先取出较大的数字，再取出较小的数字
        //先将桶中的较大的数字穿插放在nums中
        for(int i=1;i<=big;i+=2){
            while (bucket[j]==0)j--;//找到不为0的桶
            nums[i]=j;
            bucket[j]--;
        }
        //再将桶中的较小的数字穿插放在nums中
        for(int i=0;i<=small;i+=2){
            while (bucket[j]==0)j--;//找到不为0的桶
            nums[i]=j;
            bucket[j]--;
        }
    }

    /**
     * 类似于快排 + 归并的方式, 这种方式可能存在
     * 1 < 2 == 2 的情况，所以要先排序，然后前面升序 后面降序的merge
     * 先把对应数组分块 再合并
     * @param nums
     */
    public void wiggleSort1(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int mid = length / 2;
        int[] tmp = new int[nums.length];
        merge1(nums, 0, length - 1, mid, tmp);
    }

    private void split(int[] nums, int mid, int left, int right) {
        if (left > right) {
            return;
        }
        int partition = partition(nums, left, right);
        if (partition == mid) {
            return;
        } else if (partition > mid) {
            split(nums, mid, left, partition - 1);
        } else {
            split(nums, mid, partition + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int prov = left, index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[prov] > nums[i]) {
                swap(nums, i, index++);
            }
        }
        swap(nums, left, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private void merge(int[] nums, int left, int right, int mid, int[] tmp, int length) {

        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            tmp[t++] = nums[i++];
            tmp[t++] = nums[j++];
        }
        while (i <= mid) {
            tmp[t++] = nums[i++];
        }
        while (j <= mid) {
            tmp[t++] = nums[j++];
        }
        t = 0;
        while (left <= right) {
            nums[left++] = tmp[t++];
        }
    }

    private void merge1(int[] nums, int left, int right, int mid, int[] tmp) {
        int i = 0, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            tmp[t++] = nums[i++];
            tmp[t++] = nums[j++];
        }
        while (i <= mid) {
            tmp[t++] = nums[i++];
        }
        while (j <= right) {
            tmp[t++] = nums[j++];
        }
        t = 0;
        while (left <= right) {
            nums[left++] = tmp[t++];
        }
    }

    public static void main(String[] args) {
        int[] ints = {1,3,2,2,3,1};
        WiggleSort wiggleSort = new WiggleSort();
        wiggleSort.wiggleSort1(ints);
        System.out.println(Arrays.toString(ints));
    }
}
