package com.gmy.leetcode;

public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() == 2) {
            return s.substring(0 , 1).equals(s.substring(1));
        }
        int index = s.length() / 2;
        while (index > 0) {
            boolean flag = false;
            String begin = s.substring(0, index);
            for (int i = index; i < s.length(); i+= index) {
                if (i + index > s.length()) {
                    index--;
                    flag = false;
                    break;
                }
                String end = s.substring(i, i + index);
                if (!begin.equals(end)) {
                    index--;
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    // 构建双倍
    public static boolean repeatedSubstringPattern1(String s) {
        // aabaab + aabaab
        return (s + s).indexOf(s, 1) != s.length();
    }

    public static void main(String[] args) {
        String s = "ssssddssssdd";
        int i = s.indexOf(s, 1);
        System.out.println(i);
    }

}
