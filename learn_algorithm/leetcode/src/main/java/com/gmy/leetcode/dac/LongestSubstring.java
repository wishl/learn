package com.gmy.leetcode.dac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestSubstring {


    /**
     * 3
     * abaabbb c aabb zzzeeeee d d q q c aaa
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    private int dfs(String s, int left, int right, int k) {
        if (left > right) {
            return 0;
        }
        int[] indexList = getErrorList(s, left, right, k);
        int max = 0;
        for (int i = 0; i < indexList.length; i++) {
            int index = indexList[i];
            int leftIndex = (i - 1) >= 0 ? indexList[i - 1] + 1: left;
            int L = dfs(s, leftIndex, index - 1, k);
            int rightIndex = (i + 1) >= indexList.length ? right : indexList[i + 1] - 1;
            int R = dfs(s, index + 1,  rightIndex, k);
            max = Math.max(max, Math.max(L, R));
        }
        if (indexList.length == 0) {
            return right - left + 1;
        }
        return max;
    }

    private int[] getErrorList(String s, int left, int right, int k) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            List<Integer> indexList = indexMap.getOrDefault(c, new ArrayList<>());
            indexList.add(i);
            indexMap.putIfAbsent(c, indexList);
        }
        for (Map.Entry<Character, List<Integer>> entry : indexMap.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() < k) {
                queue.addAll(value);
            }
        }
        int[] result = new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public int longestSubstring1(String s, int k) {
        int n = s.length();
        return dfs1(s, 0, n - 1, k);
    }

    public int dfs1(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }


    /**
     * 滑动窗口解析，首先判断1个字符在序列中有没有然后递增字符数量，直到26个字符都处理完成，
     * ret记录最大的长度
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring2(String s, int k) {
        int ret = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {
            int l = 0, r = 0;
            int[] cnt = new int[26];
            int tot = 0;
            int less = 0;
            while (r < n) {
                cnt[s.charAt(r) - 'a']++;
                if (cnt[s.charAt(r) - 'a'] == 1) {
                    tot++;
                    less++;
                }
                if (cnt[s.charAt(r) - 'a'] == k) {
                    less--;
                }

                while (tot > t) {
                    cnt[s.charAt(l) - 'a']--;
                    if (cnt[s.charAt(l) - 'a'] == k - 1) {
                        less++;
                    }
                    if (cnt[s.charAt(l) - 'a'] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
//        String s = "abaabbbcaabbzzzeeeeeddqqcaaa";
//        String s = "ababb";
        String s = "a";
        LongestSubstring longestSubstring = new LongestSubstring();
        int result = longestSubstring.longestSubstring2(s, 1);
        System.out.println(result);
    }

}
