package com.gmy.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 *
 * 实现 MovingAverage 类：
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val)成员函数 next每次调用的时候都会往滑动窗口增加一个整数，
 * 请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/qIsx9U
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingAverage {

    private List<Integer> nums;
    private int sum;
    private int left;
    private int size;

    public MovingAverage(int size) {
        this.nums = new ArrayList<>();
        this.left = 0;
        this.size = size;
    }

    public double next(int val) {
        nums.add(val);
        sum += val;
        if (size < nums.size()) {
            sum -= nums.get(left);
            left++;
        }
        return (double) sum / (size > nums.size() ? nums.size() : size);
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }

}
