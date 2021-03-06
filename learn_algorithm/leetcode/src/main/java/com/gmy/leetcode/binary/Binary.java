package com.gmy.leetcode.binary;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 */
public class Binary {

    public static int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }


    public static void main(String[] args) {
        int result = hammingWeight(4);
        System.out.println(result);
    }

}
