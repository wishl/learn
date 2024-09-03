package com.gmy.leetcode.review.prefix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组 cards ，其中 cards[i] 表示第 i 张卡牌的 值 。如果两张卡牌的值相同，则认为这一对卡牌 匹配 。
 * 返回你必须拿起的最小连续卡牌数，以使在拿起的卡牌中有一对匹配的卡牌。如果无法得到一对匹配的卡牌，返回 -1 。
 *
 * https://leetcode.cn/problems/minimum-consecutive-cards-to-pick-up/description/
 *
 * 示例 1：
 *
 * 输入：cards = [3,4,2,3,4,7]
 * 输出：4
 * 解释：拿起卡牌 [3,4,2,3] 将会包含一对值为 3 的匹配卡牌。注意，拿起 [4,2,3,4] 也是最优方案。
 * 示例 2：
 *
 * 输入：cards = [1,0,5,3]
 * 输出：-1
 * 解释：无法找出含一对匹配卡牌的一组连续卡牌。
 */
public class MinimumCardPickup {

    /**
     * 前缀方式解决
     * @param cards
     * @return
     */
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> cache = new HashMap<>();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];
            Integer lastIndex = cache.getOrDefault(card, cache.getOrDefault(card, -1));
            if (lastIndex != -1) {
                result = Math.min(i - lastIndex + 1, result);
            }
            cache.put(card, i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * 滑动窗口
     * @param cards
     * @return
     */
    public int minimumCardPickup1(int[] cards) {
        Set<Integer> set = new HashSet<>();
        int start = 0, end = 0, result = Integer.MAX_VALUE;
        while (end < cards.length) {
            int card = cards[end++];
            while (set.contains(card)) {
                result = Math.min(result, end - start);
                set.remove(cards[start++]);
            }
            set.add(card);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        MinimumCardPickup minimumCardPickup = new MinimumCardPickup();
        int result = minimumCardPickup.minimumCardPickup(new int[]{3,4,4,2,3,7});
        int result1 = minimumCardPickup.minimumCardPickup1(new int[]{3,4,4,2,3,7});
        System.out.println(result);
        System.out.println(result1);
    }

}
