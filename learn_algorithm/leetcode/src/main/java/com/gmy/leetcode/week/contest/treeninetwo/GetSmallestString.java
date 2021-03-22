package com.gmy.leetcode.week.contest.treeninetwo;

/**
 * 定义函数 distance(s1, s2) ，用于衡量两个长度为 n 的字符串 s1 和 s2 之间的距离，即：
 * 字符 'a' 到 'z' 按 循环 顺序排列，对于区间 [0, n - 1] 中的 i ，计算所有「 s1[i] 和 s2[i] 之间 最小距离」的 和 。
 * 例如，distance("ab", "cd") == 4 ，且 distance("a", "z") == 1 。
 * 你可以对字符串 s 执行 任意次 操作。在每次操作中，可以将 s 中的一个字母 改变 为 任意 其他小写英文字母。
 * 返回一个字符串，表示在执行一些操作后你可以得到的 字典序最小 的字符串 t ，且满足 distance(s, t) <= k 。
 *
 * https://leetcode.cn/problems/lexicographically-smallest-string-after-operations-with-constraint/
 *
 * 输入：s = "zbbz", k = 3
 * 输出："aaaz"
 * 解释：在这个例子中，可以执行以下操作：
 * 将 s[0] 改为 'a' ，s 变为 "abbz" 。
 * 将 s[1] 改为 'a' ，s 变为 "aabz" 。
 * 将 s[2] 改为 'a' ，s 变为 "aaaz" 。
 * "zbbz" 和 "aaaz" 之间的距离等于 k = 3 。
 * 可以证明 "aaaz" 是在任意次操作后能够得到的字典序最小的字符串。
 * 因此，答案是 "aaaz" 。
 *
 * xaxcd
 * zzzz 2000
 * aaab
 * aawcd
 */
public class GetSmallestString {

    public String getSmallestString(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int toADistance = Math.min('z' - c + 1, c - 'a');
            if (k < toADistance) {
                c -= k;
                charArray[i] = c;
                break;
            }
            k -= toADistance;
            charArray[i] = 'a';
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        GetSmallestString getSmallestString = new GetSmallestString();
        String result = getSmallestString.getSmallestString("zbbz", 3);
        System.out.println(result);
    }

}
