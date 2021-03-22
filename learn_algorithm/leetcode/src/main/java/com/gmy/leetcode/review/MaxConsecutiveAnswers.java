package com.gmy.leetcode.review;

/**
 * 一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）
 * 或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。
 * （也就是连续出现 true 或者连续出现 false）。
 * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。
 * 除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
 * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
 * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 */
public class MaxConsecutiveAnswers {

    /**
     * 与 CharacterReplacement 方法类似 维护最大的窗口 并向右移动 知道末尾
     * @param answerKey
     * @param k
     * @return
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int start = 0, end = 0, maxCount = 0;
        int[] cache = new int[26];
        while (end < answerKey.length()) {
            int index = answerKey.charAt(end++) - 'A';
            cache[index]++;
            maxCount = Math.max(maxCount, cache[index]);
            if (end - start > maxCount + k) {
                cache[answerKey.charAt(start++) - 'A']--;
            }
        }
        return end - start;
    }

    public static void main(String[] args) {
        MaxConsecutiveAnswers maxConsecutiveAnswers = new MaxConsecutiveAnswers();
        int result = maxConsecutiveAnswers.maxConsecutiveAnswers("TTFF", 2);
        System.out.println(result);
    }
}
