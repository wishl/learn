package com.gmy.leetcode.week.contest.treenineone;

/**
 * 如果一个整数能够被其各个数位上的数字之和整除，
 * 则称之为 哈沙德数（Harshad number）。
 * 给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x 各个数位上的数字之和，否则，返回 -1 。
 *
 * https://leetcode.cn/problems/harshad-number/description/
 *
 * 输入： x = 18
 * 输出： 9
 *
 * 解释：
 * x 各个数位上的数字之和为 9 。18 能被 9 整除。因此 18 是哈沙德数，答案是 9 。
 */
public class SumOfTheDigitsOfHarshadNumber {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0, copy = x;
        while (copy > 0) {
            sum += copy % 10;
            copy = copy / 10;
        }
        return x % sum == 0 ? sum : -1;
    }

    public static void main(String[] args) {
        SumOfTheDigitsOfHarshadNumber sumOfTheDigitsOfHarshadNumber = new SumOfTheDigitsOfHarshadNumber();
        int result = sumOfTheDigitsOfHarshadNumber.sumOfTheDigitsOfHarshadNumber(100);
        System.out.println(result);
    }

}
