package com.gmy.leetcode.sliding_window;

/**
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 *
 * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }

    public int characterReplacement1(String s, int k) {
        int left = 0, right = 0, result = 0, tmp = k, firstNotSame = 0;
        while (right < s.length()) {
            if (s.charAt(right) != s.charAt(left)) {
                if (tmp == k) {
                    firstNotSame = right;
                }
                if (tmp - 1 >= 0) {
                    tmp--;
                } else {
                    tmp = k;
                    left = firstNotSame;
                    right = left;
                }
            }
            int min = Math.min(s.length(), right - left + 1 + tmp);
            result = Math.max(result, min);
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        int result = characterReplacement.characterReplacement("AAABAAAABCDEFG", 4);
        System.out.println(result);
    }

}
