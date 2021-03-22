package com.gmy.leetcode.half.answer;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 *
 * 示例 3 :
 * 输入：nums = [3,3,3,3,3]
 * 输出：3
 *
 * https://leetcode.cn/problems/find-the-duplicate-number/description/
 */
public class FindDuplicate {

    public int findDuplicate2(int[] nums) {
        int slower = 0;
        int faster = 0;
        while (true) {
            slower = nums[slower];
            faster = nums[nums[faster]];
            if (slower == faster) {
                break;
            }
        }
        slower = 0;
        while (true) {
            slower = nums[slower];
            faster = nums[faster];
            if (slower == faster) {
                break;
            }
        }
        return slower;

    }

    public int findDuplicate(int[] nums) {
        int count = 0;
        int left = 0, right = nums.length - 1;
        // 遍历index
        while (left <= right) {
            int mid = (left + right) / 2;
            for (int num : nums) {
                if (num <= mid + 1) {
                    count++;
                }
            }
            // 数量小于等于mid + 1 说明重复的在右边
            if (count <= mid + 1) {
                left = mid + 1;
            } else {
                // right 包含重复的数
                right = mid - 1;
            }
            count = 0;
        }
        return left + 1;
    }

    public int findDuplicate1(int[] nums) {
        ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantLock.readLock();
        readLock.lock();

        int len = nums.length; // n + 1 = len, n = len - 1

        // 在 [1..n] 查找 nums 中重复的元素
        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            // nums 中小于等于 mid 的元素的个数
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                // 下一轮搜索的区间 [left..mid]
                right = mid;
            } else {
                // 下一轮搜索的区间 [mid + 1..right]
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        int result = findDuplicate.findDuplicate(new int[]{1, 3, 4, 2, 2});
        int result1 = findDuplicate.findDuplicate2(new int[]{1, 3, 4, 2, 2});
        System.out.println(result);
        System.out.println(result1);
    }

}
