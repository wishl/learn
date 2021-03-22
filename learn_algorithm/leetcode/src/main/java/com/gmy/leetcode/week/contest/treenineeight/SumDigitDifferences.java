package com.gmy.leetcode.week.contest.treenineeight;

import com.gmy.leetcode.Sum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 车尔尼有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
 * 两个整数的 数位不同 指的是两个整数 相同 位置上不同数字的数目。
 * 请车尔尼返回 nums 中 所有 整数对里，数位不同之和。
 *
 * https://leetcode.cn/problems/sum-of-digit-differences-of-all-pairs/description/
 *
 * 输入：nums = [13,23,12]
 * 输出：4
 *
 * 解释：
 * 计算过程如下：
 * - 13 和 23 的数位不同为 1 。
 * - 13 和 12 的数位不同为 1 。
 * - 23 和 12 的数位不同为 2 。
 * 所以所有整数数对的数位不同之和为 1 + 1 + 2 = 4 。
 */
public class SumDigitDifferences {

    public long sumDigitDifferences(int[] nums) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.readLock().lock();
        return 0;
    }


    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        new Thread(() -> {
            lock.writeLock().lock();
            for (int i = 0; i < 3; i++) {
                System.out.println(111);
            }
        }).start();
        new Thread(() -> {
            lock.readLock().lock();
            for (int i = 0; i < 3; i++) {
                System.out.println(222);
            }
        }).start();
    }

}
