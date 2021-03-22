package com.gmy.leetcode.review;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Convert {

    public String convert(String s, int numRows) {
        StringBuilder builder = new StringBuilder();
        int gap = 0;
        int totalGap = (numRows - 1) * 2;
        if (s == null || s.length() <= 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += gap) {
                builder.append(s.charAt(j));
                if (i == 0 || i == numRows - 1) {
                    gap = (numRows - 1) * 2;
                } else if ((j - i) % totalGap == 0 && gap > 2) {
                    gap -= 2;
                } else {
                    gap = totalGap - gap;
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        String result = convert.convert("AB", 1);
        System.out.println(result);
    }

}
// PAHNAPLSIIGYIR
