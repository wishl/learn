package com.gmy.leetcode.top100;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * cattcat
 * cat tcat catt
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * todo review 实际上dp标记的是尾部
 */
public class _0139_WordBreak {

    //def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    //        n=len(s)
    //        dp=[False]*(n+1)
    //        dp[0]=True
    //        for i in range(n):
    //            for j in range(i+1,n+1):
    //                if(dp[i] and (s[i:j] in wordDict)):
    //                    dp[j]=True
    //        return dp[-1]

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < dp.length; j++) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        _0139_WordBreak wordBreak = new _0139_WordBreak();
        List<String> list = Lists.newArrayList("a","abc","b","cd");
        boolean result = wordBreak.wordBreak("abcd", list);
        System.out.println(result);
    }
}
