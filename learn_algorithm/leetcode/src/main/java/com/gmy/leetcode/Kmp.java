package com.gmy.leetcode;

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


    public static void main(String[] args) {
        int i = strStr("", "a");
        System.out.println(i);
    }

}
