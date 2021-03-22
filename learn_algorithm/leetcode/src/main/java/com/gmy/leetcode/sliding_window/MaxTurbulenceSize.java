package com.gmy.leetcode.sliding_window;

/**
 * 给定一个整数数组 arr，返回 arr的最大湍流子数组的长度。
 * 如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * 更正式地来说，当 arr的子数组A[i], A[i+1], ..., A[j]满足仅满足下列条件时，我们称其为湍流子数组：
 *
 * 若i <= k < j：
 * 当 k为奇数时，A[k] > A[k+1]，且
 * 当 k 为偶数时，A[k] < A[k+1]；
 * 或 若i <= k < j：
 * 当 k 为偶数时，A[k] > A[k+1]，且
 * 当 k为奇数时，A[k] < A[k+1]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1：
 * 输入：arr = [9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
 *
 * 示例 2：
 * 输入：arr = [4,8,12,16]
 * 输出：2
 *
 * 示例 3：
 * 输入：arr = [100]
 * 输出：1
 */
public class MaxTurbulenceSize {

    /**
     * 自己解法
     * @param arr
     * @return
     */
    public int maxTurbulenceSize(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // compare == 1 right - 1 > right == 2 right - 1 < right
        int left = 0, right = 1, compare = 0;
        int max = 1;
        while (right < arr.length) {
            if (arr[right] == arr[right - 1]) {
                max = Math.max(max, right - left);
                left = right;
            }
            if ((compare == 1 && arr[right - 1] < arr[right])
                    || (compare == 2 && arr[right - 1] > arr[right])) {
                max = Math.max(max, right - left);
                left = right - 1;
            }
            compare = arr[right - 1] > arr[right] ? 2 : 1;
            right++;
        }
        max = Math.max(max, right - left);
        return max;
    }

    /**
     * 官方解
     * @param arr
     * @return
     */
    public int maxTurbulenceSize1(int[] arr) {
        int n = arr.length;
        int ret = 1;
        int left = 0, right = 0;

        while (right < n - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        MaxTurbulenceSize maxTurbulenceSize = new MaxTurbulenceSize();
        int[] ints = new int[] {4,8,12,16};
        int result = maxTurbulenceSize.maxTurbulenceSize(ints);
        System.out.println(result);
    }

}
