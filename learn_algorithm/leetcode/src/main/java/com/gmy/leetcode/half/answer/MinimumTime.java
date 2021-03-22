package com.gmy.leetcode.half.answer;

import java.util.Arrays;

/**
 * 给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。
 * 每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，
 * 也就是说可以同时有多辆公交车在运行且互不影响。
 * 给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。
 *
 * https://leetcode.cn/problems/minimum-time-to-complete-trips/description/
 */
public class MinimumTime {

    /**
     * 二分答案
     * @return
     */
    public long minimumTime(int[] time, int totalTrips) {
        // [left, right] 维护未知范围
        long maxTime = Arrays.stream(time).max().orElse(0);
        long left = 0, right = maxTime * totalTrips;
        while (left <= right) {
            long mid = (left + right) / 2;
            long tripsTime = getTripsTime(time, mid);
            // 如果 tripsTime >= totalTrips 说明mid大了 right减小
            if (tripsTime >= totalTrips) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }

    private long getTripsTime(int[] time, long totalTime) {
        long result = 0;
        for (int i = 0; i < time.length; i++) {
            result += totalTime / time[i];
        }
        return result;
    }


    public static void main(String[] args) {
        MinimumTime minimumTime = new MinimumTime();
        long result = minimumTime.minimumTime(new int[]{1,2,3}, 5);
        System.out.println(result);
    }
}
