package com.gmy.leetcode.doublepoint;

import java.util.Arrays;

/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，
 * 在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/volume-of-histogram-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trap {

    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        while (left < height.length) {
            if (height[left] == 0) {
                left++;
            } else {
                break;
            }
        }
        int right = left + 1, postMaxIndex = right, subCount = 0;
        while (left < height.length - 1) {
            // 后面没有比自己更大的
            if (right == height.length) {
                int currentCount = (postMaxIndex - left - 1) * height[postMaxIndex];
                subCount = Arrays.stream(height, left + 1, postMaxIndex).sum();
                result += currentCount - subCount;
                left = postMaxIndex;
                right = left + 1;
                postMaxIndex = right;
                subCount = 0;
            } else if (height[left] < height[right]) {// 右边有比自己大的
                int currentCount = (right - left - 1) * height[left];
                result += currentCount - subCount;
                left = right;
                right = left + 1;
                postMaxIndex = right;
                subCount = 0;
            } else {
                // 0,1,0,2,1,0,1,3,2,1,2,1
                subCount += height[right];
                if (height[right] > height[postMaxIndex]) {
                    postMaxIndex = right;
                }
                right++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int result = trap.trap(new int[]{1,2,3,4,5});
        System.out.println(result);
    }

}
