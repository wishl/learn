package com.gmy.leetcode.doublepoint;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * todo 需要review  kmp sunny 和 bm 算法
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int left = i, right = i;
                while ((right - left) < needle.length() && right < haystack.length()) {
                    if (needle.charAt(right - left) == haystack.charAt(right)) {
                        right++;
                    } else {
                        break;
                    }
                }
                if ((right - left) == needle.length()) {
                    return left;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        int i = strStr.strStr("sadbutsad", "sadbutsad");
        System.out.println(i);
    }

}
