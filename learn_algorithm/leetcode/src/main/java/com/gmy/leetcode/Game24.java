package com.gmy.leetcode;

/**
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 */
public class Game24 {

    // 未完成，明天重做
    public static boolean judgePoint24(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (getResult(nums[i], 24, nums, 0, i)) {
                return true;
            }
        }
        return false;
    }


    private static boolean getResult(int result, int target, int[] nums, int index, int targetIndex) {
        if (result == target) {
            return true;
        }
        if (index >= nums.length || targetIndex >= nums.length) {
            return false;
        }
        boolean flag;
        // 不和自己计算
        if (index == targetIndex) {
            return getResult(result, target, nums, index + 1, targetIndex);
        }
        flag = getResult(result + nums[index], target, nums, index + 1, targetIndex);
        if (flag) {
            return true;
        }
        flag = getResult(result - nums[index], target, nums, index + 1, targetIndex);
        if (flag) {
            return true;
        }
        flag = getResult(result * nums[index], target, nums, index + 1, targetIndex);
        if (flag) {
            return true;
        }
        flag = getResult(result / nums[index], target, nums, index + 1, targetIndex);
        if (flag) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 9, 1, 2};
        boolean flag = judgePoint24(nums);
        System.out.println(flag);
    }

}
