package com.gmy.leetcode.labuladong;

import java.util.Arrays;

/**
 * 有三种葡萄，每种分别有 a, b, c 颗，现在有三个人，第一个人只吃第一种和第二种葡萄，
 * 第二个人只吃第二种和第三种葡萄，第三个人只吃第一种和第三种葡萄。
 * 现在给你输入 a, b, c 三个值，请你适当安排，让三个人吃完所有的葡萄，算法返回吃的最多的人最少要吃多少颗葡萄。
 * https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/chi-pu-tao
 */
public class Grape {

    public long splitGrape(long a, long b, long c) {
        long[] nums = {a, b, c};
        Arrays.sort(nums);
        if (nums[0] + nums[1] >= nums[2]) {
            return (a + b + c + 2) / 3;
        } else {
            return (c + 1) / 2;
        }
    }

}
