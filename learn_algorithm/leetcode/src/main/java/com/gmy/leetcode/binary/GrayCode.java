package com.gmy.leetcode.binary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
 * 每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
 * 第一个整数是 0
 * 一个整数在序列中出现 不超过一次
 * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
 * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gray-code
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GrayCode {

    private Deque<Integer> result;

    public List<Integer> grayCode(int n) {
        this.result = new ArrayDeque<>();
        int max = (1 << n);
        boolean[] used = new boolean[max];
        dfs(max, used, 0);
        return new ArrayList<>(result);
    }

    public List<Integer> grayCode1(int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < 1 << n; ++i)
            ret.add(i ^ i >> 1);
        return ret;
    }

    private boolean dfs(int max, boolean[] used, int index) {
        if (result.size() > 0 && countBitDiff(index, result.getLast()) != 1) {
            return false;
        }
        this.result.addLast(index);
        if (this.result.size() == max) {
            if (countBitDiff(index, result.getFirst()) == 1) {
                return true;
            } else {
                this.result.removeLast();
                return false;
            }
        }
        used[index] = true;
        for (int j = 1; j < max; j++) {
            if (!used[j]) {
                boolean flag = dfs(max, used, j);
                if (!flag) {
                    continue;
                } else {
                    return true;
                }
            }
        }
        this.result.removeLast();
        used[index] = false;
        return false;
    }


    public int countBitDiff(int num1, int num2) {
        int dif=num1^num2;
        int count=0;
        while(dif!=0){
            dif &= (dif-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        List<Integer> result = grayCode.grayCode1(10);
        System.out.println(result);
        for (int i = 0; i < result.size() - 1; i++) {
            System.out.println(grayCode.countBitDiff(result.get(i), result.get(i + 1)));
        }
        System.out.println(grayCode.countBitDiff(result.get(0), result.get(result.size() - 1)));
    }

}
