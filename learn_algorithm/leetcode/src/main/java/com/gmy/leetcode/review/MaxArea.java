package com.gmy.leetcode.review;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class MaxArea {

    /**
     * 双指针解法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, area = 0;
        while (left < right) {
            int hl = height[left];
            int hr = height[right];
            area = Math.max(area, (right - left) * Math.min(hl, hr));
            if (hl > hr) {
                right--;
            } else {
                left++;
            }
        }
        return area;
    }

    public int maxArea1(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            int hl = height[left];
            int hr = height[right];
            // 寻找下一个height 大于 当前的 left 和 right
            while (left < right && hl >= height[left]) {
                left++;
                max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            }
            while (left < right && hr >= height[right]) {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int result = maxArea.maxArea(new int[]{1,5,4,1});
        System.out.println(result);
    }

}
