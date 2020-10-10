package com.gmy.leetcode.doublepoint;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {

    // 多算了很多次，可以优化成一次循环
    public static int maxArea(int[] height) {
        int n = height.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int end = i + 1;
            while (end < height.length) {
                int wight = Math.min(height[i], height[end]);
                result = Math.max((end - i) * wight, result);
                end++;
            }
        }
        return result;
    }

    // 一次循环搞定
    public static int maxArea1(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int result = 0;
        while (end > start) {
            int area = Math.min(height[start], height[end]) * (end - start);
            result = Math.max(area, result);
            // 左边小则寻找其他的
            if (height[start] <= height[end]) {
                start ++;
            } else {
                end --;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] is = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(is);
        System.out.println(result);
    }

}
