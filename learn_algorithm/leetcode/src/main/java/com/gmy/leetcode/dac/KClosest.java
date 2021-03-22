package com.gmy.leetcode.dac;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个数组 points，其中points[i] = [xi, yi]表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
 * 这里，平面上两点之间的距离是欧几里德距离（√(x1- x2)2+ (y1- y2)2）。
 * 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KClosest {

    public int[][] kClosest(int[][] points, int k) {
        Queue<Distance> queue = new PriorityQueue<>((d1, d2) -> d2.distance.compareTo(d1.distance));
        for (int[] point : points) {
            Distance distance = getDistance(point);
            queue.offer(distance);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[][] result = new int[k][];
        int index = 0;
        while (!queue.isEmpty()) {
            Distance poll = queue.poll();
            result[index++] = poll.point;
        }
        return result;
    }

    private Distance getDistance(int[] point) {
        double x = Math.pow(Double.parseDouble(point[0] + ""), 2);
        double y = Math.pow(Double.parseDouble(point[1] + ""), 2);
        double distance = Math.sqrt(new BigDecimal(x + "").add(new BigDecimal(y + "")).doubleValue());
        Distance distancePoint = new Distance(distance, point);
        return distancePoint;
    }

    @AllArgsConstructor
    class Distance {
        private Double distance;
        private int[] point;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][] {{3,3},{5,-1},{-2,4}};
        KClosest kClosest = new KClosest();
        int[][] result = kClosest.kClosest(ints, 2);
        System.out.println(Arrays.toString(result));
    }

}
