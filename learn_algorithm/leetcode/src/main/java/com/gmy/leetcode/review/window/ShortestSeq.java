package com.gmy.leetcode.review.window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 *
 * https://leetcode.cn/problems/shortest-supersequence-lcci/description/
 */
public class ShortestSeq {

    public int[] shortestSeq(int[] big, int[] small) {
        int start = 0, end = 0, differ = small.length, maxLength = Integer.MAX_VALUE;
        int[] result = new int[2];
        // 出现次数
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i : small) {
            cache.put(i, cache.getOrDefault(i, 0) + 1);
        }
        while (end < big.length) {
            int num = big[end++];
            if (cache.containsKey(num)) {
                if (cache.get(num) == 1) {
                    differ--;
                }
                cache.put(num, cache.get(num) - 1);
            }
            while (differ == 0) {
                if ((end - start) < maxLength) {
                    maxLength = end - start;
                    result[0] = start;
                    result[1] = end - 1;
                }
                int startNum = big[start++];
                if (cache.containsKey(startNum)) {
                    if (cache.get(startNum) == 0) {
                        differ++;
                    }
                    cache.put(startNum, cache.get(startNum) + 1);
                }
            }
        }
        return maxLength == Integer.MAX_VALUE ? new int[0] : result;
    }

    public static void main(String[] args) {
        ShortestSeq shortestSeq = new ShortestSeq();
        int[] big = new int[] {1, 2, 3, 1, 2, 3, 1, 2, 3};
        int[] small = new int[] {1, 1, 1};
        int[] result = shortestSeq.shortestSeq(big, small);
        System.out.println(Arrays.toString(result));
    }

}
