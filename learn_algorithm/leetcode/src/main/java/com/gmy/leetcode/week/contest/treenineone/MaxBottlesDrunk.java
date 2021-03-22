package com.gmy.leetcode.week.contest.treenineone;

/**
 * 给你两个整数 numBottles 和 numExchange 。
 * numBottles 代表你最初拥有的满水瓶数量。在一次操作中，你可以执行以下操作之一：
 * 喝掉任意数量的满水瓶，使它们变成空水瓶。
 * 用 numExchange 个空水瓶交换一个满水瓶。然后，将 numExchange 的值增加 1 。
 * 注意，你不能使用相同的 numExchange 值交换多批空水瓶。例如，如果 numBottles == 3
 * 并且 numExchange == 1 ，则不能用 3 个空水瓶交换成 3 个满水瓶。
 *
 *
 * 返回你 最多 可以喝到多少瓶水。
 */
public class MaxBottlesDrunk {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = numBottles, result = numBottles;
        while (empty >= numExchange) {
            // 交换并且喝掉
            empty -= numExchange - 1;
            result++;
            numExchange++;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxBottlesDrunk maxBottlesDrunk = new MaxBottlesDrunk();
        int result = maxBottlesDrunk.maxBottlesDrunk(10, 3);
        System.out.println(result);
    }
}
