package com.gmy.leetcode.dfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给你参与游戏的小伙伴总数 n ，和一个整数 k ，返回游戏的获胜者。
 * https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 */
public class FindTheWinner {

    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        int result = 1;
        while (queue.size() != 0) {
            for (int i = 1; i < k; i++) {
                Integer poll = queue.poll();
                queue.offer(poll);
            }
            result = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        FindTheWinner findTheWinner = new FindTheWinner();
        int theWinner = findTheWinner.findTheWinner(1, 5);
        System.out.println(theWinner);
    }

}
