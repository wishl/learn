package com.gmy.leetcode.lingcha.window.fixed;

import java.util.Arrays;

/**
 * @Author Guanmengyuan
 * @Date Created in 20:29 2026/5/2
 */
public class MaxScore {

    public int maxScore(int[] cardPoints, int k) {
        int total = Arrays.stream(cardPoints).sum();
        int left = 0, result = Integer.MAX_VALUE, sum = 0;
        for (int right = 0; right < cardPoints.length; right++) {
            sum += cardPoints[right];
            while ((right - left + 1) > (cardPoints.length - k)) {
                sum -= cardPoints[left++];
            }
            if ((right - left + 1) == (cardPoints.length - k)) {
                result = Math.min(result, sum);
            }
        }
        return total - result;
    }

    public static void main(String[] args) {
        int [] ints = {1,2,3,4,5,6,1};
        System.out.println(new MaxScore().maxScore(ints, 3));
    }

}
