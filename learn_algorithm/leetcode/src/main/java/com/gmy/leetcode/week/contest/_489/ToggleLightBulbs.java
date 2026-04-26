package com.gmy.leetcode.week.contest._489;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 bulbs，其中每个元素的取值范围为 1 到 100。
 * 有 100 个电灯泡，按从 1 到 100 编号，初始时所有灯泡均为关闭状态。
 * 对于数组 bulbs 中的每一个元素 bulbs[i]，执行以下操作：
 * 如果第 bulbs[i] 个灯泡当前是关闭状态，将其打开。
 * 如果第 bulbs[i] 个灯泡当前是打开状态，将其关闭。
 * 返回一个整数列表，表示最终处于打开状态的灯泡编号，按升序排列。如果没有灯泡是打开的，返回一个空列表。
 */
public class ToggleLightBulbs {

    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < bulbs.size(); i++) {
            boolean add = result.add(bulbs.get(i));
            if (!add) {
                result.remove(bulbs.get(i));
            }
        }
        return new ArrayList<>(result).stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ToggleLightBulbs toggleLightBulbs = new ToggleLightBulbs();
        List<Integer> bulbs = toggleLightBulbs.toggleLightBulbs(Lists.newArrayList(10,30,20,10));
        System.out.println(bulbs);
    }

}
