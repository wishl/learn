package com.gmy.leetcode.top100;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
public class _0045_JumpReview {

    public int jump(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0], copy = max, index = 0, j = 0, count = 0;
        while (index < nums.length - 1) {
            while (j <= copy) {
                if (j == nums.length - 1 || (j < nums.length && max < j + nums[j])) {
                    index = j;
                    max = j + nums[j];
                }
                j++;
            }
            count++;
            copy = max;
        }
        return count;
    }

    public static void main(String[] args) {
        _0045_JumpReview jump = new _0045_JumpReview();
        int result = jump.jump(new int[]{2, 1, 1});
        System.out.println(result);
    }
}
