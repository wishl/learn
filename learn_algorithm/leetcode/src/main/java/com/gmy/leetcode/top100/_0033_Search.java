package com.gmy.leetcode.top100;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ...,
 * nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 */
public class _0033_Search {

    public int search(int[] nums, int target) {
        int minIndex = findMin(nums);
        if (nums[minIndex] == target) {
            return minIndex;
        }
        if (target > nums[nums.length - 1]) {
            return search(nums, target, 0, minIndex - 1);
        } else {
            return search(nums, target, minIndex, nums.length - 1);
        }
    }

    private int search(int[] nums, int target, int left, int right) {
        int r = right;
        // 左边严格等于 右边大于等于
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left < nums.length && nums[left] == target ? left : -1;
    }

    private int findMin(int[] nums) {
        int left = 0, right = nums.length - 2, num = nums[nums.length - 1];
        // [left, right]
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        _0033_Search search = new _0033_Search();
        int result = search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 9);
        System.out.println(result);
    }

}
