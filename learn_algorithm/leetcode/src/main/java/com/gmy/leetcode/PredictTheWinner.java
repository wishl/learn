package com.gmy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PredictTheWinner {

    private static Map<Integer, Integer> map = new HashMap<>();
    private static int aMax;

    public static boolean predictTheWinner(int[] nums) {
        return getResult(0, nums.length - 1, nums, 1) >= 0;
    }

    private static int getResult(int left, int right, int[] nums, int turn) {
        if(right == left) {
            return nums[left] * turn;
        }
        int start = nums[left] * turn + getResult(left + 1, right, nums, -turn);
        int end = nums[right] * turn + getResult(left, right - 1, nums, -turn);
        return Math.max(start * turn, end * turn) * turn;
    }

    public static void main(String[] args) {
        boolean b = predictTheWinner(new int[]{1, 89, 3});
        System.out.println(b);
    }

}
