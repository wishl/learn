package com.gmy.leetcode.string;


/**
 * kmp算法
 */
public class KMPReview {

    public static int kmp(String str, String pattern) {
        int[] next = getNext(pattern);
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            while (i > 0 && str.charAt(i) != pattern.charAt(index)) {
                index = next[index];
            }
            if (str.charAt(i) == pattern.charAt(index)) {
                index++;
            }
            if (index == pattern.length()) {
                return i - index + 1;
            }
        }
        return -1;
    }

    /**
     * 获取next数组
     * @return
     */
    private static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        for (int i = 2; i < pattern.length(); i++) {
            while (j != 0 && pattern.charAt(j) != pattern.charAt(i - 1)) {
                // 从next[i+1]的求解回溯到 next[j]
                j = next[j];
            }
            if (pattern.charAt(j) == pattern.charAt(i - 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        int kmp = kmp("1234", "234");
        System.out.println(kmp);
    }

}
