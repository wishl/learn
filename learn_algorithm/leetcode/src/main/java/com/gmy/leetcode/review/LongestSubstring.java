package com.gmy.leetcode.review;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * 如果不存在这样的子字符串，则返回 0。
 * https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/description/
 */
public class LongestSubstring {

    /**
     * 方法1： 滑动窗口
     * 因为不知道何时可以计算长度（因为不能确定字符串中有多少个符合条件的字母）
     * 所有把问题拆分成子问题：计算 字符s中 最多包含 n 个不同字母 且每个字母至少有k个的 最长子串
     * 此时子问题可以通过滑动窗口解决
     * 然后通过不断枚举 n 的数量（ 1 <= n <= 26 字母是可枚举的）
     * 优化 如果s中不包含所有的字母 就没必要遍历所有26个字母 有多少算多少就行
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        int max = 0;
        int length = s.length();
        for (int i = 1; i <= 26; i++) {
            max = Math.max(window(s, k, i, length), max);
        }
        return max;
    }

    /**
     * 子问题：
     * 计算 字符s中 最多包含 n 个不同字母 且每个字母至少有k个的 最长子串
     * @return
     */
    private int window(String s, int k, int n, int length) {
        int start = 0, end = 0, count = 0, full = 0, result = 0;
        int[] cache = new int[26];
        while (end < length) {
            char charAt = s.charAt(end++);
            int cacheCount = cache[charAt - 'a']++;
            // 之前不存在 说明窗口内有个新的字母类型
            if (cacheCount == 0) {
                count++;
            }
            // ++之前k - 1个重复字母 说明满足至少k个重复 full++
            if (cacheCount == k - 1) {
                full++;
            }
            // 如果count > n 说明种类超了 start++
            // 必须得先保证种类不超 否则可能出现
            // aaa b k == 3 n == 1 的时候 计算出的length 比实际大
            while (count > n) {
                char startCharAt = s.charAt(start++);
                int startCacheCount = cache[startCharAt - 'a']--;
                // -- 之前 只有1个 说明 -- 之后就不存在这个类型了 count--
                if (startCacheCount == 1) {
                    count--;
                }
                // -- 之前 是 k 说明 之后就不满足条件了 所以full--
                if (startCacheCount == k) {
                    full--;
                }
            }
            // full == count的时候 说明所有都满足大于等于k的条件了 计算长度
            if (full == count) {
                result = Math.max(result, end - start);
            }
        }
        return result;
    }


    /**
     * 方法2：分治
     * 思想：s的子串如果要满足条件 说明一定不包含出现次数小于k的字母
     * 写法：s字符串计算每个字母出现的次数，然后根据出现次数小于k的字母切分 然后递归的继续进行判断 然后获取最大的长度
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring1(String s, int k) {
        return dfs(s, k);
    }

    private int dfs(String s, int k) {
        // 如果切出的子串长度小于k 则一定不满足
        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            cache.put(charAt, cache.getOrDefault(charAt, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : cache.entrySet()) {
            Character c = entry.getKey();
            if (entry.getValue() < k) {
                int max = 0;
                String[] split = s.split(String.valueOf(c));
                for (String subString : split) {
                    max = Math.max(dfs(subString, k), max);
                }
                return max;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        int result = longestSubstring.longestSubstring("ababbc", 2);
        int result1 = longestSubstring.longestSubstring1("ababbc", 2);
        System.out.println(result);
        System.out.println(result1);
    }


}
