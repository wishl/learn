package com.gmy.leetcode.dp.memery.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountTexts {

    int mod = 1_000_000_007;

    public int countTexts(String pressedKeys) {
        char[] charArray = pressedKeys.toCharArray();
        int left = 0, right = left;
        int result = 1;
        while (right <= pressedKeys.length()) {
            if (right == pressedKeys.length() || charArray[left] != charArray[right]) {
                int[] cache = new int[right - left + 1];
                Arrays.fill(cache, -1);
//                result *= dfs(charArray[left] - '0', right - left) % mod;
                result *= dfs(charArray[left], right - left, cache) % mod;
                left = right;
            }
            right++;
        }
        return result;
    }

    /**
     * 解题看 https://leetcode.cn/problems/count-number-of-texts/solutions/1477501/ji-yi-hua-dfszi-fu-chuan-by-handsomechen-jedz/
     * @param num
     * @param times
     * @return
     */
    public int dfs1(int num, int times) {
        if (times == 0) {
            return 1;
        }
        int ans = 0;
        if (num == 2 || num == 3 || num == 4 || num == 5 || num == 6 || num == 8) {
            for (int i = 1; i <= Math.min(3, times); i++) {
                ans += dfs1(num, times - i);
                ans %= mod; // 确保在每一步都取模，防止溢出
            }
        } else {
            for (int i = 1; i <= Math.min(4, times); i++) {
                ans += dfs1(num, times - i);
                ans %= mod; // 确保在每一步都取模，防止溢出
            }
        }
        return ans;
    }

    private int dfs(char c, int n, int[] cache) {
        if (n == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i <= Math.min(3, n); i++) {
            result += dfs(c, n - i, cache);
        }
        return result;
    }

    public static void main(String[] args) {
        CountTexts countTexts = new CountTexts();
        int result = countTexts.countTexts("2222");
        System.out.println(result);
    }
}
