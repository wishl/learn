package com.gmy.leetcode.sliding_window;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 空格：读入字符串并丢弃无用的前导空格（" "）
 * 符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
 * 转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
 * 舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231 − 1 的整数应该被舍入为 231 − 1 。
 * 返回整数作为最终结果
 *
 * https://leetcode.cn/problems/string-to-integer-atoi/description/
 */
public class MyAtoi {

    public int myAtoi(String s) {
        char[] charArray = s.toCharArray();
        long result = 0, mulit = 1;
        boolean begin = false;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!begin && c == ' ') {
                continue;
            }
            if (!begin && (c == '-' || c == '+' )) {
                mulit = c == '-' ?  -1 : 1;
                begin = true;
                continue;
            }
            begin = true;
            if (c < '0' || c > '9') {
                break;
            }
            result = result * 10 + (c - '0');
            if ((result * mulit) > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if ((result * mulit) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (result * mulit);
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        int result = myAtoi.myAtoi("  +  413");
        System.out.println(result);
    }
}
