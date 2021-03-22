package com.gmy.leetcode.sliding_window;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串s ，请你返回满足以下条件且出现次数最大的任意子串的出现次数：
 * 子串中不同字母的数目必须小于等于 maxLetters 。
 * 子串的长度必须大于等于minSize 且小于等于maxSize 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-number-of-occurrences-of-a-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1：
 * 输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * 输出：2
 * 解释：子串 "aab" 在原字符串中出现了 2 次。
 * 它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
 *
 * 示例 2：
 * 输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * 输出：2
 * 解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
 *
 * 示例 3：
 * 输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * 输出：3
 *
 * 示例 4：
 * 输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-number-of-occurrences-of-a-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MaxFreq {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        //统计子串出现的个数
        Map<String,Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int left = 0,right = 0;
        //统计窗口中不同字母的数目
        int tmp = 0;
        //记录窗口中字母的个数
        int[] count = new int[128];
        while(right < n) {
            count[c[right]]++;
            //当下面条件成立时，则说明窗口中多了一个不同的字母
            if (count[c[right]] == 1) tmp++;
            right++;
            int len = right - left;
            while(tmp > maxLetters || len > minSize) {
                count[c[left]]--;
                //当窗口左移的过程中，一个字母减为0，则说明窗口中少了一个不同的字母
                if(count[c[left]] == 0) tmp--;
                left++;
                //如果没有这句，会陷入死循环，len会一直大于minSize
                len--;
            }
            //当不同字母的数目小于等于maxLetters
            if(tmp <= maxLetters && len == minSize) {
                String str = s.substring(left,right);
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }
        //统计字串最大出现的次数
        int ans = 0;
        for(String key : map.keySet()) {
            ans = Math.max(ans,map.get(key));
        }
        return ans;
    }

    public int maxFreq1(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> countMap = new HashMap<>();
        Map<Character, Integer> charContMap = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            charContMap.put(c, charContMap.getOrDefault(c, 0) + 1);
            while (right - left + 1 >= minSize) {
                if (charContMap.size() <= maxLetters) {
                    String substring = s.substring(left, right + 1);
                    countMap.put(substring, countMap.getOrDefault(substring, 0) + 1);
                }
                char lc = s.charAt(left);
                if (charContMap.get(lc) == 1) {
                    charContMap.remove(lc);
                } else {
                    charContMap.put(lc, charContMap.getOrDefault(lc, 0) - 1);
                }
                left++;
            }
            right++;
        }
        Integer max = countMap.entrySet().stream().map(Map.Entry::getValue).max(Integer::compare).orElse(0);
        return max;
    }

    public static void main(String[] args) {
        MaxFreq maxFreq = new MaxFreq();
        // "abcabababacabcabc"
        //3
        //3
        //10
        String s = "abcabababacabcabc";
        int result = maxFreq.maxFreq1(s, 3, 3, 10);
        System.out.println(result);
    }
}
