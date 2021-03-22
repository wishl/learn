package com.gmy.leetcode.sliding_window;

/**
 * 句子 是由单个空格分隔的一组单词，且不含前导或尾随空格。
 *
 * 例如，"Hello World"、"HELLO"、"hello world hello world" 都是符合要求的句子。
 * 单词 仅 由大写和小写英文字母组成。且大写和小写字母会视作不同字符。
 *
 * 如果句子满足下述全部条件，则认为它是一个 回环句 ：
 *
 * 单词的最后一个字符和下一个单词的第一个字符相等。
 * 最后一个单词的最后一个字符和第一个单词的第一个字符相等。
 * 例如，"leetcode exercises sound delightful"、"eetcode"、"leetcode eats soul" 都是回环句。然而，"Leetcode is cool"、"happy Leetcode"、"Leetcode" 和 "I like Leetcode" 都 不 是回环句。
 *
 * 给你一个字符串 sentence ，请你判断它是不是一个回环句。如果是，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/circular-sentence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsCircularSentence {

    public boolean isCircularSentence(String sentence) {
        String[] split = sentence.split(" ");
        boolean result = true;
        for (int i = 0; i < split.length; i++) {
            String stringAt = split[i];
            if (i == split.length - 1) {
                result = result && stringAt.charAt(stringAt.length() - 1) == split[0].charAt(0);
            } else {
                result = result && stringAt.charAt(stringAt.length() - 1) == split[i + 1].charAt(0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        IsCircularSentence isCircularSentence = new IsCircularSentence();
        boolean result = isCircularSentence.isCircularSentence("leetcode exercises sound delightful");
        System.out.println(result);
    }
}
