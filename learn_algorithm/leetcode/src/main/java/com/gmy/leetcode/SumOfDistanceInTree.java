package com.gmy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfDistanceInTree {

    // 对了，但是超时，动态规划
    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N - 1; i++) {
            int param = edges[i][0];
            int result = edges[i][1];
            initMap(map, param, result);
            initMap(map, result ,param);
        }
        int[] is = new int[N];
        for (int i = 0; i < N; i++) {
            int result = getResult(map, i, 0, -1, 1);
            is[i] = result;
        }
        return is;
    }

    private static void initMap(Map<Integer, List<Integer>> map, int param, int result) {
        List<Integer> list = map.get(param);
        if (list == null) {
            list = new ArrayList<>();
            map.put(param, list);
        }
        list.add(result);
    }

    private static int getResult(Map<Integer, List<Integer>> map, int num, int result, int export, int step) {
        List<Integer> list = map.get(num);
        if (list == null) {
            return result;
        }
        for (Integer integer : list) {
            if (integer == export) {
                continue;
            }
            result += step;
            result = getResult(map, integer, result, num, step + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] is = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        int[] result = sumOfDistancesInTree(5, is);
        System.out.println(Arrays.toString(result));
    }

}
