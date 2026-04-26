package com.gmy.leetcode.week.contest._490;

/**
 * 给你两个长度均为 n 的二进制字符串 s 和 t。
 * 你可以按任意顺序 重新排列 t 中的字符，但 s 必须保持不变。
 * 返回一个长度为 n 的 二进制字符串，表示将 s 与重新排列后的 t 进行按位 异或 (XOR) 运算所能获得的 最大 整数值。
 */
public class MaximumXor {

    /**
     * 尽量让高位不同
     * @param s
     * @param t
     * @return
     */
    public String maximumXor(String s, String t) {
        int zeroCount = 0, oneCount = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && oneCount > 0) {
                result.append("1");
                oneCount--;
            } else if (s.charAt(i) == '0' && oneCount == 0) {
                result.append("0");
                zeroCount--;
            } else if (s.charAt(i) == '1' && zeroCount > 0) {
                result.append("1");
                zeroCount--;
            } else {
                result.append("0");
                oneCount--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MaximumXor maximumXor = new MaximumXor();
        String maximumXor1 = maximumXor.maximumXor("101", "011");
        System.out.println(maximumXor1);
    }
}
