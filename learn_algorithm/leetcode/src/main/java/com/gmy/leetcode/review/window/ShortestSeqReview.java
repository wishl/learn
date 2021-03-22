package com.gmy.leetcode.review.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 *
 * https://leetcode.cn/problems/shortest-supersequence-lcci/description/
 */
public class ShortestSeqReview {

    public int[] shortestSeq(int[] big, int[] small) {
        int[] result = new int[0];
        int start = 0, end = 0, differ = small.length, max = Integer.MAX_VALUE;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : small) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        while (end < big.length) {
            int endNum = big[end++];
            if (countMap.containsKey(endNum)) {
                if (countMap.get(endNum) > 0) {
                    differ--;
                }
                countMap.put(endNum, countMap.get(endNum) - 1);
            }
            while (differ == 0) {
                if (end - start < max) {
                    result = new int[] {start, end};
                }
                int startNum = big[start++];
                if (countMap.containsKey(startNum)) {
                    if (countMap.get(end) == 0) {
                        differ++;
                    }
                    countMap.put(endNum, countMap.get(startNum) + 1);
                }
            }
        }
        return result;
    }

}
