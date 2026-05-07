package com.gmy.leetcode.lingcha.window.max_count;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣嘉年华的花店中从左至右摆放了一排鲜花，记录于整型一维矩阵 flowers 中每个数字表示该位置所种鲜花的品种编号。你可以选择一段区间的鲜花做成插花，且不能丢弃。 在你选择的插花中，如果每一品种的鲜花数量都不超过 cnt 朵，那么我们认为这束插花是 「美观的」。
 * 例如：[5,5,5,6,6] 中品种为 5 的花有 3 朵， 品种为 6 的花有 2 朵，每一品种 的数量均不超过 3
 * 请返回在这一排鲜花中，共有多少种可选择的区间，使得插花是「美观的」。
 * 注意：
 * 结果无需取模，用例保证输出为 int32 范围内的整数。
 */
public class BeautifulBouquet {

    public int beautifulBouquet(int[] flowers, int cnt) {
        int left = 0, result = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int right = 0; right < flowers.length; right++) {
            count.merge(flowers[right], 1, Integer::sum);
            while (count.get(flowers[right]) > cnt) {
                count.merge(flowers[left], -1, Integer::sum);
                left++;
            }
            result += (right - left + 1);
        }
        return result;
    }

}
