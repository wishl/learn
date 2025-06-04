package com.gmy.leetcode.week.dobuleweek._157;

import java.util.*;

/**
 * 给定一个字符串 s，找出可以由其 子字符串 组成的 3个最大的不同质数 的和。
 * 返回这些质数的 总和 ，如果少于 3 个不同的质数，则返回 所有 不同质数的和。
 * 质数是大于 1 且只有两个因数的自然数：1和它本身。
 * 子字符串 是字符串中的一个连续字符序列。
 * 注意：每个质数即使出现在 多个 子字符串中，也只能计算 一次 。此外，将子字符串转换为整数时，忽略任何前导零。
 *
 * 示例 1：
 * 输入： s = "12234"
 * 输出： 1469
 * 解释：
 * 由 "12234" 的子字符串形成的不同质数为 2 ，3 ，23 ，223 和 1223。
 * 最大的 3 个质数是 1223、223 和 23。它们的和是 1469。
 */
public class SumOfLargestPrimes {

    /**
     * 先获取全排列 然后获取判断是否是质数 然后排序 最后求和
     * @param s
     * @return
     */
    public long sumOfLargestPrimes(String s) {
        List<Long> allNumber = getAllNumber(s, new HashSet<>());
        Collections.sort(allNumber);
        long result = 0;
        for (int i = allNumber.size() - 1; i >= Math.max(0, allNumber.size() - 3); i--) {
            result += allNumber.get(i);
        }
        return result;
    }

    public List<Long> getAllNumber(String s, Set<Long> set) {
        List<Long> result = new ArrayList<>();
        int n = s.length();
        for (int left = 0; left < n; left++) {
            int right = left;
            while (right < n) {
                String substring = s.substring(left, right + 1);
                long number = Long.parseLong(substring);
                if (isPrime(number) && !set.contains(number)) {
                    result.add(number); // 滑动窗口 [left, right]
                    set.add(number);
                }
                right++;
            }
        }
        return result;
    }

    /**
     * 判断一个数是否是质数
     * @param n
     * @return
     */
    public static boolean isPrime(long n) {
        if (n <= 1) return false;      // 0 和 1 不是质数
        if (n == 2) return true;       // 2 是质数
        if (n % 2 == 0) return false;  // 排除偶数

        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false; // 有因数，不是质数
        }
        return true;
    }

    public static void main(String[] args) {
        SumOfLargestPrimes sumOfLargestPrimes = new SumOfLargestPrimes();
        long result = sumOfLargestPrimes.sumOfLargestPrimes("6735992919");
        System.out.println(result);
    }

}
