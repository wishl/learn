package com.gmy.leetcode.lingcha.half;

/**
 * 给你一个字符数组 letters，该数组按 非递减顺序 排序，以及一个字符 target。letters 里至少有两个不同的字符。
 * 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。
 *
 * https://leetcode.cn/problems/find-smallest-letter-greater-than-target/description/
 */
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        // 这里转换成大于等于 target + 1的最小的index 就是大于target的最小index
        int index = find(letters, target + 1);
        if (index == letters.length) {
            return letters[0];
        }
        return letters[index];
    }

    /**
     * 计算出大于等于target的最小的index
     * @return
     */
    private int find(char[] letters, int target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
