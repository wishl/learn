package com.gmy.leetcode.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * 有一个书店老板，他的书店开了n分钟。每分钟都有一些顾客进入这家商店。
 * 给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，
 * 所有这些顾客在第 i 分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续minutes分钟不生气，但却只能使用一次。
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * 输出：16
 * 解释：书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSatisfied {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0, right = 0, max = 0, count = 0, useMinutes = 0;
        while (right < grumpy.length) {
            if (grumpy[right] == 0) {
                count += customers[right];
            }
            right++;
        }
        right = minutes;
        for (int i = 0; i < right; i++) {
            count += customers[i] * grumpy[i];
        }
        max = count;
        while (right < customers.length) {
            count += customers[right] * grumpy[right];
            count -= customers[left] * grumpy[left];
            right++;
            left++;
            max = Math.max(max, count);
        }
        return max;
    }

    public int maxSatisfied1(int[] customers, int[] grumpy, int minutes) {
        int left = 0, right = 0, max = 0, count = 0, useMinutes = 0;
        while (right < grumpy.length) {
            if (grumpy[right] == 0) {
                count += customers[right];
            }
            right++;
        }
        right = 0;
        Set<Integer> set = new HashSet<>();
        while (right < grumpy.length) {
            if (grumpy[right] == 0 && useMinutes != 0 && useMinutes < minutes) {
                useMinutes++;
                set.add(right);
            } else if (grumpy[right] == 1 && useMinutes < minutes) {
                count += customers[right];
                useMinutes++;
                set.add(right);
            } else if (useMinutes >= minutes) {
                if (grumpy[left] == 1) {
                    count -= customers[left];
                }
                if (set.contains(left)) {
                    useMinutes--;
                }
                left++;
                continue;
            }
            max = Math.max(count, max);
            right++;
        }
        return max;
    }


    public static void main(String[] args) {
        MaxSatisfied maxSatisfied = new MaxSatisfied();
        // [10,8,9,8,9,1,2]
        //[1,0,1,1,0,0,0]
        //2
        //[2,6,6,9]
        //[0,0,1,1]
        int[] customers = {3};
        int[] grumpy = {1};
        int result = maxSatisfied.maxSatisfied(customers, grumpy, 1);
        int result1 = maxSatisfied.maxSatisfied1(customers, grumpy, 1);
        System.out.println(result);
        System.out.println(result1);
    }
}
