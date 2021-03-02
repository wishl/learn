package com.gmy.leetcode;

import java.util.Arrays;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Kmp {

    // 非kmp解法
    public static int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.equals("")) {
            return 0;
        }
        char needleChar = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            char haystackChar = haystack.charAt(i);
            if (needleChar == haystackChar) {
                if(valid(haystack, needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean valid(String haystack, String needle, int index) {
        int i = 0;
        for (; i < needle.length() && index < haystack.length(); i++,index++) {
            char haystackChar = haystack.charAt(index);
            char needleChar = needle.charAt(i);
            if (haystackChar != needleChar) {
                return false;
            }
        }
        return i == needle.length();
    }


    // kmp解法：
    // 1. 获取PMT：
    private static int[] getPMT(String s) {
        // 整体后移一位
        int[] result = new int[s.length() + 1];
        // 给第一个赋值0方便开发
        result[0] = -1;
        int i = 0;
        int j = -1;
        while (i < s.length()) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                // 如果相等，给下一个赋值，方便开发
                i++;
                j++;
                result[i] = j;
            } else {
                // 从头开始
                j = result[j];
            }
        }
        return result;
    }

    // 2. 根据PMT匹配字符串：
    private static int Kmp(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.equals("")) {
            return 0;
        }
        int[] pmt = getPMT(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            } else {
                // 从kmp中获取index在进行匹配
                j = pmt[j];
            }
        }
        if(j == needle.length()) {
            // 返回匹配到的开始长度
            return i - j;
        }
        return -1;
    }

    // sunday 算法：
    private static int sunday(String haystack, String needle) {
        char[] total = haystack.toCharArray();
        char[] part = needle.toCharArray();
        int tSize = total.length;
        int pSize = part.length;
        int[] move = new int[126];
        //主串参与匹配最末位字符移动到该位需要移动的位数
        for (int i= 0;i<126;i++){
            move[i] = pSize+1;
        }

        for (int i = 0;i<=pSize;i++){
            char index = part[i];
            move[index] = pSize - i;
        }

        int s = 0;//模式串头部在字符串位置

        int j;//模式串已经匹配了的长度

        while(s <= tSize - pSize) {//到达末尾之前
            j = 0;
            while(total[s + j] == part[j]) {
                j++;
                if (j >= pSize) {
                    return s;
                }
            }

            int i = s + pSize - 1;
            if (i < total.length) {
                s += move[total[i]];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int i = sunday("aaaaaa", "bba");
//        int i = sunday("susearch", "search");
//        System.out.println(i);
//        int[] ababs = getPMT("abab");
        int kmp = Kmp("abcde", "cde");
        System.out.println(kmp);
    }

}
