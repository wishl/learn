package com.gmy.leetcode.doublepoint;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class Palindrome {

    public static boolean isPalindrome(String s) {
        s = s.toUpperCase();
        // [48,57],[65,90]
        int start = 0, end = s.length() - 1;
        while (end > start) {
            char begin = s.charAt(start);
            char end1 = s.charAt(end);
            if (begin < '0' || (begin > '9' && begin < 'A') || begin > 'Z') {
                start++;
                continue;
            }
            if (end1 < '0' || (end1 > '9' && end1 < 'A') || end1 > 'Z') {
                end--;
                continue;
            }
            if (begin != end1) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = isPalindrome("");
        System.out.println(result);
    }

}
