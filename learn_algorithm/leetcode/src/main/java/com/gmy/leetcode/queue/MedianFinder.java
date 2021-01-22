package com.gmy.leetcode.queue;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    public MedianFinder() {
        // 小顶堆
        large = new PriorityQueue<>();
        // 大顶堆
        small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }


    public double findMedian() {
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (large.peek() + small.peek()) / 2.0;
    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public void test() {
        small.offer(1);
        small.offer(3);
        small.offer(2);
        small.offer(4);
        small.offer(5);
        System.out.println(small);
        System.out.println(small.poll());
        System.out.println(small.poll());
        System.out.println(small.poll());
        System.out.println(small.poll());
        System.out.println(small.poll());
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.test();
//        medianFinder.addNum(1);
//        medianFinder.addNum(2);
//        medianFinder.addNum(3);
//        medianFinder.addNum(-1);
//        medianFinder.addNum(4);
//        System.out.println(medianFinder.findMedian());
    }

}
