package com.gmy.leetcode.top100;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * todo review
 */
public class _0045_Jump {

    public int jump(int[] nums) {
        // max 调到index后可以到达的最远长度
        // currentIndex 当前index
        int max = 0, currentIndex = 0, step = 0;
        while (currentIndex < nums.length - 1) {
            int num = nums[currentIndex], index = 0;
            if (currentIndex + num >= nums.length - 1) {
                return step + 1;
            }
            for (int i = 1; i <= num && i < nums.length; i++) {
                // 下一步能到达的最远长度
                if (currentIndex + i + nums[i] > max) {
                    max = currentIndex + nums[i];
                    index = currentIndex + i;
                }
            }
            step++;
            currentIndex = index;
        }
        return step;
    }

    public static void main(String[] args) {
        _0045_Jump jump = new _0045_Jump();
        int result = jump.jump(new int[]{2,3,1});
        System.out.println(result);
    }

}
