package com.gmy.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 *
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 *
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中 0<= i <j <k <n
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-number-of-teams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumTeams {

    /**
     * 获取把当前index当做中点，通过前后判断数量再相乘
     * @param rating
     * @return
     */
    public int numTeams(int[] rating) {
        int count = 0;
        for (int i = 1; i < rating.length; i++) {
            int leftLess = 0;
            int leftMore = 0;
            int rightLess = 0;
            int rightMore = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (rating[j] > rating[i]) {
                    leftMore++;
                } else if (rating[j] < rating[i]) {
                    leftLess++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > rating[i]) {
                    rightMore++;
                } else if (rating[j] < rating[i]) {
                    rightLess++;
                }
            }
            count += (leftLess * rightMore + leftMore * rightLess);
        }
        return count;
    }

    /**
     * 用两棵树状数组优化以上算法
     * @param args
     */
    public int numTeams1(int[] rating) {
        int count = 0;
        ArrayTree numTree = new ArrayTree(rating);
        Map<Integer, Integer> ascMap = disCount(rating, false);
        int[] leftLess = new int[rating.length];
        int[] leftMore = new int[rating.length];
        int[] rightLess = new int[rating.length];
        int[] rightMore = new int[rating.length];
        int length = rating.length;
        for (int i = 0; i < length; i++) {
            Integer index = ascMap.get(rating[i]);
            numTree.add(index, 1);
            // 减去自己
            int less = numTree.sum(index) - 1;
            int total = numTree.sum(length) - 1;
            leftLess[i] = less;
            leftMore[i] = total - less;
        }
        numTree = new ArrayTree(rating);
        for (int i = length - 1; i >= 0; i--) {
            Integer index = ascMap.get(rating[i]);
            numTree.add(index, 1);
            // 减去自己
            int less = numTree.sum(index) - 1;
            int total = numTree.sum(length) - 1;
            rightLess[i] = less;
            rightMore[i] = total - less;
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += (leftLess[i] * rightMore[i]) + (leftMore[i] * rightLess[i]);
        }
        return result;
    }

    private Map<Integer, Integer> disCount(int[] rating, boolean desc) {
        List<Integer> sorted;
        if (desc) {
            sorted = Arrays.stream(rating).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        } else {
            sorted = Arrays.stream(rating).boxed().sorted().collect(Collectors.toList());
        }
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < sorted.size(); i++) {
            resultMap.put(sorted.get(i), i + 1);
        }
        return resultMap;
    }

    static class ArrayTree {

        int[] nums;

        public ArrayTree(int[] nums) {
            this.nums = new int[nums.length + 1];
        }

        private int lowBit(int x) {
            return x & -x;
        }

        private int sum(int index) {
            int result = 0;
            for (int i = index; i >= 1 ; i -= lowBit(i)) {
                result += nums[i];
            }
            return result;
        }

        private void add(int index, int num) {
            for (int i = index; i < nums.length; i += lowBit(i)) {
                nums[i] += num;
            }
        }
    }

    public static void main(String[] args) {
        NumTeams numTeams = new NumTeams();
        int count = numTeams.numTeams(new int[]{2, 5, 3, 4, 1});
        int count1 = numTeams.numTeams1(new int[]{2, 5, 3, 4, 1});
        System.out.println(count);
        System.out.println(count1);
    }

    static class Solution {
        int maxN;
        int[] c;
        List<Integer> disc;
        int[] iLess;
        int[] iMore;
        int[] kLess;
        int[] kMore;

        public int numTeams(int[] rating) {
            int n = rating.length;
            maxN = n + 2;
            c = new int[maxN];
            disc = new ArrayList<Integer>();
            for (int i = 0; i < n; ++i) {
                disc.add(rating[i]);
            }
            disc.add(-1);
            Collections.sort(disc);
            iLess = new int[n];
            iMore = new int[n];
            kLess = new int[n];
            kMore = new int[n];

            for (int i = 0; i < n; ++i) {
                int id = getId(rating[i]);
                iLess[i] = get(id);
                iMore[i] = get(n + 1) - get(id);
                add(id, 1);
            }

            c = new int[maxN];
            for (int i = n - 1; i >= 0; --i) {
                int id = getId(rating[i]);
                kLess[i] = get(id);
                kMore[i] = get(n + 1) - get(id);
                add(id, 1);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += iLess[i] * kMore[i] + iMore[i] * kLess[i];
            }

            return ans;
        }

        public int getId(int target) {
            int low = 0, high = disc.size() - 1;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (disc.get(mid) < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        public int get(int p) {
            int r = 0;
            while (p > 0) {
                r += c[p];
                p -= lowbit(p);
            }
            return r;
        }

        public void add(int p, int v) {
            while (p < maxN) {
                c[p] += v;
                p += lowbit(p);
            }
        }

        public int lowbit(int x) {
            return x & (-x);
        }
    }

}
