package com.gmy.leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            if (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            if (countMap.getOrDefault(c, 0) > 0) {
                countMap.put(c, countMap.get(c) - 1);
                if (right - left + 1 == s1.length()) {
                    return true;
                }
                right++;
            } else {
                countMap.put(s2.charAt(left), countMap.getOrDefault(s2.charAt(left) , 0) + 1);
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        boolean b = checkInclusion.checkInclusion("trinitrophenylmethylnitramine", "lhydrazinetrinitrophenylmethylnitramine");
        System.out.println(b);
    }

}
