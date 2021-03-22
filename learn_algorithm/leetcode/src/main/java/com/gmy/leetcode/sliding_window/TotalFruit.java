package com.gmy.leetcode.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 *
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。
 * 采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fruit-into-baskets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TotalFruit {

    /**
     * 自己的滑动窗口解
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int max = 0;
        int right = 0, left = 0, firstChange = 0;
        Set<Integer> set = new HashSet<>();
        while (right < fruits.length) {
            set.add(fruits[right]);
            if (set.size() > 2) {
                removeSet(set, fruits, right, left);
                max = Math.max(max, right - left);
                left = firstChange;
            }
            if (right != 0 && fruits[right - 1] != fruits[right]) {
                firstChange = right;
            }
            right++;
        }
        max = Math.max(max, right - left);
        return max;
    }

    public int totalFruit1(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }


    // 删除第一个不等于 right - 1 的值
    private void removeSet(Set<Integer> set, int[] fruits, int right, int left) {
        for (int i = left; i < right; i++) {
            if (fruits[i] != fruits[right - 1]) {
                set.remove(fruits[i]);
                break;
            }
        }
    }

    public static void main(String[] args) {
        TotalFruit totalFruit = new TotalFruit();
        // 3,3,3,1,2,1,1,2,3,3,4
        // 1,0,1,4,1,4,1,2,3
        // 5,1,4,1,4,2
        int result = totalFruit.totalFruit1(new int[]{1,0,1,4,1,4,1,2,3});
        System.out.println(result);
    }
}
