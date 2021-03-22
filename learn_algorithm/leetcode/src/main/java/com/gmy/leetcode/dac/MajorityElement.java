package com.gmy.leetcode.dac;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {

    /**
     * 方法5 投票选举，value == 0时 交换candidate，相同 +1 不同 -1
     * 如果当前的数是众数的话 不会减到0
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int value = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (value == 0) {
                candidate = num;
            }
            value += (num == candidate) ? 1 : -1;
        }
        return 0;
    }

    /**
     * 分治法 类似于快排或者 归并
     * @return
     */
    public int majorityElement1(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private int dfs(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int L = dfs(nums, left, mid);
        int R = dfs(nums, mid + 1, right);
        if (L == R) {
            return L;
        }
        int lCount = calMax(nums, left, mid, L);
        int rCount = calMax(nums, mid + 1, right, R);
        return lCount > rCount ? L : R;
    }


    private int calMax(int[] nums, int left, int right, int num) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}
