package com.gmy.leetcode.dac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @See com.gmy.leetcode.dac.TopKFrequent
 */
public class TopKFrequentReview {

    /**
     * 快排解法，先计数 然后问题转化为获取前k个最大的数
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer num = entry.getKey();
            Integer value = entry.getValue();
            int[] is = {num, value};
            queue.offer(is);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }

    /**
     * 快速排序解决问题
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }
        int[][] numsCount = new int[countMap.size()][];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int[] countValue = new int[] {entry.getKey(), entry.getValue()};
            numsCount[i++] = countValue;
        }
        return find(numsCount, k - 1, 0, numsCount.length - 1);
    }

    public int[] find(int[][] numCount, int k, int left, int right) {
        if (left > right) {
            return new int[k];
        }
        int partition = partition(numCount, left, right);
        if (partition < k) {
            int[] result = find(numCount, k, partition + 1, right);
            // 加入左边数据
            for (int i = left; i <= partition; i++) {
                result[i] = numCount[i][0];
            }
            return result;
        } else if (partition > k) {
            return find(numCount, k, left, partition - 1);
        } else {
            int[] result = new int[k + 1];
            for (int i = left; i <= partition; i++) {
                result[i] = numCount[i][0];
            }
            return result;
        }
    }


    private int partition(int[][] numCount, int left, int right) {
        int prov = left, i = prov + 1;
        for (int j = left + 1; j <= right; j++) {
            if (numCount[j][1] > numCount[prov][1]) {
                swap(numCount, i++, j);
            }
        }
        swap(numCount, prov, i - 1);
        return i - 1;
    }

    private void swap(int[][] numCount, int left, int right) {
        int[] tmp = numCount[left];
        numCount[left] = numCount[right];
        numCount[right] = tmp;
    }


    public static void main(String[] args) {
        int[] is = new int[] {1};
        TopKFrequentReview topKFrequent = new TopKFrequentReview();
//        int[] ints = topKFrequent.topKFrequent(is, 2);
//        System.out.println(Arrays.toString(ints));
        int[] ints1 = topKFrequent.topKFrequent1(is, 1);
        System.out.println(Arrays.toString(ints1));
    }
}
