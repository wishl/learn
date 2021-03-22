package com.gmy.leetcode.prefix;


/**
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    // todo 动态规划
    private int dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length && target == sum) {
            return 1;
        } else if (index == nums.length && target != sum) {
            return 0;
        }
        // + 当前index
        int dfs = dfs(nums, target, index + 1, sum + nums[index]);
        // - 当前index
        dfs += dfs(nums, target, index + 1, sum - nums[index]);
        return dfs;
    }

    public static void main(String[] args) {
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        int targetSumWays = findTargetSumWays.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }

}
