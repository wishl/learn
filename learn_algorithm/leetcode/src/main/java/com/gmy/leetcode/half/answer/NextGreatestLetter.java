package com.gmy.leetcode.half.answer;

/**
 * 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
 * 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。
 *
 * https://leetcode.cn/problems/find-smallest-letter-greater-than-target/description/
 */
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        // left 左边是严格小于target的 right 右边是大于等于target的
        // [left, right]
        while (left <= right) {
            int mid = (left + right) / 2;
            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (right + 1) == letters.length ? letters[0] : letters[right + 1];
    }


    public static void main(String[] args) {
        NextGreatestLetter nextGreatestLetter = new NextGreatestLetter();
        char result = nextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c');
        System.out.println(result);
    }

}
