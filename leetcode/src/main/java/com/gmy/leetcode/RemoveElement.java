package com.gmy.leetcode;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveElement {

    // 双指针方法，找到最小的不等于val的位置然后跟当前位置交换(傻逼一样)
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 0;
        while (q < nums.length) {
            if (nums[p] == val) {
                q = notValIndex(q, nums, val);
                if (q == nums.length) {
                    return p;
                }
                nums[p] = nums[q];
                nums[q] = val;
                p++;
                q = p;
            } else {
                p++;
                q++;
            }
        }
        return p;
    }

    private static int notValIndex(int q, int[] nums, int val) {
        while (q < nums.length) {
            if (nums[q] != val) {
                break;
            }
            q++;
        }
        return q;
    }


    public static int removeElementReal(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        for (int q = 0; q < nums.length; q++) {
            if (nums[q] != val) {
                nums[p++] = nums[q];
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[] ints = {0,1,2,2,3,0,4,2};
        int result = removeElementReal(ints, 2);
        System.out.println(result);
        System.out.println(Arrays.toString(ints));
    }

}
