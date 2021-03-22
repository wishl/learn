package com.gmy.leetcode.week.dobuleweek.onetwosix;

/**
 * 给你一个整数数组 nums ，数组中的元素都是 正 整数。
 * 定义一个加密函数 encrypt ，encrypt(x) 将一个整数 x 中 每一个 数位都用 x 中的 最大 数位替换。
 * 比方说 encrypt(523) = 555 且 encrypt(213) = 333 。
 *
 * 请你返回数组中所有元素加密后的 和 。
 *
 * https://leetcode.cn/problems/find-the-sum-of-encrypted-integers/description/
 *
 * 输入：nums = [1,2,3]
 *
 * 输出：6
 *
 * 解释：加密后的元素位 [1,2,3] 。加密元素的和为 1 + 2 + 3 == 6 。
 *
 * 输入：nums = [10,21,31]
 *
 * 输出：66
 *
 * 解释：加密后的元素为 [11,22,33] 。加密元素的和为 11 + 22 + 33 == 66 。
 *
 */
public class SumOfEncryptedInt {

    public int sumOfEncryptedInt(int[] nums) {
        encrypt(nums);
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }

    private void encrypt(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i], max = 0, n = 0;
            while (num > 0) {
                max = Math.max(max, num % 10);
                num = num / 10;
            }
            num = nums[i];
            while (num > 0) {
                n = n * 10 + max;
                num = num / 10;
            }
            nums[i] = n;
        }
    }

    public static void main(String[] args) {
        SumOfEncryptedInt sumOfEncryptedInt = new SumOfEncryptedInt();
        int result = sumOfEncryptedInt.sumOfEncryptedInt(new int[]{10,21,31});
        System.out.println(result);
    }

}
