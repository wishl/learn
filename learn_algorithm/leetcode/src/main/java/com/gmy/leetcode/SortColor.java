package com.gmy.leetcode;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColor {

    /**
     * 两次循环的计数排序
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int rCount = 0;
        int wCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                rCount++;
            } else if (nums[i] == 1) {
                wCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < rCount) {
                nums[i] = 0;
            } else if (i < rCount + wCount) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    /**
     * 0 放在最前面，2放在最后面
     * @param nums
     */
    public static void sortColors1(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }


    public static void main(String[] args) {
        int[] is = {1, 0, 2};
        sortColors1(is);
        System.out.println(Arrays.toString(is));
    }

}
