package com.gmy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 */
public class RangeBitwiseAnd {

    // 相当于求公共前缀
    public static int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (n > m) {
            m = m >> 1;
            n = n >> 1;
            shift++;
        }
        return n >> shift;
    }

//    Brian Kernighan 算法
//    每次 n & (n - 1) 就是把最右边的1去掉，直到值小于n，就求出了公共前缀 >> shift位
    public static int rangeBitwiseAnd1(int m, int n) {
        while (m > n) {
            n = n & (n - 1);
        }
        return n;
    }


    private static void getBytes(int m, int n) {
        List<Integer> mList = new ArrayList<>();
        List<Integer> nList = new ArrayList<>();
        while (m != 0 || n != 0) {
            if (m != 0) {
                mList.add(m % 2);
                m /= 2;
            }
            if (n != 0) {
                nList.add(n % 2);
                n /= 2;
            }
        }
        Collections.reverse(mList);
        Collections.reverse(nList);
        System.out.println(mList + "size" + mList.size());
        System.out.println(nList + "size" + nList.size());
    }

    public static void main(String[] args) {
        int result = rangeBitwiseAnd(700000000,
                2147483641);
        System.out.println(result);
    }

}
