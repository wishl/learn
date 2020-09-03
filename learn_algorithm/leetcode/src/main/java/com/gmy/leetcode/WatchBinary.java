package com.gmy.leetcode;

import com.sun.jmx.snmp.SnmpNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WatchBinary {

    private static int[] hour = new int[4];

    private static int[] min = new int[6];

    public static List<String> readBinaryWatch(int num) {
        hour[0] = 1;
        hour[1] = 2;
        hour[2] = 4;
        hour[3] = 8;

        min[0] = 1;
        min[1] = 2;
        min[2] = 4;
        min[3] = 8;
        min[4] = 16;
        min[5] = 32;
        List<String> result = new ArrayList<>();
        getResult(num, result, 0, 0, 0, 0, 0);
        return result;
    }

    // 回溯算法
    private static void getResult(int num, List<String> result, int h, int m, int hIndex, int mIndex, int time) {
        if (time == num) {
            String s =  h + ":" +(m < 10 ? "0"+m:m+"");
            result.add(s);
            return;
        }
        for (int i = hIndex; i < hour.length; i++) {
            if (h + hour[i] > 11) {
                break;
            }
            getResult(num, result, h + hour[i], m, i + 1, mIndex, time + 1);
        }
        for (int i = mIndex; i < min.length; i++) {
            if (m + min[i] > 59) {
                break;
            }
            getResult(num, result, h, m + min[i], hour.length, i + 1, time + 1);
        }
    }

    // 位运算
    public static List<String> readBinaryWatch1(int num) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (getCount1(i) + getCount1(j) == num) {
                    result.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return result;
    }

    // 获取一个数的2进制中1的个数
    private static int getCount1(int i) {
        int res = 0;
        while (i != 0) {
            // 去除最低位的1
            i = i & (i - 1);
            res++;
        }
        return res;
    }



    public static void main(String[] args) {
//        List<String> strings = readBinaryWatch(2);
//        System.out.println(strings);
//        List<String> strings1 = readBinaryWatch1(2);
//        System.out.println(strings1);
        getCount1(2);
    }

}
