package com.gmy.leetcode.prefix;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * https://leetcode.cn/problems/trapping-rain-water/description/
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class Trap {

    /**
     * 把每个index当做一个桶，左边高度为前缀的最大值 右边高度为后缀的最大值，计算高度 = min(前缀, 后缀) - 当前高度
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        int[] pre = new int[n], suf = new int[n];
        pre[0] = height[0];
        suf[n - 1] = height[n - 1];
        for (int i = 1; i < height.length; i++) {
            // 当前前缀有多少高度
            pre[i] = Math.max(pre[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.max(suf[i + 1], height[i]);
        }
        int result = 0;
        // 计算结论
        for (int i = 0; i < height.length; i++) {
            result += Math.min(suf[i], pre[i]) - height[i];
        }
        return result;
    }

    /**
     * 动态计算最大值:
     * 因为最大值不会减小，所以可以通过动态计算的方法减少时间复杂度
     * 如果left <= right  直接计算后left右移
     * 否则 right左移
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int preMax = height[0], sufMax = height[n - 1];
        int ans = 0;
        while (left <= right) {
            if (preMax <= sufMax) {
                preMax = Math.max(preMax, height[left]);
                ans += preMax - height[left];
                left++;
            } else {
                sufMax = Math.max(sufMax, height[right]);
                ans += sufMax - height[right];
                right--;
            }
        }
        return ans;
    }

}
