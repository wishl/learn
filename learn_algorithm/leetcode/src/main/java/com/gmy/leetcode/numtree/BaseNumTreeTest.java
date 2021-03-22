package com.gmy.leetcode.numtree;

/**
 * 基础树状数组练习
 */
public class BaseNumTreeTest {

    private int[] nums;

    private int lowBit(int x) {
        int i = x & -x;
        return i;
    }

    /**
     * 单点添加
     */
    public void add(int index, int num) {
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i += lowBit(i)) {
            nums[i] += num;
        }
    }

    public int sum(int begin, int end) {
        int result = 0;
        for (int i = end; i > 0; i -= lowBit(i)) {
            result += nums[i];
        }
        for (int i = begin - 1; i > 0; i -= lowBit(i)) {
            result -= nums[i];
        }
        return result;
    }

    public BaseNumTreeTest(int[] array) {
        this.nums = new int[array.length + 1];
        for (int i = 1; i <= array.length; i++) {
            add(i, array[i - 1]);
        }
    }

    public static void main(String[] args) {
        BaseNumTreeTest baseNumTreeTest = new BaseNumTreeTest(new int[] {1, 3, 5});
        int sum = baseNumTreeTest.sum(1, 3);
        System.out.println(sum);
    }

}
