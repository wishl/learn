package com.gmy.leetcode.graph;

import com.google.common.collect.Lists;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * https://leetcode.cn/problems/course-schedule/description/
 */
public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
        Arrays.fill(courses, 0);
        HashMap<Integer, List<Integer>> needUnlock = new HashMap<>();
        for(int[] pair : prerequisites) {
            int target = pair[0];
            int need = pair[1];
            final List<Integer> orDefault = needUnlock.getOrDefault(need, new ArrayList<>());
            orDefault.add(target);
            needUnlock.put(need,orDefault);
            courses[target]++;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (courses[i] == 0) {
                deque.addLast(i);
            }
        }
        while(!deque.isEmpty()) {
            final Integer c = deque.pollFirst();
            if ( needUnlock.containsKey(c)) {
                final List<Integer> integers = needUnlock.get(c);
                for (int i : integers) {
                    if (courses[i] > 0) {
                        courses[i] --;
                    }
                    if (courses[i] == 0) {
                        deque.addLast(i);
                    }
                }
            }
            needUnlock.remove(c);
        }
        for (int c : courses) {
            if (c > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        boolean result = canFinish.canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}});
        System.out.println(result);
    }

}
