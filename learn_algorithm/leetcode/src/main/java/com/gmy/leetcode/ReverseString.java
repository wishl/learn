package com.gmy.leetcode;

public class ReverseString {

    public static void reverseString(char[] s) {
        int end = s.length - 1;
        int start = 0;
        char tmp;
        while (end >= start) {
            tmp = s[end];
            s[end] = s[start];
            s[start] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
        System.out.println(chars);
    }

}
