package com.gmy.leetcode.dp.memery.simple;

import org.checkerframework.checker.units.qual.C;

import java.util.Arrays;

/**
 * 一条街道上共有 n * 2 个 地块 ，街道的两侧各有 n 个地块。每一边的地块都按从 1 到 n 编号。每个地块上都可以放置一所房子。
 * 现要求街道同一侧不能存在两所房子相邻的情况，请你计算并返回放置房屋的方式数目。由于答案可能很大，需要对 109 + 7 取余后再返回。
 * 注意，如果一所房子放置在这条街某一侧上的第 i 个地块，不影响在另一侧的第 i 个地块放置房子。
 *
 * https://leetcode.cn/problems/count-number-of-ways-to-place-houses/description/
 */
public class CountHousePlacements {
    int mod = 1_000_000_007;

    /**
     * dfs + 记忆化搜索
     * @param n
     * @return
     */
    public int countHousePlacements(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        int result = dfs(n, cache);
        long r =  (long) result * (long) result;
        return (int) (r % mod);
    }

    public int dfs(int n, int[] cache) {
        if (n <= 0) {
            return 1;
        }
        if (cache[n] != -1) {
            return cache[n];
        }
        // 左边 和 右边 可以随意
        int result = dfs(n - 1, cache) % mod + dfs(n - 2, cache) % mod;
        cache[n] = result;
        return result;
    }

    /**
     * 递推方法
     * @param n
     * @return
     */
    public int countHousePlacements1(int n) {
        long[] cache = new long[n + 3];
        // index 从1开始使用
        cache[1] = 1;
        for (int i = 0; i <= n; i++) {
            cache[i + 2] = (cache[i] + cache[i + 1]) % mod;
        }
        long result = (cache[n + 2] * cache[n + 2]) % mod;
        return (int) result;
    }

    public int countHousePlacements2(int n) {
        int value = 0, v1 = 1, v2 = 0;
        for (int i = 0; i <= n; i++) {
            value = (v1 + v2) % mod;
            v2 = v1;
            v1 = value;
        }
        long r =  (long) v1 * (long) v1;
        return (int) (r % mod);
    }

    public static void main(String[] args) {
        CountHousePlacements countHousePlacements = new CountHousePlacements();
        int result = countHousePlacements.countHousePlacements(100);
        int result1 = countHousePlacements.countHousePlacements1(100);
        int result2 = countHousePlacements.countHousePlacements2(100);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
    }

}
