package com.gmy.leetcode.dac;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int[] is = new int[] {entry.getKey(), entry.getValue()};
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

    private int partition(int[] nums, int left, int right) {
        int prov = left, index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[prov] <= nums[i]) {
                swap(nums, index++, i);
            }
        }
        swap(nums, prov, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[right] = nums[left];
        nums[left] = tmp;
    }

    public static void main(String[] args) {
//        int[] is = new int[] {1,1,1,2,2,3};
//        TopKFrequent topKFrequent = new TopKFrequent();
//        int[] ints = topKFrequent.topKFrequent(is, 2);
//        System.out.println(Arrays.toString(ints));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        priorityQueue.offer(5);
        priorityQueue.offer(4);
        priorityQueue.offer(3);
        priorityQueue.offer(2);
        priorityQueue.offer(1);
        priorityQueue.poll();
        priorityQueue.poll();
        priorityQueue.poll();
    }

}
