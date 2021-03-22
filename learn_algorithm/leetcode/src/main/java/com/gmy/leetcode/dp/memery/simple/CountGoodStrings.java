package com.gmy.leetcode.dp.memery.simple;

import java.util.Arrays;

/**
 * 给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种：
 * 将 '0' 在字符串末尾添加 zero  次。
 * 将 '1' 在字符串末尾添加 one 次。
 * 以上操作可以执行任意次。
 * 如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。
 * 请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
 *
 * https://leetcode.cn/problems/count-ways-to-build-good-strings/description/
 */
public class CountGoodStrings {

    /**
     * dfs + 记忆化
     * @param low
     * @param high
     * @param zero
     * @param one
     * @return
     */
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] cache = new int[high + 1];
        Arrays.fill(cache, -1);
        int ans = 0;
        int mod = 1_000_000_007;
        for (int i = low; i <= high; i++) {
            ans = (ans + dfs(zero, one, i, cache)) % mod;
        }
        return ans;
    }

    /**
     * 枚举字符串长度
     * @param low
     * @param high
     * @param zero
     * @param one
     * @return
     */
    private int dfs(int zero, int one, int length, int[] cache) {
        if (length <= 0) {
            return length == 0 ? 1 : 0;
        }
        if (cache[length] != -1) {
            return cache[length];
        }
        int result = (dfs(zero, one, length - zero, cache) + dfs(zero, one, length - one, cache)) % 1_000_000_007;
        cache[length] = result;
        return result;
    }


    /**
     * 递推
     * @return
     */
    public int countGoodStrings1(int low, int high, int zero, int one) {
        int[] cache = new int[high + 1];
        cache[0] = 1;
        int ans = 0, mod = 1_000_000_007;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                cache[i] = (cache[i] + cache[i - zero]) % mod;
            }
            if (i >= one) {
                cache[i] = (cache[i] + cache[i - one]) % mod;
            }
            if (i >= low) {
                ans = (ans + cache[i]) % mod;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountGoodStrings countGoodStrings = new CountGoodStrings();
        int result = countGoodStrings.countGoodStrings1(3, 3, 1, 1);
        System.out.println(result);
    }

}
