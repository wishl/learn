package com.gmy.leetcode.array;

import java.util.Arrays;
import java.util.Map;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * todo review
 */
public class Jump {

    public int jump(int[] nums) {
        int result = 0, length = nums.length - 1, max = 0;
        int i = 0, index = i;
        while (i < nums.length) {
            if (index >= nums.length - 1) {
                return result;
            }
            result++;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= length) {
                    return result;
                } else if (max < (nums[i + j] + i + j)) {
                    max = nums[i + j] + i + j;
                    index = i + j;
                }
            }
            i = index;
            max = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        int result = jump.jump(new int[]{0, 1});
        System.out.println(result);
    }

}
