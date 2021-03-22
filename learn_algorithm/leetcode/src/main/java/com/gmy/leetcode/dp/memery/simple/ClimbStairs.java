package com.gmy.leetcode.dp.memery.simple;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * https://leetcode.cn/problems/climbing-stairs/description/
 */
public class ClimbStairs {

    /**
     * dfs方法 + 记忆化
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        return dfs(n, new int[n + 1]);
    }

    private int dfs(int n, int[] cache) {
        if (n <= 1) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        // 选择一次爬一级台阶则是n
        int result = dfs(n - 1, cache) + dfs(n - 2, cache);
        cache[n] = result;
        return result;
    }

    /**
     * 递推 搞一个数组 存储之前的状态
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    /**
     * 递推 使用滚动数组优化空间复杂度
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int value = 1, v1 = 1, v2 = 1;
        for (int i = 2; i <= n; i++) {
            value = v1 + v2;
            v2 = v1;
            v1 = value;
        }
        return value;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int result = climbStairs.climbStairs(3);
        int result1 = climbStairs.climbStairs2(3);
        System.out.println(result);
        System.out.println(result1);
    }

}
