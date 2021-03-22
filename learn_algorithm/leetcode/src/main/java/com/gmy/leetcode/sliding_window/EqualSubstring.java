package com.gmy.leetcode.sliding_window;

import com.gmy.leetcode.sort.QuickSort;

/**
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s中的第i个字符变到t中的第 i 个字符需要|s[i] - t[i]|的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * 用于变更字符串的最大预算是maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/get-equal-substrings-within-budget
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：s = "abcd", t = "bcdf", maxCost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 *
 * 输入：s = "abcd", t = "cdef", maxCost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 *
 * 输入：s = "abcd", t = "acde", maxCost = 0
 * 输出：1
 * 解释：a -> a, cost = 0，字符串未发生变化，所以最大长度为 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/get-equal-substrings-within-budget
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {
        int max = 0;
        int[] diff = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0, right = 0;
        int sum = 0;
        while (right < s.length()) {
            sum += diff[right];
            while (sum > maxCost) {
                sum -= diff[left];
                left++;
            }
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }


    public static void main(String[] args) {
        EqualSubstring equalSubstring = new EqualSubstring();
        String s = "abcd";
        String t = "bcdf";
        int result = equalSubstring.equalSubstring(s, t, 3);
        System.out.println(result);
    }
}
