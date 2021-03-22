package com.gmy.leetcode.half.answer;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/description/
 */
public class Search {

    /**
     * 寻找峰值
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            // mid 在最小值的右侧
            if (nums[mid] < nums[nums.length - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int midFind(int[] nums, int left, int right, int target) {
        // [left, right]
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    public int search(int[] nums, int target) {
        // 1. 寻找峰值
        int minIndex = findMin(nums);
        int left = 0, right = nums.length - 1;
        // 如果topIndex == nums.length 的时候 说明没翻转
        // 否则计算target 如果 >= nums[0] 则使用前半段 否则时候后半段计算
        if (minIndex > 0 && target >= nums[0]) {
            right = minIndex - 1;
        } else {
            left = minIndex;
        }
        // 2. 根据峰值计算使用那个范围二分
        int result = midFind(nums, left, right, target);
        return (result == nums.length || nums[result] != target) ? -1 : result;
    }

    public static void main(String[] args) {
        Search search = new Search();
        int result = search.search(new int[]{1, 3}, 3);
        System.out.println(result);
    }

}
