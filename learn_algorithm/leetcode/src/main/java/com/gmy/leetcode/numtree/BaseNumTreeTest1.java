package com.gmy.leetcode.numtree;

import java.util.Arrays;

/**
 * 差分数组 + 树状数组
 * https://www.luogu.com.cn/problem/P3368
 */
public class BaseNumTreeTest1 {

    /**
     * 差分数组：
     * 对于数组nums来说 使差分数组 nums1 = (nums[1] = nums[0] - nums[1]... nums1[length - 1] = nums[length - 2] - nums[length - 1])
     * nums1[0] = 0
     * 通过差分可知:如果对nums 的某段区间[x, y]变化则 （+i）,只需要对差分数组中 nums1[x] +i nums1[y + 1] - i 即可
     * 获取对应结论num[i] 只需 sum(nums[0]...nums[i])即可
     * 对于相加可以优化为树状数组
     */
    private int nums[];

    public void add(int start, int end, int num) {
        add(start, num);
        if (end + 1 < nums.length) {
            add(end + 1, -num);
        }
    }

    private void add(int index, int num) {
        for (int i = index; i < nums.length; i += lowBit(i)) {
            nums[i] += num;
        }
    }

    public int search(int index) {
        int result = 0;
        for (int i = index; i > 0; i -= lowBit(i)) {
            result += nums[i];
        }
        return result;
    }

    private int lowBit(int x) {
        return x & -x;
    }

    private BaseNumTreeTest1(int[] array) {
        this.nums = new int[array.length + 1];
        int last = 0, current = 0;
        for (int i = 1; i <= array.length; i++) {
            current = array[i - 1];
            add(i, current - last);
            last = current;
        }
    }

    public static void main(String[] args) {
        BaseNumTreeTest1 baseNumTreeTest1 = new BaseNumTreeTest1(new int[] {1,2,3,4,5});
        baseNumTreeTest1.add(1, 4, 2);
        int search = baseNumTreeTest1.search(3);
        System.out.println(search);
    }

}
