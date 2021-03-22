package com.gmy.leetcode.prefix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。你可以将 nums 中的元素按 任意顺序 重排（包括给定顺序）。
 * 令 prefix 为一个数组，它包含了 nums 重新排列后的前缀和。换句话说，
 * prefix[i] 是 nums 重新排列后下标从 0 到 i 的元素之和。nums 的 分数 是 prefix 数组中正整数的个数。
 * 返回可以得到的最大分数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rearrange-array-to-maximize-prefix-score
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [2,-1,0,1,-3,3,-3]
 * 输出：6
 * 解释：数组重排为 nums = [2,3,1,-1,-3,0,-3] 。
 * prefix = [2,5,6,5,2,2,-1] ，分数为 6 。
 * 可以证明 6 是能够得到的最大分数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rearrange-array-to-maximize-prefix-score
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxScore {

    public int maxScore(int[] nums) {
        List<Integer> sorted = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        int count = 0;
        long result = 0;
        for (Integer integer : sorted) {
            result += integer;
            if (result > 0) {
                count++;
            }
        }
        return count;
    }
}
