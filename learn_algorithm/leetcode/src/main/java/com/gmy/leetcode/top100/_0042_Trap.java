package com.gmy.leetcode.top100;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class _0042_Trap {

    public int trap(int[] height) {
        int left = 0, length = height.length, right = height.length - 1, result = 0;
        int[] prefix = new int[height.length + 1];
        int[] suffix = new int[height.length + 1];
        for (int i = 1; i < height.length; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i - 1]);
            suffix[length - i] = Math.max(suffix[length - i + 1], height[length - i]);
        }
        while (left <= right) {
            if (prefix[left] < suffix[right]) {
                result += Math.max(prefix[left] - height[left], 0);
                left++;
            } else {
                result += Math.max(suffix[right] - height[right], 0);
                right--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        _0042_Trap trap = new _0042_Trap();
        int result = trap.trap(new int[]{4,2,0,3,2,5});
        System.out.println(result);
    }
}
