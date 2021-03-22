package com.gmy.leetcode.numtree;

import java.util.Arrays;

/**
 * 给你一个数组 nums ，请你完成两类查询。
 *
 * 其中一类查询要求 更新 数组 nums 下标对应的值
 * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/range-sum-query-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumArray {

    private ArrayBit arrayBit;
    private int[] nums;

    class ArrayBit {

        private int[] nums;

        public void add(int index, int num) {
            for (int i = index; i < nums.length; i += lowBit(i)) {
                nums[i] += num;
            }
        }

        public int sum(int start, int end) {
            int result = 0;
            for (int i = end; i > 0; i -= lowBit(i)) {
                result += nums[i];
            }
            for (int i = start - 1; i > 0; i -= lowBit(i)) {
                result -= nums[i];
            }
            return result;
        }

        private int lowBit(int x) {
            return x & -x;
        }

        public ArrayBit(int[] nums) {
            this.nums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }
    }

    public NumArray(int[] nums) {
        this.arrayBit = new ArrayBit(nums);
        this.nums = nums;
    }

    public void update(int index, int val) {
        int add = val - nums[index];
        this.nums[index] = val;
        this.arrayBit.add(index + 1, add);
    }

    public int sumRange(int left, int right) {
        return this.arrayBit.sum(left + 1, right + 1);
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {7,2,7,2,0});
        System.out.println(numArray.sumRange(0, 4));
        numArray.update(4, 6);// 7,2,7,2,6
        numArray.update(0, 2);// 0,2,7,2,6
        numArray.update(0, 9);// 9,2,7,2,6
        numArray.update(3, 8);// 9,2,7,8,6
        System.out.println(numArray.sumRange(0, 4));
    }

}
