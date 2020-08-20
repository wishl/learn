package com.gmy.leetcode;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int duplicates = 0;
        Integer num;
        for (int i = 0; i + duplicates < nums.length - 1; i++) {
            num = nums[i + duplicates];
            int j = i + duplicates + 1;
            for (; j < nums.length; j++) {
                if (nums[j] != num) {
                    break;
                }
                duplicates++;
            }
            if (j < nums.length) {
                nums[j - duplicates] = nums[j];
            }
        }
        return nums.length - duplicates;
    }

    // 双指针解法
    public static int removeDuplicatesDoublePoint(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p++] = nums[q];
            }
            q++;
        }
        // p为新数组最后的index，所以长度要加1
        return p + 1;
    }


    public static void main(String[] args) {
        int[] i = new int[] {1, 1, 2, 3, 4, 4};
        int result = removeDuplicates(i);
        System.out.println(result);
        System.out.println(Arrays.toString(i));
    }

}
