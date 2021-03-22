package com.gmy.leetcode.point;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxArea {

    /**
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        Integer leftMoreIndex = -1;
        Integer rightMoreIndex = -1;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            max = Math.max(max, (min * (right - left)));
            if (min == height[left]) {
                // 如果当前最小的height再左边 则向右寻找更大的
                leftMoreIndex = findLeftMoreIndex(left, right, height);
                if (leftMoreIndex != -1) {
                    left = leftMoreIndex;
                    continue;
                }
            }
            // 有可能两边一样大 此时不能有else
            if (min == height[right]) {
                // 如果当前最小的height在右边 则向左寻找更大的
                rightMoreIndex = findRightMoreIndex(left, right, height);
                if (rightMoreIndex != -1) {
                    right = rightMoreIndex;
                    continue;
                }
            }
            // 走到这里说明已经筛选完毕了 直接break
            break;
        }
        return max;
    }

    private Integer findLeftMoreIndex(int left, int right, int[] height) {
        int min = height[left];
        for (int i = left + 1; i < right; i++) {
            if (height[i] > min) {
                return i;
            }
        }
        return -1;
    }

    private Integer findRightMoreIndex(int left, int right, int[] height) {
        int min = height[right];
        for (int i = right - 1; i > left; i--) {
            if (height[i] > min) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int sum = maxArea.maxArea(new int[]{1, 8, 6, 2, 10000, 10000, 8, 3, 7});
        System.out.println(sum);
    }

}
