package com.gmy.leetcode.monostone_stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 在一条单行道上，有 n 辆车开往同一目的地。目的地是几英里以外的target。
 * 给定两个整数数组position和speed，长度都是 n ，其中position[i]是第 i 辆车的位置，speed[i]是第 i 辆车的速度(单位是英里/小时)。
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车 以相同的速度 紧接着行驶。此时，我们会忽略这两辆车之间的距离，
 * 也就是说，它们被假定处于相同的位置。车队是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * 返回到达目的地的 车队数量 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/car-fleet
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CarFleet {

    /**
     * 先计算距离重点差的时间 在通过单调栈计算之后时间小于等于的
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Integer> deque = new LinkedList<>();
        double[] times = calTime(target, position, speed);
        for (int i = 0; i < times.length; i++) {
            while (!deque.isEmpty() && times[i] >= times[deque.peek()]) {
                deque.pop();
            }
            deque.push(i);
        }
        return deque.size();
    }

    private double[] calTime(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new HashMap<>();
        sort(position, map);
        double[] times = new double[position.length];
        for (int i = 0; i < position.length; i++) {
            int leftLength = target - position[i];
            times[i] = (leftLength * 1.0D) / speed[map.get(position[i])];
        }
        return times;
    }

    /**
     * 按照距离终点的距离排序
     */
    private void sort(int[] position, Map<Integer, Integer> map) {
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], i);
        }
        Arrays.sort(position);
    }

    public static void main(String[] args) {
        int[] position = new int[] {6,8};
        int[] speed = new int[] {3,2};
        CarFleet carFleet = new CarFleet();
        int count = carFleet.carFleet(10, position, speed);
        System.out.println(count);
    }

    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
