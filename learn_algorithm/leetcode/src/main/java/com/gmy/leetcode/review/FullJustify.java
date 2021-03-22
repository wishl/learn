package com.gmy.leetcode.review;

import com.google.common.collect.Lists;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 注意:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词
 *
 * 示例 1:
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 * 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词
 *
 * https://leetcode.cn/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class FullJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int rowLength = 0;
        List<String> wordListPreRow = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int totalLength = words.length;
        for (int i = 0; i < totalLength; i++) {
            // 计算当前行可以放下多少个单词
            String word = words[i];
            Pair<Boolean, String> canInsert = canInThisRow(wordListPreRow, word, rowLength, maxWidth);
            // 如果可以放下 就继续放 否则格式化
            if (canInsert.getKey()) {
                rowLength += canInsert.getValue().length();
                wordListPreRow.add(canInsert.getValue());
            } else {
                String formatted = formatString(wordListPreRow, i - 1, totalLength - 1, rowLength, maxWidth);
                result.add(formatted);
                wordListPreRow = new ArrayList<>();
                rowLength = 0;
                i--;
            }
        }
        String formatted = formatString(wordListPreRow, totalLength - 1, totalLength - 1, rowLength, maxWidth);
        result.add(formatted);
        return result;
    }

    /**
     * 计算当前行是否可以放下这个单词
     * @return
     */
    private Pair<Boolean, String> canInThisRow(List<String> wordListPreRow, String word, int length, int maxWidth) {
        // 第一个放入
        boolean isFirst = wordListPreRow.size() == 0;
        // 如果不是第一个单词 需要在前面加空格
        if (!isFirst) {
            word = " " + word;
        }
        return new Pair<>(length + word.length() <= maxWidth, word);
    }

    /**
     * 计算空格
     * @param wordListPreRow
     * @param row
     * @param totalRow
     * @return
     */
    private String formatString(List<String> wordListPreRow, int allWordCount, int totalWordCount, int rowLength,
                                int maxWidth) {
        if (wordListPreRow == null || wordListPreRow.size() == 0) {
            return "";
        }
        int wordCount = wordListPreRow.size();
        int totalBlank = maxWidth - rowLength;
        String blank = " ";
        if (allWordCount == totalWordCount || wordCount == 1) {
            // 最后一行在右侧拼接空格 或者 这一行只有一个单词 左对齐
            StringBuilder lastWord = new StringBuilder(wordListPreRow.get(wordCount - 1));
            for (int i = 0; i < totalBlank; i++) {
                lastWord.append(" ");
            }
            return lastWord.toString();
        } else {
            // 如果不是最后一行 且 不止一个单词 在非最后的单词后面都拼接空格
            for (int i = 1; i < wordCount - 1 && totalBlank > 0; i++) {
                wordListPreRow.set(i, wordListPreRow.get(i) + blank);
                totalBlank--;
            }
        }
        return String.join("", wordListPreRow);
    }

    public static void main(String[] args) {
        FullJustify fullJustify = new FullJustify();
        String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> strings = fullJustify.fullJustify(words, 16);
        System.out.println(strings);
    }

}
