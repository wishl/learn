package com.gmy.leetcode.sliding_window;

/**
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 *
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 *
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 * 示例 2：
 *
 * 输入：s = "bbaaacbbb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 * 示例 3：
 *
 * 输入：s = "abc"
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class NumberOfSubstrings {

    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0, right = 0, result = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            count[c - 'a'] += 1;
            while (count[0] >= 1 && count[1] >= 1 && count[2] >= 1) {
                result += s.length() - right;
                char lc = s.charAt(left++);
                count[lc - 'a'] -= 1;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfSubstrings numberOfSubstrings = new NumberOfSubstrings();
        int result = numberOfSubstrings.numberOfSubstrings("bbaaacbbb");
        System.out.println(result);
    }

}
