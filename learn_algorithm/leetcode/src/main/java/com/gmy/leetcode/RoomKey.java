package com.gmy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RoomKey {

    // low
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, Boolean> map = new HashMap<>();
        getResult(map, 0, rooms.get(0), rooms);
        for (int i = 1; i < rooms.size(); i++) {
            if (map.get(i) == null) {
                return false;
            }
        }
        return true;
    }

    public static void getResult(Map<Integer, Boolean> map, int index, List<Integer> inner, List<List<Integer>> rooms) {
        if (map.size() != 0 && index == 0) {
            return;
        }
        map.put(index, true);
        for (int i = 0; i < inner.size(); i++) {
            Integer innerIndex = inner.get(i);
            if (map.containsKey(innerIndex)) {
                continue;
            }
            getResult(map, innerIndex, rooms.get(innerIndex), rooms);
        }
    }

    public static boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        int map = 0;
        int result = getResult(map, 0, rooms.get(0), rooms);
        int i1 = 0x111;
//        int i = 0xFFFFFFFF >> (32 - rooms.size());
        int i = 0xFFFFFFFF >> i1;
        boolean flag = (result & i) == map;
        return flag;
    }

    public static int getResult(int map, int index, List<Integer> inner, List<List<Integer>> rooms) {
        if (map != 0 && index == 0) {
            return map;
        }
        map |= 1 << index;
        for (int i = 0; i < inner.size(); i++) {
            Integer innerIndex = inner.get(i);
            if ((map & 1 << innerIndex) != 0) {
                continue;
            }
            map = getResult(map, innerIndex, rooms.get(innerIndex), rooms);
        }
        return map;
    }

    public static void main(String[] args) {
        List<List<Integer>> param = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        inner.add(1);
        inner.add(2);
        List<Integer> inner1 = new ArrayList<>();
        inner.add(2);
        inner.add(2);
        inner.add(1);
        List<Integer> inner2 = new ArrayList<>();
        inner2.add(1);
//        List<Integer> inner3 = new ArrayList<>();
//        inner3.add(0);
        param.add(inner);
        param.add(inner1);
        param.add(inner2);
//        param.add(inner3);
        boolean b = canVisitAllRooms(param);
        System.out.println(b);
    }
    
}
